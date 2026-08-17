package com.ruse.world.content.osrscollectionlog;


import com.ruse.model.Item;
import com.ruse.world.entity.impl.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *     Collection(int attributeKey, LogType logType, String name, int[] key, Boolean rewardClaimed, Item[] reward, Item... obtainables) {
 *
 *
 */
public enum Collection {

    //Monsters
    ARACHNES(Player.SPIDERS_KILLED, LogType.MONSTERS, "Arachnes", new int[] {CollectionLog.ARACHNES}, Player.ARACHNES_LOG_CLAIMED, new Item[] { new Item(19114,3) },
            new Item(22219), new Item(781), new Item(19811), new Item(19473),
            new Item(19472), new Item(17291), new Item(3909), new Item(11235)),
    DEMON_GODDESS(Player.DEMON_GODDESS_KILLED, LogType.MONSTERS, "Demon Goddess", new int[] {CollectionLog.DEMON_GODDESS}, Player.DEMON_GODDESS_LOG_CLAIMED, new Item[] { new Item(19114,3) },
            new Item(22219), new Item(781),new Item(8860), new Item(8861), new Item(8862), new Item(15830),
            new Item(8834), new Item(8835)),
    ENERGY_SKELETONS(Player.ENERGY_SKELETONS_KILLED, LogType.MONSTERS, "Energy Skeleton", new int[] {CollectionLog.ENERGY_SKELETONS}, Player.ENERGY_SKELETONS_LOG_CLAIMED, new Item[] { new Item(19114,5) },
             new Item(22219), new Item(781),new Item(19931), new Item(19933), new Item(19934),
            new Item(19919), new Item(19917), new Item(7927)),
    TUROTH(Player.TUROTH_KILLED, LogType.MONSTERS, "Turoth", new int[] {CollectionLog.TUROTH}, Player.TUROTH_LOG_CLAIMED, new Item[] { new Item(19114,5) },
            new Item(22219), new Item(781), new Item(8817), new Item(8818), new Item(3905), new Item(14018)),
    FALLEN_WARRIOR(Player.FALLEN_WARRIOR_KILLED, LogType.MONSTERS, "Fallen Warrior", new int[] {CollectionLog.FALLEN_WARRIOR}, Player.FALLEN_WARRIOR_LOG_CLAIMED, new Item[] { new Item(6769,3) },
            new Item(15288), new Item(15358), new Item(15359), new Item(10946)),
    CAVE_DRONE(Player.CAVE_DRONE_KILLED, LogType.MONSTERS, "Cave Drone", new int[] {CollectionLog.CAVE_DRONE}, Player.CAVE_DRONE_LOG_CLAIMED, new Item[] { new Item(10942,2) },
            new Item(22219), new Item(9688)),
    CAVE_MUTANT(Player.CAVE_MUTANT_KILLED, LogType.MONSTERS, "Cave Mutant", new int[] {CollectionLog.CAVE_MUTANT}, Player.CAVE_MUTANT_LOG_CLAIMED, new Item[] { new Item(10942,2) },
            new Item(22219), new Item(9689)),
    CAVE_SNAIL(Player.CAVE_SNAIL_KILLED, LogType.MONSTERS, "Cave Snail", new int[] {CollectionLog.CAVE_SNAIL}, Player.CAVE_SNAIL_LOG_CLAIMED, new Item[] { new Item(10942,2) },
            new Item(22219), new Item(9687)),

    //Zones
    DUSTCLAW(Player.DUSTCLAWS_KILLED, LogType.ZONES, "Dustclaw", new int[] {CollectionLog.DUSTCLAW}, Player.DUSTCLAW_LOG_CLAIMED, new Item[] { new Item(10025,3) },
            new Item(10025)),
    LORD(Player.LORDS_KILLED, LogType.ZONES, "Inferior Elite Lord", new int[] {CollectionLog.LORD}, Player.LORD_LOG_CLAIMED, new Item[] { new Item(10025,5) },
            new Item(10025)),
    SHADOW(Player.SHADOW_KILLED, LogType.ZONES, "Shadow hunter", new int[] {CollectionLog.SHADOW}, Player.SHADOW_LOG_CLAIMED, new Item[] { new Item(10025,5) },
            new Item(10025)),
    GOLEM(Player.GOLEM_KILLED, LogType.ZONES, "Joyx Golem", new int[] {CollectionLog.GOLEM}, Player.GOLEM_LOG_CLAIMED, new Item[] { new Item(10025,6) },
            new Item(10025),new Item(675),new Item(702),new Item(700), new Item(701),
            new Item(17708),new Item(17602),new Item(19153), new Item(19142),new Item(19141)),
    SHETANI(Player.SHETANI_KILLED, LogType.ZONES, "Shetani", new int[] {CollectionLog.SHETANI}, Player.SHETANI_LOG_CLAIMED, new Item[] { new Item(10025,6) },
            new Item(10025),new Item(5095),new Item(19140), new Item(19139),new Item(19138)),
    RIPPER(Player.RIPPER_KILLED, LogType.ZONES, "Titanium Ripper", new int[] {CollectionLog.RIPPER}, Player.RIPPER_LOG_CLAIMED, new Item[] { new Item(10025,8) },
            new Item(10025),new Item(15922),new Item(15933), new Item(16021)),
    AVATAR(Player.AVATAR_KILLED, LogType.ZONES, "Avatar Titan", new int[] {CollectionLog.AVATAR}, Player.AVATAR_LOG_CLAIMED, new Item[] { new Item(10025,10) },
            new Item(10025),new Item(17600),new Item(19944), new Item(703),new Item(704),new Item(705),
            new Item(19946),new Item(19945)),
    WYVERNS(Player.WYVERNS_KILLED, LogType.ZONES, "Legendary Wyvern", new int[] {CollectionLog.WYVERN}, Player.WYVERNS_LOG_CLAIMED, new Item[] { new Item(19114,15) },
            new Item(17712),new Item(17638),new Item(17640),new Item(15593),
            new Item(16140),new Item(2021),new Item(12860),new Item(12565),
            new Item(20173),new Item(8803),new Item(8804),new Item(8805),new Item(8812)),
    ONI(Player.ONI_KILLED, LogType.ZONES, "Oni", new int[] {CollectionLog.ONI}, Player.ONI_LOG_CLAIMED, new Item[] { new Item(19114,25) },
            new Item(15289),new Item(10025),new Item(17714),new Item(17686),new Item(15924),
            new Item(16023),new Item(15935),new Item(15888),new Item(15818),new Item(12994),
            new Item(16272),new Item(8809),new Item(8806),new Item(8807),new Item(8808)),
    SHENRON(Player.SHENRON_KILLED, LogType.ZONES, "Super Shenron", new int[] {CollectionLog.SHENRON}, Player.SHENRON_LOG_CLAIMED, new Item[] { new Item(19114,50) },
            new Item(15289),new Item(10025),new Item(12284),new Item(15005),new Item(15006),
            new Item(15007),new Item(15008),new Item(15100),new Item(15200),new Item(15201),
            new Item(20549), new Item(8800),new Item(8801),new Item(8802)),
    SUBZERO(Player.SUBZERO_KILLED, LogType.ZONES, "SubZero", new int[] {CollectionLog.SUBZERO}, Player.SUBZERO_LOG_CLAIMED, new Item[] { new Item(20488,15) },
            new Item(8803),new Item(8804),new Item(8805),new Item(20173),new Item(15289),
            new Item(10025),new Item(20542),new Item(13300),new Item(13301),new Item(13304),
            new Item(18683),new Item(15511),new Item(13306),new Item(18817),new Item(13302),new Item(13305)),
    ZEUS(Player.ZEUS_KILLED, LogType.ZONES, "Almight Zeus", new int[] {CollectionLog.ZEUS}, Player.ZEUS_LOG_CLAIMED, new Item[] { new Item(20488,25) },
            new Item(8803),new Item(8804),new Item(8805),new Item(20173),new Item(20488),
            new Item(21218), new Item(15289), new Item(10025),new Item(15230),new Item(15231),
            new Item(15232),new Item(15233),new Item(15234),new Item(17662),
            new Item(15235), new Item(15236), new Item(21031),new Item(21032),new Item(21033),
            new Item(21034),new Item(21035)),
    IPOTANE(Player.IPOTANE_KILLED, LogType.ZONES, "Ipotane", new int[] {CollectionLog.IPOTANE}, Player.IPOTANE_LOG_CLAIMED, new Item[] { new Item(20488,25) },
            new Item(8803),new Item(8804),new Item(8805),
            new Item(20173),new Item(15289),new Item(20488),
            new Item(10025),new Item(13640),new Item(15448),
            new Item(21934),new Item(19918),new Item(19913),
            new Item(13964),new Item(3107),new Item(15401)
    ),
    VINDICTA(Player.VINDICTA_KILLED, LogType.ZONES, "Vindicta", new int[] {CollectionLog.VINDICTA}, Player.VINDICTA_LOG_CLAIMED, new Item[] { new Item(20488,30) },
            new Item(23082),new Item(10947),new Item(22084),new Item(8326),
            new Item(8327),new Item(8328),new Item(22083),new Item(8330),new Item(8331),
            new Item(8332),new Item(22092),new Item(8323),new Item(8324),new Item(8325),
            new Item(15289),new Item(20488),new Item(10025)
    ),
    BEAST(Player.BEAST_KILLED, LogType.ZONES, "Bork", new int[] {CollectionLog.BORK}, Player.BEAST_LOG_CLAIMED, new Item[] { new Item(20488,50) },
            new Item(23381),new Item(10947),new Item(17594),new Item(17596),new Item(17598),
            new Item(23099),new Item(19776),new Item(15289),new Item(20488),new Item(10025)),

    NIHIL(Player.NIHIL_KILLED, LogType.ZONES, "Nihil", new int[] {CollectionLog.NIHIL}, Player.NIHIL_LOG_CLAIMED, new Item[] { new Item(20489,5),new Item(6769,1),new Item(10947,3) },
            new Item(23527),new Item(10947),new Item(23522),new Item(23523),new Item(23524),
            new Item(23525),new Item(23526),new Item(15289),new Item(20488),new Item(10025)),

    //Bosses
    HANTO(Player.HANTO_KILLED, LogType.BOSSES, "Hanto Warrior", new int[] {CollectionLog.HANTO}, Player.HANTO_LOG_CLAIMED, new Item[] { new Item(10946,15) },
            new Item(10946), new Item(6833), new Item(11763), new Item(11764),
            new Item(11765), new Item(11766), new Item(11767)),
    RADITZ(Player.RADITZ_KILLED, LogType.BOSSES, "Raditz", new int[] {CollectionLog.RADITZ}, Player.RADITZ_LOG_CLAIMED, new Item[] { new Item(10946,15) },
            new Item(10946), new Item(7545), new Item(7543), new Item(7544),
            new Item(9481), new Item(9482), new Item(9483), new Item(6833), new Item(18768)),
    GOKU(Player.GOKU_KILLED, LogType.BOSSES, "Goku", new int[] {CollectionLog.GOKU}, Player.GOKU_LOG_CLAIMED, new Item[] { new Item(6769,4) },
            new Item(18838), new Item(9478), new Item(9479), new Item(9480),
            new Item(16249), new Item(15832), new Item(16265), new Item(6833)
            , new Item(18768)),
    BOTANIC(Player.BOTANIC_KILLED, LogType.BOSSES, "Botanic Guardian", new int[] {CollectionLog.BOTANIC}, Player.BOTANIC_LOG_CLAIMED, new Item[] { new Item(20488,15) },
            new Item(3738), new Item(3723), new Item(3724), new Item(3725),
            new Item(12855)),
    ENRAGED_GUARDIAN(Player.ENRAGED_GUARDIAN_KILLED, LogType.BOSSES, "Enraged Guardian", new int[] {CollectionLog.ENRAGED_GUARDIAN}, Player.ENRAGED_GUARDIAN_LOG_CLAIMED, new Item[] { new Item(20488,15) },
            new Item(3737), new Item(3720), new Item(3721), new Item(3722),
            new Item(12855)),
    ELEMENTAL_GUARDIAN(Player.ELEMENTAL_GUARDIAN_KILLED, LogType.BOSSES, "Elemental Guardian", new int[] {CollectionLog.ELEMENTAL_GUARDIAN}, Player.ELEMENTAL_GUARDIAN_LOG_CLAIMED, new Item[] { new Item(20488,15) },
            new Item(3739), new Item(3726), new Item(3728), new Item(3730),
            new Item(12855)),
    INYUASHA(Player.INYUASHA_KILLED, LogType.BOSSES, "Inuyasha", new int[] {CollectionLog.INYUASHA}, Player.INYUASHA_LOG_CLAIMED, new Item[] { new Item(20488,15) },
            new Item(5073), new Item(5068), new Item(5069), new Item(5070),
            new Item(7461), new Item(5072), new Item(8335), new Item(10946), new Item(12855), new Item(19114), new Item(19115)),
    TOLROKOTH(Player.TOLROKOTH_KILLED, LogType.BOSSES, "Tolrokoth", new int[] {CollectionLog.TOLROKOTH}, Player.TOLROKOTH_LOG_CLAIMED, new Item[] { new Item(10934,1) },
            new Item(14067), new Item(14060), new Item(14061), new Item(14062),
            new Item(14066), new Item(14065), new Item(14063), new Item(14064)),
    DEITY_DEMON(Player.DEITY_DEMON_KILLED, LogType.BOSSES, "Deity Demon", new int[] {CollectionLog.DEITY_DEMON}, Player.DEITY_DEMON_LOG_CLAIMED, new Item[] { new Item(10934,1) },
            new Item(10947), new Item(15290), new Item(15289), new Item(19114)),
    MUTATED_HOUND(Player.MUTATED_HOUND_KILLED, LogType.BOSSES, "Mutated hound", new int[] {CollectionLog.MUTATED_HOUND}, Player.MUTATED_HOUND_LOG_CLAIMED, new Item[] { new Item(10949,2) },
            new Item(14472), new Item(10949), new Item(10947), new Item(10946),
            new Item(15290), new Item(15289), new Item(19114), new Item(19115), new Item(19116)),
    VALDIS(Player.VALDIS_KILLED, LogType.BOSSES, "Valdis", new int[] {CollectionLog.VALDIS}, Player.VALDIS_LOG_CLAIMED, new Item[] { new Item(10942,2) },
            new Item(4373), new Item(10947), new Item(20488), new Item(19115),
            new Item(19114), new Item(19116), new Item(1486), new Item(15289),
            new Item(15290), new Item(12855)),
    COLLOSAL_AVATAR(Player.COLLOSAL_AVATAR_KILLED, LogType.BOSSES, "Colossal Avatar", new int[] {CollectionLog.COLLOSAL_AVATAR}, Player.COLLOSAL_AVATAR_LOG_CLAIMED, new Item[] { new Item(10942,3) },
            new Item(9080), new Item(9081), new Item(9082), new Item(20099),
            new Item(15288), new Item(15289), new Item(15290), new Item(20488), new Item(19114), new Item(19115), new Item(19116), new Item(12855)),
    INFERNAL_DEMON(Player.INFERNAL_DEMON_KILLED, LogType.BOSSES, "Plutonic Demon", new int[] {CollectionLog.INFERNAL_DEMON}, Player.INFERNAL_DEMON_LOG_CLAIMED, new Item[] { new Item(10942, 4) },
            new Item(22005), new Item(23258), new Item(15288), new Item(15289),
            new Item(15290), new Item(20488), new Item(19114), new Item(19115), new Item(19116), new Item(12855)),
    FALLEN_ANGEL(Player.FALLEN_ANGEL_KILLED, LogType.BOSSES, "Fallen Angel", new int[] {CollectionLog.FALLEN_ANGEL}, Player.FALLEN_ANGEL_LOG_CLAIMED, new Item[] { new Item(22106,1) },
            new Item(22106), new Item(15288), new Item(10946), new Item(6769)),
    MIDNIGHT_GOBLIN(Player.MIDNIGHT_GOBLIN_KILLED, LogType.BOSSES, "Midnight Goblin", new int[] {CollectionLog.MIDNIGHT_GOBLIN}, Player.MIDNIGHT_GOBLIN_LOG_CLAIMED, new Item[] { new Item(15004,1) },
            new Item(14474), new Item(22112), new Item(15288), new Item(15289),
            new Item(15290), new Item(20488), new Item(7956), new Item(19114), new Item(19115), new Item(19116)),
    BLOOD_DEMON(Player.BLOOD_DEMON_KILLED, LogType.BOSSES, "Blood Demon", new int[] {CollectionLog.BLOOD_DEMON}, Player.BLOOD_DEMON_LOG_CLAIMED, new Item[] { new Item(15004,2) },
            new Item(23238), new Item(23239), new Item(23252), new Item(15288),
            new Item(15289), new Item(15290), new Item(20488), new Item(7956), new Item(19114), new Item(19115), new Item(19116)),
    NECROMANCER(Player.NECROMANCER_COMPLETED, LogType.BOSSES, "Necromancer", new int[] {CollectionLog.NECROMANCER_KEY}, Player.NECROMANCER_LOG_CLAIMED, new Item[] { new Item(23279) },
            new Item(23551),new Item(23550),new Item(22953),new Item(22952), new Item(22951), new Item(22954)),

    //Boxes
    MYSTERY_BOX(Player.MYSTERY_BOXES_OPENED, LogType.BOXES, "Beginner Mystery Box", new int[] {CollectionLog.MYSTERY_BOX}, Player.MYSTERY_BOX_LOG_CLAIMED, new Item[] { new Item(19116,15) },
            new Item(12855), new Item(1149), new Item(1249), new Item(3204), new Item(1305), new Item(1215),
            new Item(1377), new Item(1434), new Item(7158), new Item(989), new Item(536), new Item(6739),
            new Item(11728), new Item(15259), new Item(6570), new Item(3320), new Item(3318), new Item(4888),
            new Item(18332), new Item(14377), new Item(18686), new Item(18799), new Item(5095), new Item(13996),
            new Item(18834), new Item(19140), new Item(13913), new Item(18801), new Item(19139), new Item(13919),
            new Item(18800), new Item(19138), new Item(14915), new Item(14919), new Item(14924)),
    PVM_BOX(Player.PVM_BOXES_OPENED, LogType.BOXES, "PvM Box", new int[] {CollectionLog.PVM_BOX}, Player.PVM_BOX_LOG_CLAIMED, new Item[] { new Item(22214,1000) },
            new Item(10350), new Item(10348), new Item(4718), new Item(10346), new Item(14499), new Item(14497),
            new Item(14501), new Item(4710), new Item(3751), new Item(17193), new Item(17339), new Item(4734),
            new Item(4753), new Item(4757), new Item(4759), new Item(4755), new Item(4745), new Item(4749),
            new Item(4751), new Item(4747), new Item(290), new Item(19582), new Item(14525), new Item(11858),
            new Item(4151), new Item(11235), new Item(15486), new Item(12933), new Item(18353),
            new Item(15031), new Item(6585), new Item(6737), new Item(7462)),
    PVM_BOX_T2(Player.PVM_BOXES_T2_OPENED, LogType.BOXES, "PvM Box (t2)", new int[] {CollectionLog.PVM_BOX_T2}, Player.PVM_BOX_T2_LOG_CLAIMED, new Item[] { new Item(20488,20) },
            new Item(19582), new Item(14525), new Item(11858), new Item(4151), new Item(11235), new Item(15486),
            new Item(12933), new Item(18353), new Item(15031), new Item(6585), new Item(6737), new Item(7462),
            new Item(18686), new Item(18799), new Item(5095), new Item(13996), new Item(18834), new Item(19140),
            new Item(13913), new Item(18801), new Item(19139), new Item(13919), new Item(18800), new Item(19138)),

    SUPER(Player.SUPER_BOXES_OPENED, LogType.BOXES, "Sapphire Mystery Box", new int[] {CollectionLog.SUPER}, Player.SUPER_BOX_LOG_CLAIMED, new Item[] { new Item(19115,40) },
            new Item(12855), new Item(989), new Item(4888), new Item(18332), new Item(14377), new Item(13902),
            new Item(13899), new Item(11730), new Item(13922), new Item(13952), new Item(13940), new Item(13910),
            new Item(13946), new Item(13934), new Item(13916), new Item(13949), new Item(13937), new Item(14915),
            new Item(14919), new Item(14924), new Item(16140), new Item(2021), new Item(12860), new Item(12565),
            new Item(12634), new Item(22077), new Item(19136), new Item(6936), new Item(14008), new Item(14009),
            new Item(14010), new Item(455)),

    EXTREME(Player.EXTREME_BOXES_OPENED, LogType.BOXES, "Emerald Mystery Box", new int[] {CollectionLog.EXTREME}, Player.EXTREME_BOX_LOG_CLAIMED, new Item[] { new Item(19114,50) },
            new Item(15442), new Item(15443), new Item(15444), new Item(18351), new Item(18349), new Item(18353),
            new Item(6500), new Item(13740), new Item(22077), new Item(19136), new Item(6936), new Item(666),
            new Item(15424), new Item(674), new Item(8800), new Item(8803), new Item(8806), new Item(8801),
            new Item(8804), new Item(8807), new Item(8802), new Item(8805), new Item(8808), new Item(20549),
            new Item(20173), new Item(8809), new Item(10946)),

    GRAND(Player.GRAND_BOXES_OPENED, LogType.BOXES, "Ruby Mystery Box", new int[] {CollectionLog.GRAND}, Player.GRAND_BOX_LOG_CLAIMED, new Item[] { new Item(20488,40) },
            new Item(13740), new Item(15290), new Item(20549), new Item(20173), new Item(8809), new Item(8834),
            new Item(8835), new Item(8860), new Item(8861), new Item(8862), new Item(15830), new Item(3318),
            new Item(15418), new Item(8326), new Item(8330), new Item(8323), new Item(8327), new Item(8331),
            new Item(8324), new Item(8328), new Item(8332), new Item(8325), new Item(22084), new Item(22083),
            new Item(22092), new Item(10946), new Item(10942), new Item(6769)),

    OP_CHEST(Player.OP_BOXES_OPENED, LogType.BOXES, "OP Chest", new int[] {CollectionLog.OP}, Player.OP_BOX_LOG_CLAIMED, new Item[] { new Item(10942,4) },
            new Item(8800), new Item(8803), new Item(8806), new Item(8801), new Item(8804), new Item(8807),
            new Item(8802), new Item(8805), new Item(8808), new Item(20549), new Item(20173), new Item(8809),
            new Item(10946), new Item(8326), new Item(8330), new Item(8323), new Item(8327), new Item(8331),
            new Item(8324), new Item(8328), new Item(8332), new Item(8325), new Item(22084), new Item(22083),
            new Item(6769), new Item(10942), new Item(18753), new Item(18749), new Item(18631), new Item(18752),
            new Item(18748), new Item(18637), new Item(18751), new Item(18638), new Item(18623), new Item(18750),
            new Item(18636), new Item(18629), new Item(19886), new Item(4446)),

    VOTE(Player.VOTE_BOXES_OPENED, LogType.BOXES, "Vote Mystery Box", new int[] {CollectionLog.VOTE}, Player.VOTE_BOX_LOG_CLAIMED, new Item[] { new Item(20489,3) },
            new Item(19582), new Item(14525), new Item(11858), new Item(18686), new Item(18799), new Item(5095),
            new Item(10025), new Item(19116), new Item(21218), new Item(17714), new Item(17686), new Item(15924),
            new Item(16023), new Item(15935), new Item(15888), new Item(15818), new Item(12994), new Item(16272),
            new Item(8800), new Item(8801), new Item(8802), new Item(8803), new Item(8804), new Item(8805),
            new Item(8806), new Item(8807), new Item(8808), new Item(3907), new Item(10946), new Item(6769), new Item(20489)),

    PROGRESSIVE(Player.PROGRESSIVE_BOXES_OPENED, LogType.BOXES, "Reward Crate", new int[] {CollectionLog.PROGRESSIVE}, Player.PROGRESSIVE_BOX_LOG_CLAIMED, new Item[] { new Item(7120,40) },
            new Item(671), new Item(4411), new Item(14415), new Item(14395), new Item(14405), new Item(672),
            new Item(673), new Item(677), new Item(678), new Item(679), new Item(22075), new Item(19471),
            new Item(19470), new Item(19469), new Item(666), new Item(15424), new Item(674), new Item(22078),
            new Item(4369), new Item(15877), new Item(16269), new Item(15943), new Item(675), new Item(702),
            new Item(700), new Item(701), new Item(17708), new Item(5095), new Item(19140), new Item(19139),
            new Item(19138), new Item(15922), new Item(16021), new Item(15933), new Item(17600), new Item(19944), new Item(703),
            new Item(704), new Item(705), new Item(19946), new Item(17714), new Item(17686), new Item(15924),
            new Item(16023), new Item(15935), new Item(15888), new Item(15818), new Item(12994), new Item(16272),
            new Item(8809), new Item(8806), new Item(8807), new Item(8808), new Item(12284), new Item(15005),
            new Item(15006), new Item(15007), new Item(15008), new Item(15100), new Item(15200), new Item(15201),
            new Item(20549), new Item(8800), new Item(8801), new Item(8802), new Item(17712), new Item(17638),
            new Item(17640), new Item(15593), new Item(16140), new Item(2021), new Item(12860), new Item(12565),
            new Item(20173), new Item(8803), new Item(8804), new Item(8805), new Item(8812), new Item(20542),
            new Item(8805), new Item(13300), new Item(13301), new Item(13304), new Item(18683), new Item(15511),
            new Item(13306), new Item(18817), new Item(13302), new Item(13305), new Item(15230), new Item(15231),
            new Item(15232), new Item(15233), new Item(15234), new Item(17662), new Item(15235), new Item(15236),
            new Item(21031), new Item(21032), new Item(21033), new Item(21034), new Item(21035), new Item(13640),
            new Item(15448), new Item(21934), new Item(19918), new Item(19913), new Item(13964), new Item(3107)),

    SLAYER(Player.SLAYER_BOXES_OPENED, LogType.BOXES, "Slayer Crate", new int[] {CollectionLog.SLAYER}, Player.SLAYER_BOX_LOG_CLAIMED, new Item[] { new Item(22123,20) },
            new Item(671), new Item(4411), new Item(14415), new Item(14395), new Item(14405), new Item(672),
            new Item(673), new Item(677), new Item(678), new Item(679), new Item(22075), new Item(19471),
            new Item(19470), new Item(19469), new Item(666), new Item(15424), new Item(674), new Item(22078),
            new Item(4369), new Item(15877), new Item(16269), new Item(15943), new Item(675), new Item(702),
            new Item(700), new Item(701), new Item(17708), new Item(5095), new Item(19140), new Item(19139),
            new Item(19138), new Item(15922), new Item(16021), new Item(15933), new Item(17600), new Item(19944),
            new Item(17714), new Item(17686), new Item(15924),
            new Item(16023), new Item(15935), new Item(15888), new Item(15818), new Item(12994), new Item(16272),
            new Item(8809), new Item(8806), new Item(8807), new Item(8808), new Item(12284), new Item(15005),
            new Item(15006), new Item(15007), new Item(15008), new Item(15100), new Item(15200), new Item(15201),
            new Item(20549), new Item(8800), new Item(8801), new Item(8802), new Item(17712), new Item(17638),
            new Item(17640), new Item(15593), new Item(16140), new Item(2021), new Item(12860), new Item(12565),
            new Item(20173), new Item(8803), new Item(8804), new Item(8805), new Item(8812), new Item(20542),
            new Item(8805), new Item(13300), new Item(13301), new Item(13304), new Item(18683), new Item(15511),
            new Item(13306), new Item(18817), new Item(13302), new Item(13305), new Item(15230), new Item(15231),
            new Item(15232), new Item(15233), new Item(15234), new Item(17662), new Item(15235), new Item(15236),
            new Item(21031), new Item(21032), new Item(21033), new Item(21034), new Item(21035), new Item(13640),
            new Item(15448), new Item(21934), new Item(19918), new Item(19913), new Item(13964), new Item(3107)),
    SLAYERU(Player.SLAYER_BOXESU_OPENED, LogType.BOXES, "Slayer Crate (u)", new int[] {CollectionLog.SLAYERU}, Player.SLAYER_BOXU_LOG_CLAIMED, new Item[] { new Item(20489,3) },
            new Item(12855), new Item(5022), new Item(15289), new Item(19116), new Item(19115), new Item(19114),
            new Item(15358), new Item(15359), new Item(18750), new Item(18753), new Item(18752), new Item(18751),
            new Item(18636), new Item(18749), new Item(18748), new Item(18638), new Item(18629), new Item(18631),
            new Item(18637), new Item(18623), new Item(10947), new Item(15288), new Item(4446), new Item(19886),
            new Item(1486), new Item(10946), new Item(3737), new Item(3738), new Item(3739)),
    DRAGON_BALL(Player.DRAGON_BALL_BOXES_OPENED, LogType.BOXES, "Dragonball Saga box", new int[] {CollectionLog.DRAGON_BALL}, Player.DRAGON_BALL_BOX_LOG_CLAIMED, new Item[] { new Item(6769,2) },
            new Item(2025), new Item(6199), new Item(18686), new Item(18799), new Item(5095), new Item(15290),
            new Item(7956), new Item(14827), new Item(14818), new Item(14820), new Item(11195), new Item(10946),
            new Item(19116), new Item(15418), new Item(17291), new Item(3318), new Item(19136), new Item(10887),
            new Item(15289), new Item(6769), new Item(9481), new Item(9482), new Item(9483), new Item(9478),
            new Item(9479), new Item(9480)),
    RAID_BOX(Player.RAID_BOXES_OPENED, LogType.BOXES, "Raid box", new int[] {CollectionLog.RAID_BOX}, Player.RAID_BOX_LOG_CLAIMED, new Item[] { new Item(23370,5) },
            new Item(12855), new Item(19116), new Item(8800), new Item(8801), new Item(8802), new Item(8803),
            new Item(8804), new Item(8805), new Item(8806), new Item(8807), new Item(8808), new Item(22077),
            new Item(19136), new Item(6936), new Item(15289), new Item(19115), new Item(8326), new Item(8327),
            new Item(8328), new Item(22084), new Item(8330), new Item(8331), new Item(8332), new Item(22083),
            new Item(8323), new Item(8324),new Item(8325), new Item(22092),new Item(10025), new Item(20488),
            new Item(19114), new Item(15288),new Item(19886), new Item(4446),new Item(1486), new Item(20489),
            new Item(10946), new Item(15002),new Item(15288), new Item(6769),new Item(15004), new Item(5012),
            new Item(12535), new Item(17011),new Item(4684), new Item(4685),new Item(4686)),
    LAUNCH_CASKET(Player.LAUNCH_BOXES_OPENED, LogType.BOXES, "Launch Casket", new int[] {CollectionLog.LAUNCH_CASKET}, Player.LAUNCH_BOX_LOG_CLAIMED, new Item[] { new Item(15003,2) },
            new Item(8326), new Item(8330), new Item(8323), new Item(8327), new Item(8331), new Item(8324),
            new Item(8328), new Item(8332), new Item(8325), new Item(22084), new Item(22083), new Item(22092),
            new Item(10946), new Item(6769), new Item(15288), new Item(18753), new Item(18749), new Item(18631),
            new Item(18752), new Item(18748), new Item(18637), new Item(18751), new Item(18638), new Item(18623),
            new Item(18750), new Item(18636),new Item(18629), new Item(4446),new Item(19886), new Item(10942),
            new Item(8253), new Item(8087),new Item(8088), new Item(8089),new Item(10947), new Item(12608),
            new Item(10934), new Item(3578)),
    AZURE_CASKET(Player.AZURE_CASKETS_OPENED, LogType.BOXES, "Azure Casket", new int[] {CollectionLog.AZURE_CASKET}, Player.AZURE_CASKET_LOG_CLAIMED, new Item[] { new Item(15002,2) },
            new Item(12855), new Item(5022), new Item(20488), new Item(20489), new Item(19886), new Item(4446),
            new Item(10934), new Item(10935), new Item(3578), new Item(15288), new Item(18818), new Item(18881),
            new Item(18883), new Item(19810)),
    ELITE_CASKET(Player.ELITE_CASKETS_OPENED, LogType.BOXES, "Elite Casket", new int[] {CollectionLog.ELITE_CASKET}, Player.ELITE_CASKET_LOG_CLAIMED, new Item[] { new Item(15004,1) },
            new Item(20488), new Item(19886), new Item(4446), new Item(10934), new Item(10935), new Item(3578),
            new Item(20489),new Item(15288), new Item(18818), new Item(18881), new Item(18883), new Item(19810),
            new Item(20591), new Item(12630)),
    EXCLUSIVE_CASKET(Player.EXCLUSIVE_CASKETS_OPENED, LogType.BOXES, "Exclusive Casket", new int[] {CollectionLog.EXCLUSIVE_CASKET}, Player.EXCLUSIVE_CASKET_LOG_CLAIMED, new Item[] { new Item(14999,1) },
            new Item(20488), new Item(19886), new Item(4446), new Item(20489), new Item(10934), new Item(10935),
            new Item(3578), new Item(22121),new Item(15288), new Item(18818), new Item(18881), new Item(18883),
            new Item(19810), new Item(20400), new Item(12630), new Item(17011), new Item(12535), new Item(5012),
            new Item(7995)),
    LEGENDARY_CASKET(Player.LEGENDARY_CASKETS_OPENED, LogType.BOXES, "Legendary Casket", new int[] {CollectionLog.LEGENDARY_CASKET}, Player.LEGENDARY_CASKET_LOG_CLAIMED, new Item[] { new Item(23253,1) },
            new Item(20489), new Item(10934), new Item(15288), new Item(10935), new Item(18823), new Item(19888),
            new Item(3578), new Item(22121),new Item(18818), new Item(18888), new Item(18881), new Item(18883),
            new Item(19810), new Item(12630), new Item(12535), new Item(17011), new Item(5012), new Item(7995),
            new Item(9083), new Item(23254), new Item(4442), new Item(22110)),
    SURREME_CASKET(Player.SUPREME_CASKETS_OPENED, LogType.BOXES, "Supreme Casket", new int[] {CollectionLog.SUPREME_CASKET}, Player.SUPREME_CASKET_LOG_CLAIMED, new Item[] { new Item(23279,1) },
            new Item(15004), new Item(10935), new Item(3578), new Item(15288), new Item(10943), new Item(23240),
            new Item(22121),new Item(18818), new Item(18888), new Item(18881), new Item(18883), new Item(19810),
            new Item(12630), new Item(17013), new Item(5011), new Item(12537), new Item(7995), new Item(9083),
            new Item(23254), new Item(4442), new Item(22110)),

    //Minigames
    PYRAMID_OUTBREAK(Player.PYRAMID_OUTBREAK_COMPLETED, LogType.MINIGAMES, "Pyramid Outbreak", new int[] {CollectionLog.PYRAMID_OUTBREAK}, Player.PYRAMID_OUTBREAK_LOG_CLAIMED, new Item[] { new Item(10946, 3) },
            new Item(4151), new Item(11235), new Item(15486), new Item(18353), new Item(7462),
            new Item(15031), new Item(6585), new Item(7956), new Item(22077), new Item(6927),
            new Item(6928), new Item(6929), new Item(19136), new Item(6930), new Item(6931),
            new Item(6932), new Item(6936), new Item(6933), new Item(6934), new Item(6935),
            new Item(12634), new Item(23045),  new Item(10946)),
    UNKNOWN_MINIGAME(Player.UNKNOWN_MINIGAMES_COMPLETED, LogType.MINIGAMES, "Unknown Crypt", new int[] {CollectionLog.UNKNOWN_MINIGAME}, Player.UNKNOWN_MINIGAMES_LOG_CLAIMED, new Item[] { new Item(10946, 3) },
            new Item(15289), new Item(19115), new Item(15288), new Item(7677),
            new Item(10946), new Item(6769)),
   /* ISLES_OF_AVALON(Player.ISLES_OF_AVALON_COMPLETED, LogType.MINIGAMES, "Isles of Levincia", new int[] {CollectionLog.ISLES_OF_AVALON}, Player.ISLES_OF_AVALON_LOG_CLAIMED, new Item[] { new Item(6769, 1) },
            new Item(23165), new Item(23166), new Item(23167), new Item(23168), new Item(23169),
            new Item(23170), new Item(23092), new Item(23093), new Item(23094)),*/
    TREASURE_HUNTER(Player.TREASURE_HUNTER_COMPLETED, LogType.MINIGAMES, "Treasure Hunter", new int[] {CollectionLog.TREASURE_HUNTER}, Player.TREASURE_HUNTER_LOG_CLAIMED, new Item[] { new Item(10942, 3) },
            new Item(12855), new Item(5022), new Item(15290), new Item(10025), new Item(7956),
            new Item(19114), new Item(19115), new Item(20488), new Item(23044), new Item(6769),
            new Item(23161), new Item(23162), new Item(23163), new Item(22110)),
    PEST_CONTROL(Player.PEST_CONTROL_COMPLETED, LogType.MINIGAMES, "Pest Control", new int[] {CollectionLog.PEST_CONTROL}, Player.PEST_CONTROL_LOG_CLAIMED, new Item[] { new Item(15002,2) },
            new Item(11674), new Item(11676), new Item(11675), new Item(8839), new Item(8840),
            new Item(8842), new Item(15288), new Item(22219), new Item(15358), new Item(15359),
            new Item(20488)),
    SUFFERING_RAIDS(Player.SUFFERING_COMPLETED, LogType.MINIGAMES, "Souls of Suffering", new int[] {CollectionLog.SUFFERING_KEY}, Player.SUFFERING_LOG_CLAIMED, new Item[] { new Item(14999) },
            new Item(23303), new Item(23304), new Item(23305), new Item(23306), new Item(23307),
            new Item(23308), new Item(23309), new Item(23310), new Item(23311), new Item(14999),
            new Item(23276), new Item(23403), new Item(15288)),

    ELDER_GODS(Player.SUFFERING_COMPLETED, LogType.MINIGAMES, "Elder Gods", new int[] {CollectionLog.ELDER_GODS}, Player.SUFFERING_LOG_CLAIMED, new Item[] { new Item(13299) },
            new Item(13289), new Item(13297), new Item(18493), new Item(13273), new Item(13274),
            new Item(13275), new Item(13662), new Item(18487), new Item(13597), new Item(23278),
            new Item(9083), new Item(22110)),
    ;

    private int attributeKey;
    private final LogType logType;
    private final String name;
    private final int[] key;
    private final Boolean rewardClaimed;
    private final Item[] reward;
    private final Item[] obtainables;

    Collection(int attributeKey, LogType logType, String name, int[] key, Boolean rewardClaimed, Item[] reward, Item... obtainables) {
        this.attributeKey = attributeKey;
        this.logType = logType;
        this.name = name;
        this.key = key;
        this.rewardClaimed = rewardClaimed;
        this.reward = reward;
        this.obtainables = obtainables;
    }

    public int getAttributeKey() {
        return attributeKey;
    }
public void increaseKills(){
        this.attributeKey++;
}
    public String getName() {
        return name;
    }


    public int[] getKey() {
        return key;
    }

    public Boolean getRewardClaimedKey() {
        return rewardClaimed;
    }
    public void setRewardClaimedKey(Boolean rewardClaimed) {
         rewardClaimed = rewardClaimed;
    }
    public Item[] getReward() {
        return reward;
    }

    public Item[] getObtainables() {
        return obtainables;
    }

    public LogType getLogType() {
        return logType;
    }

    /**
     * The amount of items we can obtain.
     */
    public int totalCollectables() {
        return obtainables.length;
    }

    /**
     * Gets all the data for a specific type.
     * @param logType the log type that is being sorted at alphabetical order
     */
    public static List<Collection> getAsList(LogType logType) {
     //   return Arrays.stream(values()).filter(type -> type.getLogType() == logType).sorted(Comparator.comparing(Enum::name)).collect(Collectors.toList());
        return Arrays.stream(values()).filter(type -> type.getLogType() == logType).collect(Collectors.toList());

    }
}
