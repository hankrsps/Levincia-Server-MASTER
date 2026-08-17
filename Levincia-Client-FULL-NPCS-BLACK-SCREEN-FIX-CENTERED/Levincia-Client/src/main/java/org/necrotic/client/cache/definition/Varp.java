package org.necrotic.client.cache.definition;

import org.necrotic.client.cache.Archive;
import org.necrotic.client.io.ByteBuffer;

public final class Varp {
	private static Varp[] cache;
	private static int[] varpIndices;

	public static void load(Archive archive) {
		ByteBuffer buffer = new ByteBuffer(archive.get("varp.dat"));
		int size = buffer.getUnsignedShort();

		if (cache == null) {
			cache = new Varp[size];
		}

		if (varpIndices == null) {
			varpIndices = new int[size];
		}

		for (int i = 0; i < size; i++) {
			if (cache[i] == null) {
				cache[i] = new Varp();
			}

			cache[i].readValues(buffer, i);
		}

		if (buffer.position != buffer.buffer.length) {
			System.out.println("varptype load mismatch");
		}
	}

	private int value;

	private Varp() {
	}

	private void readValues(ByteBuffer stream, int index) {
		while (true) {
			int opcode = stream.getUnsignedByte();

			if (opcode == 0) {
				return;
			}

			switch (opcode) {
				case 1:
				case 2:
					stream.getUnsignedByte();
					break;
				case 3:
					varpIndices[index] = index;
					break;
				case 5:
					setValue(stream.getUnsignedShort());
					break;
				case 7:
				case 12:
					stream.getIntLittleEndian();
					break;
				case 8:
				case 11:
					break;
				case 10:
					stream.getString();
					break;
				default:
					System.out.println("Error unrecognised config code: " + opcode);
					break;
			}
		}
	}

	public static Varp[] getCache() {
		return cache;
	}

	public static int[] getVarpIndices() {
		return varpIndices;
	}

	public static void setCache(Varp[] cache) {
		Varp.cache = cache;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}