package JUnit;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		PrimRechner primRechner = new PrimRechner(args);
		primRechner.rechne();
		primRechner.writeToFile();
		System.out.println("Es wurden " + primRechner.getAnzahl() + " Primzahlen in die Datei " + primRechner.getFileName() + " geschrieben.");
	}
}