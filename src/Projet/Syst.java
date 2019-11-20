package Projet;
import Praphe.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;

import Praphe.Stat;

import java.sql.*;

public class Syst {
	//connection
	public static Font FO;
	 
	private static Connection c=null;
	//constricteure
	public Syst(){}
	public Syst(Connection c){
		this.c=c;
		FO=new Font("comic sans ms", Font.BOLD, 43);
	}
	
	boolean isNumber(char ch){
		if(ch!='0'&&ch!='1'&&ch!='2'&&ch!='3'&&ch!='4'&&ch!='5'&&ch!='6'&&ch!='7'&&ch!='8'&&ch!='9')
		return false;
		else return true;
	}
 public void ajout(String s,String t){
	 Statement st=null;
	 try{
		 st=c.createStatement();
		 st.execute("insert into "+t+" values("+s+")");
		 st.close();
	 }catch(SQLException sq){
		 sq.printStackTrace();
	 }
 }
 
 public void sup(int i,String t){
	 String cha = getCh(t);
	 
	
	 this.exe("delete from "+t+" where id"+cha+"="+i);
	  }

 public int getSeq(String t){
	 int o=0; String cha="";boolean b=false;
	
	 switch(t){
	 case "SpectacleA":cha="SA";o=new Spectacle().getInit();break;
	 case "SpectacleC":cha="SC";o=new Spectacle().getInit();break;
	 case "RepresentationA":cha="RA";o=new RepresentationA().getInit();break;
	 case "RepresentationC":cha="RC";o=new RepresentationC().getInit();break;
	 case "VenteR":cha="V";break;
	 case "Subvention":cha="S";break;
	 case "Billet":cha="B";break;
	 case "Abonnement":cha="Ab";break;
	 }
	 o++;
	 
	
		 ResultSet r=this.res("select id"+cha+" from "+t);
		 try{
			 while(r.next()&&!b){
				 
				 if(r.getInt(1)==o){o++;
}
				 else {b=true; 
}}
		 }catch(SQLException e){ e.printStackTrace();
		 }
	 return o;
 }
 
 public ResultSet res(String req){
	 Statement st=null;
	 ResultSet r=null;
	 try{
		 st=c.createStatement();
	     r=st.executeQuery(req);
	 }catch(SQLException sq){
		 sq.printStackTrace();
	 }
	 return r;
 }
 public void exe(String req){
	Statement st=null;
	 try{
		 st=c.createStatement();
		 st.execute(req);
		  st.close();
	 }catch(SQLException sq){
		 sq.printStackTrace();
	 }
 }
 public ResultSet Rech(String atr,String val,String t){
	 return this.res("select * from "+t+" where "+atr+" ="+val );
 }
 public ResultSet Rech(int id,String t){
	String cha= this.getCh(t);
	 
	 
	 
	return this.res("select * from "+t+" where id"+cha+" ="+id);
 }
 
 
 String getCh(String t)
 {String cha = t.charAt(0)+"";
 switch(t){
 case "SpectacleA":cha="SA";break;
 case "SpectacleC":cha="SC";break;
 case "RepresentationA":cha="RA";break;
 case "RepresentationC":cha="RC";break;
 case "VenteR":cha="V";break;
 case "Subvention":cha="S";break;
 case "Billet":cha="B";break;
 case "Abonnement":cha="Ab";break;
 }return cha;
 }
 
 public void videzT(String t){
	 this.exe("delete from "+t);
 }
 public void videzDB(){
	 this.videzT("Billet");
	 this.videzT("Subvention");
	 this.videzT("VenteR");
	 this.videzT("RepresentationC");
	 this.videzT("RepresentationA");
	 this.videzT("SpectacleA");
	 this.videzT("SpectacleC");
	 this.videzT("Abonnement");
 }
 public ResultSet RechC(int id,String t){
	 String cha = getCh(t);
	 
	return this.res("select * from "+t+" where id"+cha+" ="+id);
 }/*
 public Animal extA(int id){
	 Animal A = null;
	 ResultSet r=Rech(id,"Animal");
	 try{
		 if(r.next()){
			 A = new Animal();
			 A.setIda(r.getInt(1));
		     A.setIdc(r.getInt(2));
		     A.setNom(r.getString(3));
		     A.setRace(r.getString(4));}
	 }catch(SQLException e){
		 e.printStackTrace();
	 } return A;
 }*/
 /*
 public RDV extR(int id){
	 RDV R = null;
	 ResultSet r=Rech(id,"RDV");
	 try{
		 if(r.next()){
			 R = new RDV();
			 R.setIdR(r.getInt(1));
		     R.setIdC(r.getInt(2));
		     R.setIdA(r.getInt(3));
		     R.setD(r.getString(4));}
	 }catch(SQLException e){
		 e.printStackTrace();
	 } return R;}*/
 
 
 public void actualiser(){
	 int o=1;

	 o= getSeq("SpectacleA");
	 new Spectacle().setSeq(o);
	 
	 o= getSeq("RepresentationA");
	 new RepresentationA().setSeqR(o);
	 
	 o= getSeq("RepresentationC");
	 new RepresentationC().setSeqR(o);
	
	 
	 o= getSeq("Abonnement");
	 new Abonnement().setSeq(o);
	
	 o= getSeq("Billet");
	 new Billet().setSeq(o);
	 o=getSeq("Subvention");
	 new Stat().setId(o);
	 o=getSeq("VenteR");
	 new RepresentationC().setIdv(o);
	 
 }
	public JTable GetTable(String tab,String[] titre){
		Syst s=new Syst();
		Object data[][]=new Object[1000][titre.length];
	   ResultSet RC=s.res("select * from "+tab);int i=0;
	    try{
	    	while(RC.next()){
	    		for(int j=0;j<titre.length;j++){
	    		switch(titre[j].substring(0,2)){
	    		case "nb":data[i][j]=Integer.toString(RC.getInt(j+1));break;
	    		case "st":data[i][j]=RC.getString(j+1);break;
	    		case "fl":data[i][j]=RC.getFloat(j+1);break;
	    		default:System.out.println("fethi:"+titre[j].substring(0,1));break;
	    		}}
	    		
	    		i++;
	    		
	    	}
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
	    String[] tit=new String[titre.length];
	    for(int j=0;j<titre.length;j++){
	    	tit[j]=titre[j].substring(3, titre[j].length());
	    }
	   

	   JTable tableau = new JTable(data,tit);
	  
	   return tableau;
	}

	
	public JTable GetTableAt(String tab,String[] titre){
		Syst s=new Syst();
		Object data[][]=new Object[1000][titre.length];
	   ResultSet RC=s.res("select * from "+tab);int i=0;
	    try{
	    	while(RC.next()){
	    		for(int j=0;j<titre.length;j++){
	    		switch(titre[j].substring(0,2)){
	    		case "nb":data[i][j]=Integer.toString(RC.getInt(j+1));break;
	    		case "st":data[i][j]=RC.getString(j+1);break;
	    		case "fl":data[i][j]=RC.getFloat(j+1);break;
	    		default:System.out.println("fethi:"+titre[j].substring(0,1));break;
	    		}}
	    		
	    		i++;
	    		
	    	}
	    }catch(SQLException e){
	    	e.printStackTrace();
	    }
	    String[] tit=new String[titre.length];
	    for(int j=0;j<titre.length;j++){
	    	tit[j]=titre[j].substring(3, titre[j].length());
	    }
	   

	   JTable tableau = new JTable(data,tit);
	  
	   return tableau;
	}

	  
	  public String daAct(){
	  Date actuelle = new Date();
	  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  String dat = dateFormat.format(actuelle);
	  return dat;}
	  
	  public int dj(String date){
		  return Integer.parseInt(date.substring(8,10));
	  }
	  public int dm(String date){
		  return Integer.parseInt(date.substring(5,7));
	  }
	  public int da(String date){
		  return Integer.parseInt(date.substring(0,4));
	  }
	  
	  
	  public JLabel img(String url){
		  JLabel background=new JLabel();
			background.setIcon(new ImageIcon(url));
			return background;
	  }
	  
	  public JButton bot(JButton b,String Color){
		  String s="";
		  switch (Color){
		  case "Ajouter":s="add.png"; b.setBackground(new Color(230,226,235)); break;
		  case "Supprimer":s="delete.png"; b.setBackground(new Color(255,226,235));break;
		  case "Modifier":s="update.png";b.setBackground(new Color(230,255,235)); break;
		  case "Autre":b.setPreferredSize(new Dimension(70,30)); b.setBackground(new Color(180,211,200));break;
		  default : b.setPreferredSize(new Dimension(70, 30));break;
		  }
		  b.setFont(FO.deriveFont(Font.BOLD, 14));
		  ImageIcon im=new ImageIcon("src/img/button/"+s);
		  im=sizIm(im, 15, 15);
		  
		  b.setIcon(im);
		  return b;
	  }
	  public ImageIcon sizIm(ImageIcon im,int w,int h){
		  im.setImage(im.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
		  return im;
	  }
	  
	  public RepresentationA extRA(int id){
		  RepresentationA S=null;
		  ResultSet r=res("select * from RepresentationA where idRA="+id);
		  try{
			  if(r.next()){
				  S=new RepresentationA();
				  S.setIdR(r.getInt(1));
				  S.setDate(r.getString(2));
				  S.setMax(r.getInt(3));
				  
				  S.setS(extSA(r.getInt(4)));	  
			  }
		  
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  return S;
		  }
	  public SpectacleC extSC(int id){
		  SpectacleC S=null;
		  ResultSet r=res("select * from SpectacleC where idSC="+id);
		  try{
			  if(r.next()){
				  S=new SpectacleC();
				  S.setIdS(r.getInt(1));
				  S.setNom(r.getString(2));
				  S.setPrixN(r.getFloat(3));
				  S.setPrixR(r.getFloat(4));
				  
			  }
		  
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  return S;
		  }
	  public SpectacleA extSA(int id){
		  SpectacleA S=null;
		  ResultSet r=res("select * from SpectacleA where idSA="+id);
		  try{
			  if(r.next()){
				  S=new SpectacleA();
				  S.setIdS(r.getInt(1));
				  S.setNom(r.getString(2));
				  S.setPrixN(r.getFloat(3));
				  S.setPrixR(r.getFloat(4));
				  S.setCompany(r.getString(5));
				  S.setPrix(r.getFloat(6));
				  
			  }
		  
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  return S;
		  }
	  public RepresentationC extRC(int id){
		  RepresentationC S=null;
		  ResultSet r=res("select * from RepresentationC where idRC="+id);
		  try{
			  if(r.next()){
				  S=new RepresentationC();
				  S.setIdR(r.getInt(1));
				  S.setDate(r.getString(2));
				  S.setMax(r.getInt(4));
				  S.setCoutMS(r.getFloat(3));
				  S.setS(extSC(r.getInt(5)));	  
			  }
		  
		  }catch(SQLException e){
			  e.printStackTrace();
		  }
		  return S;
		  }
	  public int datojours(String date){
		  return (dj(date)+dm(date)*30+da(date)*12*30);
	  }
	  public JMenu men(){
		 
		  JMenu m=new JMenu("Systeme");
		  JMenuItem i1=new JMenuItem("Vider DB");
		  m.add(i1);
		  i1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				videzDB();
			}
		});
		  
		  return m;
	  }
	  public void create(){
		  exe("create table SpectacleA(idSA int not null primary key,nomA varchar(30),prixn float,prixr float,company varchar(30),prixA float)");
		  exe("create table SpectacleC(idSC int not null primary key,nomC varchar(30),prixn float,prixr float)");
		  exe("create table RepresentationA(idRA int  not null primary key,datee date,nbr int,idSA int  not null,foreign key (idSA)references SpectacleA(idSA))");
		  exe("create table RepresentationC(idRC int  not null primary key,datee date,cout float,nbr int,idSC int not null,foreign key (idSC)references SpectacleC(idSC))");
		  exe("create table VenteR(idV int not null primary key,idRC int not null,prixV float,companyV varchar(30),foreign key (idRC)references RepresentationC(idRC))");
		  exe("create table Subvention(idS int not null primary key,idR int not null,somme float,org varchar(30))") ;
		  exe("create table Abonnement(idAb int not null primary key,typee varchar(30),prix float,nom varchar(30),prenom varchar(30),dateAb date,dateExp date)");
		  exe("create table Billet(idB int not null primary key,idR int not null,dateB date,reduc varchar(10),prix float,Reference varchar(30))");

	  }

}

 
