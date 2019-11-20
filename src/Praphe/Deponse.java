package Praphe;
import Projet.*;
import Projet.Syst;

public class Deponse extends Syst {
	private float achatS;
	private float cousMS;
	private static int seq;
	public float getAchatS() {
		return achatS;
	}
	public void setAchatS(float achatS) {
		this.achatS = achatS;
	}
	public float getCousMS() {
		return cousMS;
	}
	public void setCousMS(float cousMS) {
		this.cousMS = cousMS;
	}
	public static int getSeq() {
		return seq;
	}
	public static void setSeq(int seq) {
		Deponse.seq = seq;
	}
	
	
}
