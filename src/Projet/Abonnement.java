package Projet;
import Praphe.*;
public class Abonnement extends Syst {
	private static int seq;
	private String nom;
	private String prenom;
	private String data;
	private String datex;
	private String type;
	private float prix;
	
	
	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDatex() {
		return datex;
	}

	public void setDatex(String datex) {
		this.datex = datex;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Abonnement(){
		
	}
	
	 public Abonnement(String nom, String prenom,String data,String datexp){
	    	this.nom=nom;this.prenom=prenom;this.data=data;this.type="annuelle";
	    	datex=datexp;
	    	 prix=5000;
			
		}
	 public Abonnement(String nom, String prenom,String data){
	    	this.nom=nom;this.prenom=prenom;this.data=data;this.type="trois spectacles";
	    	datex="1111-11-11";
	    	 prix=2000;
	    	
	    	
			
		}
	
	
	public static int getSeq() {
		return seq;
	}

	public static void setSeq(int seq) {
		Abonnement.seq = seq;
	}
	
	public void ajout(){
		ajout(seq+",'"+type+"',"+prix+",'"+nom+"','"+prenom+"','"+data+"','"+datex+"'", "Abonnement");
	}

	

}
