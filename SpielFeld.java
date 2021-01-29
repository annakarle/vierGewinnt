package Programmieren;

import edu.bielefeld.io.EAM;
import edu.princeton.cs.introcs.StdDraw;

public class SpielFeld {
	public static SpielStein [][] spielsteine ;
	
	public static final int anzahlZeilen = 6; 
	public static final int anzahlSpalten = 7;
	public static final int drawingSize = 80;
	
	public  SpielFeld () {
		this.spielsteine = new SpielStein [anzahlZeilen][anzahlSpalten];
		spielsteine [0][0] = new SpielStein (true);
		spielsteine [0][1] = new SpielStein (true);
		spielsteine [0][3] = new SpielStein (false);
		spielsteine [1][3] = new SpielStein (false);
		
	}
	
	
	public static void zeichne() { 
		
		StdDraw.setXscale(0, drawingSize); 
		StdDraw.setYscale(0, drawingSize);
	
		final int breite = drawingSize/anzahlSpalten; 
		final int hoehe = drawingSize/anzahlZeilen; 
		final int radius = Math.min(breite, hoehe)/2-1;
	
		for( int zeile=0; zeile<anzahlZeilen; zeile++) {
			for(int spalte=0; spalte<anzahlSpalten; spalte++) {
				StdDraw.circle(spalte*breite+breite/2, zeile*hoehe+hoehe/2, radius); 
			} 
		}
		for( int zeile=0; zeile<anzahlZeilen; zeile++) {
			for(int spalte=0; spalte<anzahlSpalten; spalte++) {
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.circle(spalte*breite+breite/2, zeile*hoehe+hoehe/2, radius); 
				if (spielsteine [zeile][spalte] != null) {
					if (spielsteine [zeile][spalte].isRed()) {
						StdDraw.setPenColor(StdDraw.RED);
					    StdDraw.filledCircle(spalte*breite+breite/2, zeile*hoehe+hoehe/2, radius-1);
					}else {
						StdDraw.setPenColor(StdDraw.YELLOW);
					    StdDraw.filledCircle(spalte*breite+breite/2, zeile*hoehe+hoehe/2, radius-1);
					}
					
				}
			}
		}
	}
	
	
	public boolean steinHinzufuegen(int spalte, boolean istRot) {
		if (spielsteine [anzahlZeilen-1][spalte-1] != null) {
			EAM.pln("Fehler!");
			return false;
		}
		int zeile;
		for ( zeile = anzahlZeilen-1; zeile >= 0; zeile --) {
			if(spielsteine[zeile][spalte-1] != null )
				break;
			
			
		}
		spielsteine [zeile + 1][spalte - 1] = new SpielStein (istRot);
		return true;
	}
	
	public boolean horizontalGewinn(int spalte) {
		for (int zeile = 0; zeile < anzahlZeilen; zeile ++ ) {
			for ( spalte = 0; spalte < anzahlSpalten ; spalte++) {
				if (spielsteine [zeile][spalte] != null && spielsteine [zeile] [spalte+1]!= null && spielsteine [zeile] [spalte+2]!= null && spielsteine [zeile] [spalte+3]!= null) {
					if( spielsteine [zeile] [spalte].isRed() && spielsteine [zeile] [spalte+1].isRed() && spielsteine [zeile] [spalte+2].isRed() && spielsteine [zeile] [spalte+3].isRed()  ) {
					  EAM.pln("ROT hat gewonnen.");
					  return true;
				  }else if(spielsteine [zeile] [spalte].isYellow() && spielsteine [zeile] [spalte+1].isYellow() && spielsteine [zeile] [spalte+2].isYellow() && spielsteine [zeile] [spalte+3].isYellow() ){
					  EAM.pln("GELB hat gewonnen.");
					  return true;
				  }
				  
				} 
			
			}
			
		}
		return false;
	}

}
