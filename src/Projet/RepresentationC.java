package Projet;

import Praphe.*;
public class RepresentationC extends Syst {
	
	private int idR;
	private static int idv;
	private static int init=1000000;
	private static int seqR;
	private float prixV;
	private String companyV;
	private float coutMS;
	private String date;
	private SpectacleC S;
	private int max;
	public  int getInit() {
		return init;
	}

	public static void setInit(int init) {
		RepresentationC.init = init;
	}

	public static void setSeqR(int seqR) {
		RepresentationC.seqR = seqR;
	}


	public RepresentationC(){	}

	public RepresentationC(float coutMS,String date,SpectacleC S,int max){

		this.date=date;this.coutMS=coutMS; this.S=S;this.max=max;
		idR=seqR++;
		
	}
	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public void setIdR(int idR) {
		this.idR = idR;
	}

	public float getPrixV() {
		return prixV;
	}

	public void setPrixV(float prixV) {
		this.prixV = prixV;
	}

	public String getCompanyV() {
		return companyV;
	}

	public void setCompanyV(String companyV) {
		this.companyV = companyV;
	}

	public float getCoutMS() {
		return coutMS;
	}

	public void setCoutMS(float coutMS) {
		this.coutMS = coutMS;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIdR() {
		return idR;
	}

	public static int getSeqR() {
		return seqR;
	}

	public void Vente(String companyV,float prixV){
		this.companyV=companyV;this.prixV=prixV;
		ajout(idv+","+idR+","+prixV+",'"+companyV+"'", "VenteR");
	}

	public void ajout(){
		ajout(idR+",'"+date+"',"+coutMS+","+max+","+S.getIdS(), "RepresentationC");
	}

	public SpectacleC getS() {
		return S;
	}

	public void setS(SpectacleC s) {
		S = s;
	}

	public static int getIdv() {
		return idv;
	}

	public static void setIdv(int idv) {
		RepresentationC.idv = idv;
	}

	

	

}
