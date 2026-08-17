package com.ruse.world.content;

import com.ruse.GameSettings;
import com.ruse.model.GameMode;
import com.ruse.model.PlayerRights;
import com.ruse.model.container.impl.Equipment;
import com.ruse.util.Misc;
import com.ruse.world.content.combat.prayer.PrayerHandler;
import com.ruse.world.content.minigames.impl.TreasureHunter;
import com.ruse.world.content.serverperks.ServerPerks;
import com.ruse.world.content.skill.impl.summoning.BossPets;
import com.ruse.world.content.skill.impl.summoning.Familiar;
import com.ruse.world.entity.impl.player.Player;
import mysql.impl.Store;

public class CustomDropUtils {

    /**
     * Increases Drop Rate
     *
     * @param player
     * @return
     */
    public static int drBonus(Player player, int npc) {
        int percentBoost = 0;

        /*
        Start Costume Slot
         */

        if (player.getEquipment().contains(23390)) { //Omega Costume
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23462)) { //Hanto Costume
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23464)) { //Raditz Costume
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23466)) { //Goku Costume
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23468)) { //Inuyasha Costume
            percentBoost += 15;
        }
        if (player.getEquipment().contains(23482)) { //Reaper Costume
            percentBoost += 15;
        }
        if (player.getEquipment().contains(23484)) { //Legends Costume
            percentBoost += 10;
        }
        if (player.getEquipment().contains(7677)) { //Unknown Costume
            percentBoost += 15;
        }
        if (player.getEquipment().contains(23470)) { //Fallen angel Costume
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23384)) { //Lucifer Costume
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23454)) { //Turkey Costume
            percentBoost += 25;
        }
        if (player.getEquipment().contains(17746)) { //Elf Costume
            percentBoost += 25;
        }
        if (player.getEquipment().contains(17778)) { //Krampus Costume
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23403)) { //Kismet Costume
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23385)) { //Lucky Costume
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23458)) { //Vozzath Costume
            percentBoost += 35;
        }
        if (player.getEquipment().contains(23395)) { //Divine Costume
            percentBoost += 50;
        }
        if (player.getEquipment().contains(23550)) { //Necrotic Costume
            percentBoost += 60;
        }
        /*
        End Costumes
         */

        //Grandmaster set
        if (player.getEquipment().contains(23497)) { //Grandmaster helmet
            percentBoost += 15;
        }
        if (player.getEquipment().contains(23498)) { //Grandmaster body
            percentBoost += 15;
        }
        if (player.getEquipment().contains(23499)) { //Grandmaster legs
            percentBoost += 15;
        }
        //End Grandmaster set




        //Sanguine set
        if (player.getEquipment().contains(23789)) { //Sanguine helmet
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23790)) { //Sanguine body
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23791)) { //Sanguine legs
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23792)) { //Sanguine gloves
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23793)) { //Sanguine boots
            percentBoost += 10;
        }
        //End Sanguine set


        //Fantasy set
        if (player.getEquipment().contains(23443)) { //Fantasy helmet
            percentBoost += 35;
        }
        if (player.getEquipment().contains(23444)) { //Fantasy body
            percentBoost += 35;
        }
        if (player.getEquipment().contains(23445)) { //Fantasy legs
            percentBoost += 35;
        }
        //End Fantasy set

        //Diminisher set
        if (player.getEquipment().contains(10823)) { //Diminished helmet
            percentBoost += 40;
        }
        if (player.getEquipment().contains(10824)) { //Diminished body
            percentBoost += 40;
        }
        if (player.getEquipment().contains(10825)) { //Diminished legs
            percentBoost += 40;
        }
        //End Diminisher set


        //Masori set
        if (player.getEquipment().contains(13273)) { //Masori helmet
            percentBoost += 40;
        }
        if (player.getEquipment().contains(13274)) { //Masori body
            percentBoost += 40;
        }
        if (player.getEquipment().contains(13275)) { //Masori legs
            percentBoost += 40;
        }
        //End Masori (f) set

        //Masori (f) set
        if (player.getEquipment().contains(13841)) { //Masori helmet (f)
            percentBoost += 45;
        }
        if (player.getEquipment().contains(13842)) { //Masori body (f)
            percentBoost += 45;
        }
        if (player.getEquipment().contains(13843)) { //Masori legs (f)
            percentBoost += 45;
        }
        //End Masori set

        if (player.getPointsHandler().getTotalPrestiges() == 1)
            percentBoost += 5;
        if (player.getPointsHandler().getTotalPrestiges() == 2)
            percentBoost += 10;
        if (player.getPointsHandler().getTotalPrestiges() == 3)
            percentBoost += 15;
        if (player.getPointsHandler().getTotalPrestiges() == 4)
            percentBoost += 20;
        if (player.getPointsHandler().getTotalPrestiges() == 5)
            percentBoost += 25;
        if (player.getPointsHandler().getTotalPrestiges() == 6)
            percentBoost += 30;
        if (player.getPointsHandler().getTotalPrestiges() == 7)
            percentBoost += 35;
        if (player.getPointsHandler().getTotalPrestiges() == 8)
            percentBoost += 40;
            if (player.getPointsHandler().getTotalPrestiges() == 9)
            percentBoost += 45;
        if (player.getPointsHandler().getTotalPrestiges() == 10)
            percentBoost += 50;



         /*
        Aura slot
         */

        if (player.getEquipment().contains(10828)) { //Diminished Aura
            percentBoost += 65;
        }
        if (player.getEquipment().contains(23271)) { //fantasy Aura
            percentBoost += 60;
        }
        if (player.getEquipment().contains(23241)) { //Owner's Aura (u)
            percentBoost += 45;
        }
        if (player.getEquipment().contains(22111)) { //Owner's Aura (u)
            percentBoost += 35;
        }
        if (player.getEquipment().contains(12630)) { //Donator's Aura
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23049)) { //Tier 6 Aura
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23048)) { //Tier 5 Aura
            percentBoost += 16;
        }
        if (player.getEquipment().contains(23047)) { //Tier 4 Aura
            percentBoost += 13;
        }
        if (player.getEquipment().contains(15449)) { //Extreme Aura
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15450)) { //Extreme Aura
            percentBoost += 10;
        }
        if (player.getEquipment().contains(4373)) { //Elite winged Aura
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23046)) { //Tier 3 Aura
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23045)) { //Tier 2 Aura
            percentBoost += 6;
        }
        if (player.getEquipment().contains(12608)) { //Tier 1 Aura
            percentBoost += 5;
        }
        if (player.getEquipment().contains(23044)) { //Tier 1 Aura
            percentBoost += 3;
        }
        /*
        End Auras
         */

         /*
        Ring slot
         */

        if (player.getEquipment().contains(10827)) { //Diminished ring
            percentBoost += 80;
        }

        if (player.getEquipment().contains(23280)) { //fantasy ring
            percentBoost += 75;
        }
        if (player.getEquipment().contains(23234)) { //Owner ring (u)
            percentBoost += 60;
        }
        if (player.getEquipment().contains(13297)) { //Lightbearer ring
            percentBoost += 50;
        }
        if (player.getEquipment().contains(23231)) { //Owner ring
            percentBoost += 50;
        }
        if (player.getEquipment().contains(22005)) { //Plutonic ring
            percentBoost += 40;
        }
        if (player.getEquipment().contains(18818)) { //Collecter ring III
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23359)) { //Reindeer Ring
            percentBoost += 25;
        }
        if (player.getEquipment().contains(20093)) { //Cursed ring
            percentBoost += 20;
        }
        if (player.getEquipment().contains(18823)) { //Collecter ring II
            percentBoost += 20;
        }
        if (player.getEquipment().contains(8335)) { //Art's ring
            percentBoost += 20;
        }
        if (player.getEquipment().contains(4446)) { //Collecter ring I
            percentBoost += 10;
        }
        if (player.getEquipment().contains(3324)) { //Ring of wealth(i)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(2572)) { //Ring of wealth(i)
            percentBoost += 5;
        }
        /*
        End Rings
         */

         /*
        Boot slot
         */
        if (player.getEquipment().contains(23422)) { //Diyos boots
            percentBoost += 50;
        }
        if (player.getEquipment().contains(23760)) { //Crimson boots
            percentBoost += 50;
        }
        if (player.getEquipment().contains(10793)) { //Diminished boots
            percentBoost += 50;
        }
        if (player.getEquipment().contains(23296)) { //Levincia boots
            percentBoost += 40;
        }

        if (player.getEquipment().contains(23297)) { //Levincia boots
            percentBoost += 40;
        }

        if (player.getEquipment().contains(23298)) { //Levincia boots
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23285)) { //Levincia boots
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23224)) { //Nephilim boots
            percentBoost += 40;
        }
        if (player.getEquipment().contains(22103)) { //Fallen Angel's boots
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23263)) { //Reapers boots
            percentBoost += 30;
        }
        if (player.getEquipment().contains(18887)) { //Colossal boots
            percentBoost += 25;
        }
        if (player.getEquipment().contains(18881)) { //Deity boots
            percentBoost += 20;
        }
        if (player.getEquipment().contains(9058)) { //Creeper boots
            percentBoost += 15;
        }
        if (player.getEquipment().contains(21612)) { //Custom extreme boots
            percentBoost += 10;
        }
        if (player.getEquipment().contains(20089)) { //Cursed boots
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8274)) { //Legends boots
            percentBoost += 10;
        }
        /*
        End Boots
         */

         /*
        Gloves slot
         */
        if (player.getEquipment().contains(23421)) { //Diyos gloves
            percentBoost += 75;
        }

        if (player.getEquipment().contains(10795)) { //Diminished gloves
            percentBoost += 80;
        }
        if (player.getEquipment().contains(23292)) { //fantasy bracelet
            percentBoost += 75;
        }
        if (player.getEquipment().contains(23235)) { //Owner bracelet (u)
            percentBoost += 60;
        }

        if (player.getEquipment().contains(23232)) { //Owner bracelet
            percentBoost += 50;
        }
        if (player.getEquipment().contains(23284)) { //Levincia gloves
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23223)) { //Nephilim gloves
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23289)) { //Tanzanite gloves
            percentBoost += 40;
        }
        if (player.getEquipment().contains(22104)) { //Fallen Angel's gloves
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23262)) { //Reaper's gloves
            percentBoost += 30;
        }
        if (player.getEquipment().contains(18885)) { //Colossal gloves
            percentBoost += 25;
        }
        if (player.getEquipment().contains(18883)) { //Deity gloves
            percentBoost += 20;
        }
        if (player.getEquipment().contains(9057)) { //Creeper gloves
            percentBoost += 15;
        }
        if (player.getEquipment().contains(15118)) { //Extreme gloves
            percentBoost += 10;
        }
        if (player.getEquipment().contains(21611)) { //Custom Extreme gloves
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8273)) { //Legends gloves
            percentBoost += 10;
        }
        if (player.getEquipment().contains(20091)) { //Cursed gloves
            percentBoost += 10;
        }
        /*
        End Gloves
         */

         /*
        Capes slot
         */
        if (player.getEquipment().contains(23268)) { //Cloak of Summer
            percentBoost += 50;
        }
        if (player.getEquipment().contains(23358)) { //Cloak of Winter
            percentBoost += 50;
        }
        if (player.getEquipment().contains(23424)) {//Diyos cape
            percentBoost += 80;
        }

        if (player.getEquipment().contains(10826)) { //Diminished cape
            percentBoost += 80;
        }

        if (player.getEquipment().contains(23270)) { //fantasy cape
            percentBoost += 75;
        }
        if (player.getEquipment().contains(22109)) { //Owner cape (u)
            percentBoost += 60;
        }
        if (player.getEquipment().contains(22105)) { //Fallen Angel's Wings
            percentBoost += 50;
        }
        if (player.getEquipment().contains(7995)) { //Owner cape
            percentBoost += 50;
        }
        if (player.getEquipment().contains(20400)) { //Enraged cape
            percentBoost += 40;
        }
        if (player.getEquipment().contains(20591)) { //rage cape
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23133)) { //Legends wings
            percentBoost += 15;
        }
        if (player.getEquipment().contains(20099)) { //Cursed cape
            percentBoost += 10;
        }
        /*
        End Capes
         */

         /*
        Amulet slot
         */

        if (player.getEquipment().contains(10829)) { //Diminished Amulet
            percentBoost += 80;
        }
        if (player.getEquipment().contains(23293)) { //fantasy amulet
            percentBoost += 75;
        }
        if (player.getEquipment().contains(23233)) { //Owner amulet (u)
            percentBoost += 60;
        }
        if (player.getEquipment().contains(23230)) { //Owner amulet
            percentBoost += 50;
        }
        if (player.getEquipment().contains(23258)) { //Plutonic amulet
            percentBoost += 40;
        }
        if (player.getEquipment().contains(18888)) { //Collectors amulet III
            percentBoost += 30;
        }
        if (player.getEquipment().contains(20092)) { //Cursed amulet
            percentBoost += 20;
        }
        if (player.getEquipment().contains(19888)) { //Collectors amulet II
            percentBoost += 20;
        }
        if (player.getEquipment().contains(19886)) { //Collectors amulet I
            percentBoost += 10;
        }
        /*
        End Amulets
         */

         /*
        Shield slot
         */
        if (player.getEquipment().contains(22117)) { //Zenyte shield
            percentBoost += 35;
        }
        if (player.getEquipment().contains(11425)) { //Duel-disc offhand (platinum)
            percentBoost += 40;
        }
        if (player.getEquipment().contains(13295)) { //Elidinis' ward (or)
            percentBoost += 40;
        }
        if (player.getEquipment().contains(13293)) { //Elidinis' ward (f)
            percentBoost += 35;
        }
        if (player.getEquipment().contains(13289)) { //Elidinis' ward
            percentBoost += 30;
        }
        if (player.getEquipment().contains(18889)) { //Colossal Spirit shield
            percentBoost += 25;
        }
        if (player.getEquipment().contains(19810)) { //Deity Spirit shield
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23788)) { //Sanguine Spirit shield
            percentBoost += 10;
        }
        if (player.getEquipment().contains(20090)) { //Cursed Spirit shield
            percentBoost += 10;
        }
        if (player.getEquipment().contains(4018)) { //Extreme offhand
            percentBoost += 10;
        }
        if (player.getEquipment().contains(21610)) { //Custom extreme teddybear
            percentBoost += 10;
        }
        /*
        End Shield
         */

         /*
        Weapon slot
         */
        if (player.getEquipment().contains(15874)) { //Diyos sword
            percentBoost += 80;
        }
        if (player.getEquipment().contains(15870)) { //Diyos sword
            percentBoost += 80;
        }
        if (player.getEquipment().contains(13664)) { //Osmumten's fang (or)
            percentBoost += 80;
        }
        if (player.getEquipment().contains(18485)) { //Tumeken's shadow (charged)
            percentBoost += 80;
        }
        if (player.getEquipment().contains(15872)) { //Diyos bow
            percentBoost += 80;
        }
        if (player.getEquipment().contains(18487)) { //Tumeken's shadow (uncharged)
            percentBoost += 75;
        }
        if (player.getEquipment().contains(13662)) { //Osmumten's fang
            percentBoost += 75;
        }
        if (player.getEquipment().contains(23302)) { //Necromancer staff
            percentBoost += 75;
        }
        if (player.getEquipment().contains(17694)) { //Necromancer hammer
            percentBoost += 75;
        }
        if (player.getEquipment().contains(23228)) { //Necromancer bow
            percentBoost += 75;
        }
        if (player.getEquipment().contains(23267)) { //Infernal Bow
            percentBoost += 50;
        }
        if (player.getEquipment().contains(23227)) { //Blood legends sword
            percentBoost += 40;
        }

        if (player.getEquipment().contains(8136)) { //Blood legends sword
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23226)) { //Blood legends bow
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23062)) { //Nephilim staff
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23551)) { //Necrotic longsword
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23063)) { //Nephilim sword
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23363)) { //Nephilim staff (u)
            percentBoost += 60;
        }
        if (player.getEquipment().contains(23365)) { //Nephilim sword (u)
            percentBoost += 60;
        }

        if (player.getEquipment().contains(23364)) { //Nephilim bow (u)
            percentBoost += 60;
        }
        if (player.getEquipment().contains(23061)) { //Nephilim bow
            percentBoost += 40;
        }
        if (player.getEquipment().contains(22114)) { //Legends Dark staff
            percentBoost += 35;
        }
        if (player.getEquipment().contains(22115)) { //Legends Dark sword
            percentBoost += 35;
        }
        if (player.getEquipment().contains(22113)) { //Legends Dark bow
            percentBoost += 35;
        }
        if (player.getEquipment().contains(17013)) { //Legends Light staff
            percentBoost += 30;
        }
        if (player.getEquipment().contains(12537)) { //Legends Light sword
            percentBoost += 30;
        }
        if (player.getEquipment().contains(5011)) { //Legends Light bow
            percentBoost += 30;
        }
        if (player.getEquipment().contains(3260)) { //Supreme blade
            percentBoost += 25;
        }
        if (player.getEquipment().contains(17011)) { //Legends staff
            percentBoost += 25;
        }
        if (player.getEquipment().contains(12535)) { //Legends sword
            percentBoost += 25;
        }
        if (player.getEquipment().contains(5012)) { //Legends bow
            percentBoost += 25;
        }
        if (player.getEquipment().contains(3745)) { //Magician Staff
            percentBoost += 30;
        }
        if (player.getEquipment().contains(8410)) { //Elite sword(aoe)
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23787)) { //Sanguine sword(aoe)
            percentBoost += 20;
        }
        if (player.getEquipment().contains(8411)) { //Elite bow(aoe)
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23785)) { //Sanguine bow(aoe)
            percentBoost += 20;
        }
        if (player.getEquipment().contains(8412)) { //Elite staff(aoe)
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23786)) { //Sanguine staff(aoe)
            percentBoost += 20;
        }
        if (player.getEquipment().contains(8253)) { //Elite staff(aoe)
            percentBoost += 15;
        }
        if (player.getEquipment().contains(20098)) { //Defiled minigun
            percentBoost += 10;
        }
        if (player.getEquipment().contains(4017)) { //Extreme glaive
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8087)) { //Dragon rider lance
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8088)) { //Judicator crossbow
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8089)) { //Purifier staff
            percentBoost += 10;
        }
        /*
        End Weapons
         */

         /*
        Plateleg slot
         */
        if (player.getEquipment().contains(23420)) {//Diyos platelegs
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23283)) { //Levincia platelegs
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23222)) { //Nephilim platelegs
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23288)) { //Tanzanite platelegs
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23314)) { //Mystic platelegs (u)
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23317)) { //Hellish platelegs (u)
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23320)) { //Midnight platelegs (u)
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23305)) { //Mystic platelegs
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23308)) { //Hellish platelegs
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23311)) { //Midnight platelegs
            percentBoost += 25;
        }
        if (player.getEquipment().contains(22102)) { //Fallen angel's platelegs
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23261)) { //Reapers platelegs
            percentBoost += 20;
        }
        if (player.getEquipment().contains(4686)) { //Legends platelegs
            percentBoost += 15;
        }
        if (player.getEquipment().contains(9056)) { //Creeper platelegs
            percentBoost += 15;
        }
        if (player.getEquipment().contains(20088)) { //Cursed platelegs
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15117)) { //Extreme platelegs
            percentBoost += 10;
        }
        if (player.getEquipment().contains(21609)) { //Extreme platelegs
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8833)) { //Elite legs(melee)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15644)) { //Elite legs(range)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15647)) { //Elite legs(magic)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(11322)) { //Dragon rider platelegs
            percentBoost += 5;
        }
        if (player.getEquipment().contains(11342)) { //Judicator platelegs
            percentBoost += 5;
        }
        if (player.getEquipment().contains(11423)) { //Purifier robe bottoms
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14912)) { //Demonic torva
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14918)) { //Nature pernix chaps
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14923)) { //Icey virtus chaps
            percentBoost += 5;
        }
        /*
        End Platelegs
         */


         /*
        Platebody slot
         */
        if (player.getEquipment().contains(23419)) {//Diyos platebody
            percentBoost += 40;
        }
        if (player.getEquipment().contains(23282)) { //Levincia platebody
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23221)) { //Nephilim platebody
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23287)) { //Tanzanite platebody
            percentBoost += 30;
        }

        if (player.getEquipment().contains(23313)) { //Mystic platebody (u)
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23316)) { //Hellish platebody (u)
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23319)) { //Midnight platebody (u)
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23304)) { //Mystic platebody
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23307)) { //Hellish platebody
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23310)) { //Midnight platebody
            percentBoost += 25;
        }

        if (player.getEquipment().contains(22101)) { //Fallen angel's platebody
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23260)) { //Reapers platebody
            percentBoost += 20;
        }
        if (player.getEquipment().contains(4685)) { //Legends platebody
            percentBoost += 15;
        }
        if (player.getEquipment().contains(9055)) { //Creeper platebody
            percentBoost += 15;
        }
        if (player.getEquipment().contains(20087)) { //Cursed platebody
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15116)) { //Extreme platebody
            percentBoost += 10;
        }
        if (player.getEquipment().contains(21608)) { //Extreme platebody
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8829)) { //Elite platebody(melee)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15643)) { //Elite platebody(range)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15646)) { //Elite platebody(magic)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(11321)) { //Dragon rider platebody
            percentBoost += 5;
        }
        if (player.getEquipment().contains(11341)) { //Judicator platebody
            percentBoost += 5;
        }
        if (player.getEquipment().contains(11422)) { //Purifier robe top
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14911)) { //Demonic torva platebody
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14917)) { //Nature pernix platebody
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14922)) { //Icey virtus chaps
            percentBoost += 5;
        }
        /*
        End Platebody
         */



        /*
        Helmet Slot
         */

        if (player.getEquipment().contains(23418)) {//Diyos helmet
            percentBoost += 45;
        }
        if (player.getEquipment().contains(23281)) { //Levincia helmet
            percentBoost += 30;
        }

        if (player.getEquipment().contains(15509)) { //Autumn coronet
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23220)) { //Nephilim helmet
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23286)) { //Tanzanite helmet
            percentBoost += 30;
        }

        if (player.getEquipment().contains(23312)) { //Mystic helmet (u)
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23315)) { //Hellish helmet (u)
            percentBoost += 30;
        }
        if (player.getEquipment().contains(23318)) { //Midnight helmet (u)
            percentBoost += 30;
        }

        if (player.getEquipment().contains(22377)) { //Festival gloves
            percentBoost += 25;
        }

        if (player.getEquipment().contains(22376)) { //Festival boots
            percentBoost += 25;
        }
        if (player.getEquipment().contains(22380)) { //Halloween aura
            percentBoost += 25;
        }

        if (player.getEquipment().contains(23357)) { //Christmas aura
            percentBoost += 25;
        }
        if (player.getEquipment().contains(22374)) { //Chucky Doll
            percentBoost += 25;
        }
        if (player.getEquipment().contains(22375)) { //Hween staff
            percentBoost += 30;
        }
        if (player.getEquipment().contains(22373)) { //Pumpkin head
            percentBoost += 30;
        }
        if (player.getEquipment().contains(22379)) { //Hween bow
            percentBoost += 30;
        }

        if (player.getEquipment().contains(23360)) { //Santa's Maul
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23361)) { //Santa's Blaster
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23440)) {//Purple Pennywise mask
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23441)) {//Black Pennywise mask
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23442)) {//Orange Pennywise mask
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23439)) {//Pennywise mask
            percentBoost += 15;
        }
        if (player.getEquipment().contains(23303)) { //Mystic helmet
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23306)) { //Hellish helmet
            percentBoost += 25;
        }
        if (player.getEquipment().contains(23309)) { //Midnight helmet
            percentBoost += 25;
        }

        if (player.getEquipment().contains(22100)) { //Fallen angel's helmet
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23072)) { //Boss slayer helmet [5]
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23259)) { //Reaper helmet
            percentBoost += 20;
        }
        if (player.getEquipment().contains(23074)) { //Boss slayer helmet [4]
            percentBoost += 16;
        }
        if (player.getEquipment().contains(4684)) { //Legends helmet
            percentBoost += 15;
        }
        if (player.getEquipment().contains(9054)) { //Creeper helmet
            percentBoost += 15;
        }
        if (player.getEquipment().contains(23070)) { //Boss slayer helmet [3]
            percentBoost += 12;
        }
        if (player.getEquipment().contains(20086)) { //Cursed helmet
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15115)) { //Extreme helmet
            percentBoost += 10;
        }
        if (player.getEquipment().contains(21607)) { //Custom Extreme helmet
            percentBoost += 10;
        }
        if (player.getEquipment().contains(8828)) { //Elite helmet(melee)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15642)) { //Elite helmet(range)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(15645)) { //Elite helmet(magic)
            percentBoost += 10;
        }
        if (player.getEquipment().contains(23069)) { //Boss slayer helmet [2]
            percentBoost += 8;
        }
        if (player.getEquipment().contains(18419)) { //Universal partyhat
            percentBoost += 7;
        }
        if (player.getEquipment().contains(18416)) { //Water partyhat
            percentBoost += 7;
        }
        if (player.getEquipment().contains(18418)) { //Velvet partyhat
            percentBoost += 7;
        }
        if (player.getEquipment().contains(18417)) { //Firehell partyhat
            percentBoost += 7;
        }
        if (player.getEquipment().contains(11320)) { //Dragon rider helmet
            percentBoost += 5;
        }
        if (player.getEquipment().contains(11340)) { //Judicator helmet
            percentBoost += 5;
        }
        if (player.getEquipment().contains(11421)) { //Purifier hood
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14910)) { //Demon torva helmet
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14916)) { //Nature pernix cowl
            percentBoost += 5;
        }
        if (player.getEquipment().contains(14921)) { //Icey Virtus mask
            percentBoost += 5;
        }
        /*
        End Helmet
         */


        /*
        Misc Drop rate
         */

        if (player.getEquipment().contains(23369) && player.getQuestOneStep7() == true) { //Holy amulet
            percentBoost += 25;
        }

        if (npc == 9312) {
            if (player.getNephilimBonus() > 0) {
                percentBoost = +player.getNephilimBonus();
            } else {
                percentBoost = 0;
            }
        }
        if (npc == 3830) {
            if (player.getGuardianBonus() > 0) {
                percentBoost = +player.getGuardianBonus();
            } else {
                percentBoost = 0;
            }
        }

        if (npc == TreasureHunter.NPC_1 || npc == TreasureHunter.NPC_2
                || npc == TreasureHunter.NPC_3 || npc  == TreasureHunter.NPC_4) {
            Familiar playerFamiliar = player.getSummoning().getFamiliar();
            if (playerFamiliar != null && playerFamiliar.getSummonNpc() != null) {
                int summonNpc = playerFamiliar.getSummonNpc().getId();
                if (summonNpc == BossPets.BossPet.GOLEM_PET.npcId || summonNpc == BossPets.BossPet.DRAGON_PET.npcId
                        || summonNpc == BossPets.BossPet.DEMON_PET.npcId || summonNpc == BossPets.BossPet.RAMMUS_PET.npcId) {
                    percentBoost = 1000;
                }
            }
        }
        if (npc == player.getSlayer().getSlayerTask().getNpcId()) {
            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23071) {
                percentBoost += 5;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23069 || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23070) {
                percentBoost += 7;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23074) {
                percentBoost += 10;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23072) {
                percentBoost += 15;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23073) {
                percentBoost += 20;
            }
        }

        if (player.isMembershipUnlocked()) {
            percentBoost *= 1.2;
        }

        if (Misc.isFriday()) {
            percentBoost += 10;
        }

        if (!player.isInsideRaids()) {

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.WOLF_PET.npcId) {
                percentBoost += 1;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.GORILLA_PET.npcId) {
                percentBoost += 3;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.MARIO_PET.npcId) {
                percentBoost += 5;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DONKEY_KONG_PET.npcId) {
                percentBoost += 7;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.VEGETA_PET.npcId) {
                percentBoost += 10;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.HELLRAISER.npcId) {
                percentBoost += 10;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.YOSHI_PET.npcId) {
                percentBoost += 15;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ZORBAK_PET.npcId) {
                percentBoost += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RAICHU_PET.npcId) {
                percentBoost += 50;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FALLEN_ANGEL_PET.npcId) {
                percentBoost += 60;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.RAMMUS_PET.npcId) {
                percentBoost += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DEMON_PET.npcId) {
                percentBoost += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.GOLEM_PET.npcId) {
                percentBoost += 25;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DRAGON_PET.npcId) {
                percentBoost += 25;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FACELESS_MAGICIAN.npcId) {
                percentBoost += 45;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.LOTUS_MAGICIAN.npcId) {
                percentBoost += 45;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SHADOW_MAGICIAN.npcId) {
                percentBoost += 45;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.LESARKUS_WARRIOR.npcId) {
                percentBoost += 45;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.VAMPIRE_WARRIOR.npcId) {
                percentBoost += 45;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ELF_WARRIOR.npcId) {
                percentBoost += 45;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DIVINE_ARCHER.npcId) {
                percentBoost += 45;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.CHAOTIC_ARCHER.npcId) {
                percentBoost += 45;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.FOREST_ARCHER.npcId) {
                percentBoost += 45;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BORK_PET.npcId) {
                percentBoost += 60;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BLOOD_DEMON_PET.npcId) {
                percentBoost += 70;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.VINDICTA_PET.npcId) {
                percentBoost += 50;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.SPIRIT_OF_SCORPIUS.npcId) {
                percentBoost += 70;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.EVIL_SCORPIUS.npcId) {
                percentBoost += 80;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY.npcId) {
                percentBoost += 60;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.KRAMPUS_PET.npcId) {
                percentBoost += 75;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY1.npcId) {
                percentBoost += 70;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY2.npcId) {
                percentBoost += 70;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY3.npcId) {
                percentBoost += 70;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY4.npcId) {
                percentBoost += 70;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY5.npcId) {
                percentBoost += 70;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY6.npcId) {
                percentBoost += 70;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.TURKEY7.npcId) {
                percentBoost += 70;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.NECROMANCER.npcId) {
                percentBoost += 100;
            }

            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.YUGI_MOTO.npcId) {
                percentBoost += 90;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.DARK_MAGICIAN.npcId) {
                percentBoost += 90;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.ARMED_PROTECTOR.npcId) {
                percentBoost += 90;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.EXODIA.npcId) {
                percentBoost += 90;
            }
            if (player.getSummoning() != null && player.getSummoning().getFamiliar() != null &&
                    player.getSummoning().getFamiliar().getSummonNpc().getId() == BossPets.BossPet.BEWD.npcId) {
                percentBoost += 115;
            }
        }

        if (player.getInventory().contains(23413)) {
            percentBoost *= 1.75;
        } else if (player.getInventory().contains(23254)) {
            percentBoost *= 1.5;
        }

        if (ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.DR) {
            percentBoost *= 1.5;
        }
        /**
         * Donator Rank bonusses
         */
        if (player.getAmountDonated() >= Store.PLATINUM_DONATION_AMOUNT
                || player.getRights().equals(PlayerRights.YOUTUBER)) {
            percentBoost += 125;
         } else if (player.getAmountDonated() >= Store.TANZANITE_DONATION_AMOUNT) {
            percentBoost += 100;
        } else if (player.getAmountDonated() >= Store.ZENYTE_DONATION_AMOUNT) {
            percentBoost += 75;
        } else if (player.getAmountDonated() >= Store.ONYX_DONATION_AMOUNT) {
            percentBoost += 45;
        } else if (player.getAmountDonated() >= Store.DIAMOND_DONATION_AMOUNT) {
            percentBoost += 30;
        } else if (player.getAmountDonated() >= Store.RUBY_DONATION_AMOUNT) {
            percentBoost += 20;
        } else if (player.getAmountDonated() >= Store.EMERALD_DONATION_AMOUNT) {
            percentBoost += 15;
        } else if (player.getAmountDonated() >= Store.SAPPHIRE_DONATION_AMOUNT) {
            percentBoost += 5;
        } else {
            percentBoost += 0;
        }

        if (player.getInventory().contains(4440)) {
            percentBoost *= 1.5;
        }

        if (GameSettings.DOUBLEDR == true) {
            percentBoost *= 2;
        }

        if (player.isMembershipUnlocked()) {
            percentBoost *= 1.1;
        }

        if (player.getDoubleDRTimer() > 0) {
            percentBoost += 100;
        }
        if (player.getMinutesVotingDR() > 0) {
            percentBoost += 100;
        }

        if (GameSettings.DOUBLE_DROP) {
            percentBoost += 100;
        }


        if (player.getGameMode() == GameMode.GROUP_IRONMAN) {
            percentBoost += 6;
        }
        if (player.getGameMode() == GameMode.ULTIMATE_IRONMAN || player.getGameMode() == GameMode.IRONMAN) {
            percentBoost += 10;
        }
        if (player.getGameMode() == GameMode.VETERAN_MODE) {
            percentBoost += 15;
        }
        if (PrayerHandler.isActivated(player, PrayerHandler.GNOMES_GREED)) {
            percentBoost += 10;
        }

        if (npc == 9129 || //slayer champion
                npc == 9312 || //Nephilim Warrior
                npc == 9319 || //Zenyte Golem
                npc == 587 || //Ironman boss
                npc == 9318 || //Onyx Panther
                npc == 3830 || //Vozzath
                npc == 4972 || //Dragon king
                npc == 3305 || //Naraku
                npc == 9017 || //Nightmare Boss
                npc == 8013 || //Vote Boss
                npc == 3779|| //Terrorstep
                npc == 187 || //Hellraiser
                npc == 8499 || //Hellraiser
                npc == 10034 || //platinum boss (Yugi Muto)
                npc == 10035 ||//platinum boss (Dark magician)
                npc == 10036 ||//platinum boss (Armed Protector Dragon)
                npc == 10037 || //platinum boss (Exodia)
                npc == 200     //The Diminisher
        ) {
            percentBoost = 0;
            //System.out.println("0 Drop rate on globals");
        }

        return percentBoost;
    }


    public static int getDoubleDropChance(Player player, int npc) {
        int percentBoost = 0;

        Equipment equipment = player.getEquipment();
        if (equipment.contains(23092)
                || equipment.contains(23093)
                || equipment.contains(23094)) {// valor rings
            percentBoost += 10;
        }

        if (ServerPerks.getInstance().getActivePerk() == ServerPerks.Perk.DOUBLE_DROPS) {
            percentBoost = +100;
        }

        if (player.getGameMode() == GameMode.IRONMAN || player.getGameMode() == GameMode.ULTIMATE_IRONMAN) {
            percentBoost += 5;
        }
        if (player.getGameMode() == GameMode.GROUP_IRONMAN) {
            percentBoost += 3;
        }
        if (player.getGameMode() == GameMode.VETERAN_MODE) {
            percentBoost += 7;
        }

        if (Misc.isThursday()) {
            percentBoost += 10;
        }

        if (npc == player.getSlayer().getSlayerTask().getNpcId()) {
            if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23071) {
                percentBoost += 5;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23069 || player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23070) {
                percentBoost += 7;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23074) {
                percentBoost += 10;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23072) {
                percentBoost += 15;
            } else if (player.getEquipment().getItems()[Equipment.HEAD_SLOT].getId() == 23073) {
                percentBoost += 20;
            }
        }


        /**
         * Donator Rank bonusses
         */if (player.getAmountDonated() >= Store.PLATINUM_DONATION_AMOUNT || player.getRights().equals(PlayerRights.YOUTUBER)) {
            percentBoost += 35;
        } else if (player.getAmountDonated() >= Store.TANZANITE_DONATION_AMOUNT ) {
            percentBoost += 30;
        } else if (player.getAmountDonated() >= Store.ZENYTE_DONATION_AMOUNT) {
            percentBoost += 25;
        } else if (player.getAmountDonated() >= Store.ONYX_DONATION_AMOUNT) {
            percentBoost += 20;
        } else if (player.getAmountDonated() >= Store.DIAMOND_DONATION_AMOUNT) {
            percentBoost += 15;
        } else if (player.getAmountDonated() >= Store.RUBY_DONATION_AMOUNT) {
            percentBoost += 10;
        } else if (player.getAmountDonated() >= Store.EMERALD_DONATION_AMOUNT) {
            percentBoost += 7;
        } else if (player.getAmountDonated() >= Store.SAPPHIRE_DONATION_AMOUNT) {
            percentBoost += 5;
        }

        if (player.getPointsHandler().getTotalPrestiges() == 10)
            percentBoost += 10;

        if (PrayerHandler.isActivated(player, PrayerHandler.GNOMES_GREED)) {
            percentBoost += 10;
        }

        if (player.getDoubleDDRTimer() > 0) {
            percentBoost *= 1.5D;
        }
        return percentBoost;
    }
}
