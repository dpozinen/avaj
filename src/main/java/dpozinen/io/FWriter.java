package dpozinen.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

final public class FWriter {

	private static Path path;

	private FWriter() {}

	public static void create() {
		path = Paths.get("simulation.txt");
		try {
			Files.deleteIfExists(path);
			Files.createFile(path);
		} catch (Exception e) {
			System.err.println("Could not create file " + e);
		}
	}

	public static void write(String string) {
		try {
			Files.write(path, (string + "\n").getBytes(), StandardOpenOption.APPEND);
		} catch (Exception e) {
			System.err.println("Could not write to file " + e);
		}
	}
}