package Projet;

import Praphe.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Billet extends Syst {
	private static int seq;
	private int id;
	private static boolean admin=false;
	private double prix;
	private String date;
	
	private RepresentationA A=null;
	private RepresentationC C=null;
	private float  R=0;
	private String Ref;
	
	
	public Billet(){	}
	public Billet(boolean admin){
		this.admin=admin;
	}
	public Billet(RepresentationA A,String date,String cat){
	if(date!="1111-11-11")this.date=date;
	else this.date=daAct();
	this.A=A;id=seq;
			Ref=calRef(cat);
			if(Ref=="Normal") prix=A.getS().getPrixN();
			else prix=A.getS().getPrixR();
		if(admin) Red();
	C=null;	
	}
	public Billet(RepresentationC C,String date,String cat){
		A=null;
		this.date=date;this.C=C;id=seq;
		Ref=calRef(cat);
		if(Ref=="Normal") prix=C.getS().getPrixN();
		else prix=C.getS().getPrixR();
		if(admin) Red();
	}
	
	public static boolean isAdmin() {
		return admin;
	}
	public static void setAdmin(boolean admin) {
		Billet.admin = admin;
	}
	public float getR() {
		return R;
	}
	public void setR(int r) {
		R = r;
	}
	public String getRef() {
		return Ref;
	}
	public void setRef(String ref) {
		Ref = ref;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public RepresentationA getA() {
		return A;
	}
	public void setA(RepresentationA a) {
		A = a;
	}
	public RepresentationC getC() {
		return C;
	}
	public void setC(RepresentationC c) {
		C = c;
	}
	public int getId() {
		return id;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public static int getSeq() {
		return seq;
	}
	public static void setSeq(int seq) {
		Billet.seq = seq;
	}
	public Billet[] Billets(){
		Billet[] Tab=new Billet[1000]; int i=0;
		ResultSet r;
		if(C==null)
		r=this.Rech("idR", ""+A.getS().getIdS(), "Billet");
		else  r=this.Rech("idR", ""+C.getS().getIdS(), "Billet");
		
		try{
			while(r.next())
			{
				Tab[i].setId(r.getInt(1));
				Tab[i].setA(A);
				Tab[i].setC(C);
				Tab[i].setDate(r.getString(3));
				Tab[i].setPrix(r.getInt(5));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return Tab;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String calRef(String cat){
		switch (cat){
		
		case "Enfant": return "Réduit";
		case "Personnes âgée": return "Réduit";
		case "Chômeur": return "Réduit";
		case "Etudiant": return "Réduit";
		default:  return "Normal";
		}
	}
	public void Red(){
		int id; int max;String da;
		if(C==null) {id=A.getIdR();max=A.getMax();da=A.getDate();}
		else {id=C.getIdR();max=C.getMax();da=C.getDate();}
		
		int jAc=0,nbrVnd=0;
		
		 jAc=(dj(date)+dm(date)*30+da(date)*12*30)-(dj(da)+dm(da)*30+da(da)*12*30)+30;
		 ResultSet lesb= res("select * from Billet where idr="+id);
			try{
				while(lesb.next())
					nbrVnd++;
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			double prc=0;
			if(nbrVnd!=0)prc=max/nbrVnd;
			else prc=0;
		
			if (jAc<=5) R=20;
			else if(jAc>14){
				if(prc<0.3) R=50;
				else if(prc<0.5) R=30;
			}
			if(R!=0) prix=prix-prix*(R/100);
			
			int ver=(int) (prix*100);
			prix=ver/100;
	}
	public void ajout(){
		int idx;
		if (C==null)
			idx=A.getIdR();
		else idx=C.getIdR();
			
		ajout(id+","+idx+",'"+date+"','"+R+"%',"+prix+",'"+Ref+"'", "Billet");
	}
	public boolean getAdmin(){
		return admin;
	}
	}
