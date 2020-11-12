package JUnit;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class PrimRechner {
	private Path fileName;
	private String fertigePrimzahlen;
	private int countPrimzahl;
	private int anzahlPrimzahl;
	private String ausgabe;
	
	PrimRechner(String[] args) {
		this.countPrimzahl = 0;
		this.fertigePrimzahlen = "";
		this.anzahlPrimzahl = holeAnzahl(args);
		this.ausgabe = holeAusgabe(args);
		this.fileName = Path.of(ausgabe);
	}
	
	public void rechne() {
		for (int i = 2; i < Integer.MAX_VALUE; i++) {
			if (isPrim(i)) {
				countPrimzahl++;
				fertigePrimzahlen += i + " ";
				if ((countPrimzahl % 10) == 0) {
					fertigePrimzahlen += "\n";
				}
				if (countPrimzahl == anzahlPrimzahl) {
					break;
				}
			}
		}
	}
	
	
	// Hole Ausgabedatei(pfad) aus übergebene Startparametern
	// Falls kein Startparameter vorhanden, setze festen Pfad
	public String holeAusgabe(String[] args) {
		String ausgabe;
		if (args.length == 2) {
			ausgabe = args[1];
		} else {
			ausgabe = "alternativausgabe.txt";
		}
		return ausgabe;
	}

	// Hole Anzahl aus Startparametern. Frage ab, ob der Wert verändert werden soll
	public int holeAnzahl(String[] args) {
		int anzahl = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Die Anzahl der zu errechnenden Primzahlen ist " + args[0] + ". Möchten Sie diese ändern? y/n");
		System.out.print("Antwort: ");
		if (scanner.next().equals("y")) {
			while (anzahl < 1) {
				System.out.println("Wieviele Primzahlen sollen errechnet werden?");
				System.out.print("Antwort: ");
				String eingabe = scanner.next();
				if (validateInt(eingabe)) {
					anzahl = Integer.parseInt(eingabe);
				}
			}
		} else {
			anzahl = Integer.parseInt(args[0]);
		}
		scanner.close();
		return anzahl;
	}
		
	private boolean isPrim(int number) {
		//Überprüfe, ob die Zahl eine Primzahl ist
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				// Zahl ist keine Primzahl
				return false; 
			}
		}
		// Zahl ist Primzahl
		return true; 
	}

	private boolean validateInt(String string) {
		// Überprüfe, ob Zeichenkette nur Zahlen enthält
		// Andernfalls, return false
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
		
	public void writeToFile() {
		// Schreiben des gebildeten Textstrings in die vorher festgelegte Datei
		try {
			Files.writeString(fileName, fertigePrimzahlen);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}	
	}
	
	public String getFileName() {
		return ausgabe;
	}
	
	public int getAnzahl() {
		return anzahlPrimzahl;
	}
	
	public String getfertigePrimzahlen() {
		return fertigePrimzahlen;
	}
}