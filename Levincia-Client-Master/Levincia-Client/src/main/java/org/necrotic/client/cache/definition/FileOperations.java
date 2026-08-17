package org.necrotic.client.cache.definition;

import java.io.*;

public class FileOperations {
	private static int totalRead = 0;
	private static int totalWrite = 0;
	private static int completeWrite = 0;

	public static byte[] readFile(String fileName) {
		try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName))) {
			byte[] data = new byte[(int) new File(fileName).length()];
			input.read(data);
			totalRead++;
			return data;
		} catch (Exception ex) {
			return null;
		}
	}

	public static void writeFile(String fileName, byte[] data) {
		try {
			// Create parent directories if needed.
			File file = new File(fileName);
			File parent = file.getParentFile();
			if (parent != null) {
				parent.mkdirs();
			}

			// Write the data to the file.
			try (FileOutputStream output = new FileOutputStream(fileName)) {
				output.write(data);
				totalWrite++;
				completeWrite++;
			}
		} catch (Throwable ex) {
			System.out.println("Write Error: " + fileName);
		}
	}

	public static boolean fileExists(String fileName) {
		return new File(fileName).exists();
	}

	public static int getTotalRead() {
		return totalRead;
	}

	public static int getTotalWrite() {
		return totalWrite;
	}

	public static int getCompleteWrite() {
		return completeWrite;
	}
}
