package org.necrotic.client.cache.definition;

public class ItemDef6 {

	public static ItemDefinition newIDS(ItemDefinition itemDef, int id) {

		switch (id) {
			case 23690:
				itemDef.copyItem(3578);
				itemDef.modelID = 57640;
				itemDef.modelZoom = 609;
				itemDef.name = "Slayer relic";
				break;

			case 19640:
				itemDef.name = "Whispering Leaves";
				break;
			case 7700:
				itemDef.name = "Tea of Insight";
				break;
			case 8977:
				itemDef.name = "Rare bark shavings";
				break;

			case 30:
				itemDef.name = "Enchanted honey";
				break;

		}
		return itemDef;
	}
}
