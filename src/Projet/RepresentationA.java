package Projet;

import Praphe.*;
public class RepresentationA extends Syst {
	private int idR;
	private static int init=0;
	private static int seqR=1;
	private String date;
	private int max;
	SpectacleA S;

	
	public  int getInit() {
		return init;
	}
	public  void setInit(int init) {
		RepresentationA.init = init;
	}
	public  void setSeqR(int seqR) {
		RepresentationA.seqR = seqR;
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
	public RepresentationA(){	}
	public RepresentationA(String date,SpectacleA S,int max)
	{
			idR=seqR;	this.date=date; this.S=S; this.max=max;
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
	public void ajout(){
		ajout(idR+",'"+date+"',"+max+","+S.getIdS(), "RepresentationA");
	}
	public SpectacleA getS() {
		return S;
	}
	public void setS(SpectacleA s) {
		S = s;
	}
	


}
