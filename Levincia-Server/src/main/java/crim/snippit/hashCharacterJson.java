package crim.snippit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class hashCharacterJson {

	public static String DIR = "E:/NecroticRepo/Source/data/saves/characters/";

	public static void main(String[] args) {
	}

	public static boolean validString(String target) {
		if (target == null) {
			return false;
		}
		if (target.equalsIgnoreCase("")) {
			return false;
		}
		if (target.equalsIgnoreCase("null")) {
			return false;
		}
		return true;
	}

	public static void getResult(String filename) {
		// System.out.println(filename + " operation.");

		// Create the path and file objects.
		Path path = Paths.get(DIR, filename);
		File file = path.toFile();

		// If the file doesn't exist, we're logging in for the first
		// time and can skip all of this.
		if (!file.exists()) {
			return;
		}

		// Now read the properties from the json parser.
		try (FileReader fileReader = new FileReader(file)) {
			JsonParser fileParser = new JsonParser();
			JsonObject reader = (JsonObject) fileParser.parse(fileReader);
			Gson builder = new GsonBuilder().setPrettyPrinting().create();
			JsonObject object = new JsonObject();

			boolean hashed = false;
			String hash = "";
			String password = "";
			String salt = "";

			if (reader.has("hashed")) {
				hashed = reader.get("hashed").getAsBoolean();
			}

			if (reader.has("hash")) {
				hash = reader.get("hash").getAsString();
			}

			if (reader.has("password")) {
				password = reader.get("password").getAsString();
			}

			if (reader.has("salt")) {
				salt = reader.get("salt").getAsString();
			}

			if (hashed == false && validString(password) && !validString(hash) && !validString(salt)) {
				// System.out.println("We would handle hashing here.");
			} else {
				// System.out.println("NOT handling hashing.");
				return;
			}

			try (FileWriter writer = new FileWriter(file)) {

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
