package Programmieren;

import edu.bielefeld.io.EAM;

public class VierGewinnt {
	
	public static SpielFeld spielFeld = new SpielFeld();

	public static void main(String[] args) {
		EAM.pln("Hallo zum Spiel Vier Gewinnt");
		
		SpielFeld.zeichne();
		
		while (true) {
			EAM.pln("ROT ist am Zug. Auf welche Spalte wollen Sie legen? ");
			int spalte = EAM.rInt();
			
			spielFeld.steinHinzufuegen(spalte, true);
			SpielFeld.zeichne();
			spielFeld.horizontalGewinn(spalte - 1);
			EAM.pln("GELB ist am Zug. Auf welche Spalte wollen Sie legen? ");
		    spalte = EAM.rInt();

			spielFeld.steinHinzufuegen(spalte, false);
			SpielFeld.zeichne();
			spielFeld.horizontalGewinn(spalte -1);
			
			
		}
		
		

	}

}
