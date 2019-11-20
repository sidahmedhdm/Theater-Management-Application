package Projet;
import Praphe.*;
public class Spectacle extends Syst{

	protected int idS;
	private static int seq=500;
	private static final int init=499;
	protected String nom;
	protected float prixN;
	protected float prixR;
	
	public Spectacle(){	}
	public Spectacle(String nom,float pn,float pr){	
		this.nom=nom;prixN=pn;prixR=pr;
		idS=seq++;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		Spectacle.seq = seq;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getPrixN() {
		return prixN;
	}
	public void setPrixN(float prixN) {
		this.prixN = prixN;
	}
	public float getPrixR() {
		return prixR;
	}
	public void setPrixR(float prixR) {
		this.prixR = prixR;
	}
	public int getIdS() {
		return idS;
	}
	public  int getInit() {
		return init;
	}
	public String getCompany(){
		return "";
	}
	public float getPrix(){
		return 0;
	}
	public void setIdS(int idS) {
		this.idS = idS;
	}
	
	
}
