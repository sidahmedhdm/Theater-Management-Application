package Praphe;
import Projet.*;
import Projet.Syst;

public class Recette extends Syst {
	private float sub;
	private float venr;
	private float beil;
	private static int seq;
	public float getSub() {
		return sub;
	}
	public void setSub(float sub) {
		this.sub = sub;
	}
	public float getVenr() {
		return venr;
	}
	public void setVenr(float venr) {
		this.venr = venr;
	}
	public float getBeil() {
		return beil;
	}
	public void setBeil(float beil) {
		this.beil = beil;
	}
	public static int getSeq() {
		return seq;
	}
	public static void setSeq(int seq) {
		Recette.seq = seq;
	}

}
