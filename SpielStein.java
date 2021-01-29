package Programmieren;

public class SpielStein {
	
	private boolean istRot;
	private boolean istGelb;
	public SpielStein (boolean isRed) {
		this.istRot = isRed;
	}
	
	public boolean isRed() {
		return istRot;
	}
	
	public boolean isYellow() {
		return istGelb;
	}

}
