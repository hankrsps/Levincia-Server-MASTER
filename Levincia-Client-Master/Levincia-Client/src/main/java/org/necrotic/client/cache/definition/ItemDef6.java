package org.necrotic.client.cache.definition;

public class ItemDef6 {

	private static final int VOID_SCYTHE_MODEL_ID = 89990;

	public static ItemDefinition newIDS(ItemDefinition itemDef, int id) {

		switch (id) {
			case 22622:
				installVoidScytheModel();
				// ItemDefinition later copies item 1419 for Shadow Scythe. Update that
				// source definition first so the existing case picks up our custom model.
				ItemDefinition scytheBase = ItemDefinition.get(1419);
				scytheBase.modelID = VOID_SCYTHE_MODEL_ID;
				scytheBase.maleEquip1 = VOID_SCYTHE_MODEL_ID;
				scytheBase.femaleEquip1 = VOID_SCYTHE_MODEL_ID;
				scytheBase.modelZoom = 1350;
				scytheBase.rotationX = 300;
				scytheBase.rotationY = 50;
				scytheBase.rotationZ = 0;
				scytheBase.modelOffsetX = 0;
				scytheBase.modelOffsetY = 0;
				break;

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

	private static void installVoidScytheModel() {
		try {
			java.nio.file.Path rawDir = java.nio.file.Paths.get(
					org.necrotic.client.Signlink.getCacheDirectory(), "data", "raw");
			java.nio.file.Files.createDirectories(rawDir);
			java.nio.file.Path target = rawDir.resolve(VOID_SCYTHE_MODEL_ID + ".dat");
			if (java.nio.file.Files.exists(target)) {
				return;
			}

			StringBuilder encoded = new StringBuilder();
			for (int part = 1; part <= 3; part++) {
				String resource = "/models/89990.part" + part;
				try (java.io.InputStream input = ItemDef6.class.getResourceAsStream(resource)) {
					if (input == null) {
						System.err.println("Missing bundled Void Scythe resource: " + resource);
						return;
					}
					java.io.ByteArrayOutputStream output = new java.io.ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int read;
					while ((read = input.read(buffer)) != -1) {
						output.write(buffer, 0, read);
					}
					encoded.append(new String(output.toByteArray(), java.nio.charset.StandardCharsets.US_ASCII));
				}
			}

			byte[] modelData = java.util.Base64.getDecoder().decode(encoded.toString());
			java.nio.file.Files.write(target, modelData);
			System.out.println("Installed Void Scythe model: " + target.toAbsolutePath());
		} catch (java.io.IOException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
