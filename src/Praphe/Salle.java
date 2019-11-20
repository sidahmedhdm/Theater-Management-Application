package Praphe;
import Projet.*;

public class Salle {
	private static int vide = 0;
	private static int max = 0;
	private static int reserve=0;
	private static int idr=0;

	public Salle() {
		
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public Salle(int max) {
		this.max=max;
		vide=max;
		
	}

	public static int getVide() {
		return vide;
	}

	public static void setVide(int vide) {
		Salle.vide = vide;
	}

	public static int getReserve() {
		return reserve;
	}

	public static void setReserve(int reserve) {
		Salle.reserve = reserve;
	}
	public static boolean reserver(int places){
		if(vide<places) return false;
		else {
			vide-=places;
			reserve+=places;
			return true;
		}
	}

	public static int getIdr() {
		return idr;
	}

	public static void setIdr(int idr) {
		Salle.idr = idr;
	}
	
	
	

}
