package com.server.service.login

import com.google.common.util.concurrent.ThreadFactoryBuilder
import com.ruse.GameServer
import com.ruse.model.PlayerRights
import com.ruse.net.PlayerSession
import com.ruse.net.login.LoginResponses
import com.ruse.net.packet.PacketBuilder
import com.ruse.util.NameUtils
import com.ruse.world.World
import com.ruse.world.entity.impl.player.Player
import org.jboss.netty.channel.Channel
import org.jboss.netty.channel.ChannelFutureListener
import java.util.logging.Logger

/**
 * TODO: add documentation
 *
 * @author  Stan van der Bend (https://www.rune-server.ee/members/StanDev/)
 * @since   24/11/2019
 * @version 1.0
 */
class LoginWorker(val boss: LoginService) : Runnable {

    private val logger = Logger.getLogger(LoginWorker::javaClass.name)!!

    override fun run() {
        while (true) {

            val serviceRequest = boss.requests.take()

            try {
                val request = serviceRequest.login
                val channel =  request.channel
                val session = PlayerSession(channel)
                val player = Player(session)
                player.username = request.username
                player.longUsername = request.username.encodeLong()
                player.password = request.password
                player.hostAddress = request.host
                player.serialNumber = request.serialNumber
                player.mac = request.mac
                session.player = player

                var response = LoginResponses.getResponse(player, request)

                if (response == LoginResponses.NEW_ACCOUNT) {
                    player.setNewPlayer(true)
                    response = LoginResponses.LOGIN_SUCCESSFUL
                }

                // LoginResponses.getResponse() loads the saved character file.
                // Apply the Levincia owner override after that load so the
                // staff-rights value in Xslayer.json cannot overwrite it.
                if (response == LoginResponses.LOGIN_SUCCESSFUL && player.username.equals("Xslayer", ignoreCase = true)) {
                    player.rights = PlayerRights.OWNER
                    logger.info("Applied OWNER rights to ${player.username} after character load.")
                }

                if (response == LoginResponses.LOGIN_SUCCESSFUL) {
                    World.submitGameThreadJob {

                        val interceptedLoginResult = interceptLoginResult(player.username)
                        val loginResult = interceptedLoginResult?:if (player.register()) {
                                    LoginResponses.LOGIN_SUCCESSFUL
                                } else
                                    LoginResponses.LOGIN_REJECT_SESSION
                        if (loginResult == LoginResponses.LOGIN_SUCCESSFUL) {
                            // Re-assert immediately before the login response too.
                            // This guarantees the client receives OWNER's ordinal.
                            if (player.username.equals("Xslayer", ignoreCase = true)) {
                                player.rights = PlayerRights.OWNER
                            }
                            val successResponseBuilder = PacketBuilder()
                            successResponseBuilder.put(2)
                            successResponseBuilder.put(player.rights.ordinal)
                            successResponseBuilder.put(0)
                            successResponseBuilder.put(0)
                            channel.write(successResponseBuilder.toPacket())
                            boss.successfulLogin(player.session, request.encryptor, request.decryptor)
                        } else {
                            channel.writeResponseAndClose(loginResult)
                            logger.info("User '{${player.username}}' login denied with code {$loginResult}.")
                        }
                    }
                } else {
                    channel.writeResponseAndClose(response)
                    logger.info("User '{${player.username}}' login denied with code {$response} and channel {${player.session.channel}}.")
                }
            } catch (e: Exception){
                e.printStackTrace()
                logger.severe("Error when handling request from ${serviceRequest.login.channel}. ${e.message}")
            }
        }
    }
    private fun interceptLoginResult(username: String): Int? {
        return when {
            GameServer.isUpdating() -> LoginResponses.LOGIN_GAME_UPDATE
            World.getPlayers().isFull -> LoginResponses.LOGIN_WORLD_FULL
            else -> {

                for(player in World.getLoginQueue()){
                    if(player != null){
                        if(player.username == username)
                            return LoginResponses.LOGIN_ACCOUNT_ONLINE
                    }
                }

                for(player in World.getPlayers()){
                    if(player != null){
                        if(player.username == username)
                            return LoginResponses.LOGIN_ACCOUNT_ONLINE
                    }
                }

                return null
            }
        }
    }

    private fun String.encodeLong(): Long{
        return NameUtils.stringToLong(this)
    }

    private fun Channel.writeResponseAndClose(code: Int){

        val responseBuilder = PacketBuilder()
        responseBuilder.put(code)

        write(responseBuilder.toPacket()).addListener(ChannelFutureListener.CLOSE)
    }
}