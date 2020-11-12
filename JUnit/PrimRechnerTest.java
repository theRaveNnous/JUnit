/**
 * 
 */
package JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

/**
 * @author Daniel
 */
class PrimRechnerTest {
  /**
   * Test method for {@link JUnit.PrimRechner#rechne()}.
   */
  @Test
  void testRechne() {
    String[] args = new String[2];
    args[0] = "3";
    args[1] = "ausgabe.txt";
    String fertigePrimzahlen = "2 3 5 ";
    PrimRechner testrechne = new PrimRechner(args);
    testrechne.rechne();
    assertEquals(fertigePrimzahlen, testrechne.getfertigePrimzahlen());
  }

  /**
   * Test method for {@link JUnit.PrimRechner#holeAusgabe(java.lang.String[])}.
   */
  @Test
  void testHoleAusgabe() {
    String[] args = new String[1];
    args[0] = "1";
    PrimRechner testausgabe = new PrimRechner(args);
    String ausgabe = testausgabe.holeAusgabe(args);
    assertEquals(ausgabe, "alternativausgabe.txt");
    
    String[] args2 = new String[2];
    args2[0] = "1";
    args2[1] = "ausgabe.txt";
    String ausgabe2 = testausgabe.holeAusgabe(args2);
    assertEquals(ausgabe2, "ausgabe.txt");
  }

  /**
   * Test method for {@link JUnit.PrimRechner#holeAnzahl(java.lang.String[])}.
   */
  @Test
  void testHoleAnzahl() {
    String[] args = new String[1];
    args[0] = "50";
    PrimRechner testanzahl = new PrimRechner(args);
    int anzahl = testanzahl.getAnzahl();
    assertEquals(anzahl, 50);
  }

  /**
   * Test method for {@link JUnit.PrimRechner#writeToFile()}.
   * @throws FileNotFoundException 
   */
  @Test
  void testWriteToFile() throws FileNotFoundException {
    String[] args = new String[2];
    args[0] = "5";
    args[1] = "ausgabe.txt";
    new PrimRechner(args);
    Scanner sc = new Scanner(new File("ausgabe.txt"));
    String ergebnis = "";
    while(sc.hasNextLine()){
        ergebnis = sc.nextLine();                     
    }
    String str = "2 3 5 7 11 ";
    assertEquals(ergebnis, str);
  }
}