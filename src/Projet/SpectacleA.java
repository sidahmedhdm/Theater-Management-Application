package Projet;
import java.sql.*;
import Praphe.*;
public class SpectacleA extends Spectacle {

	
	
	private String company;
	private float prix;
	
	
		public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


		public SpectacleA (){	}
	
	
	public SpectacleA (String nom,float pn,float pr,String company,float prix){
		super(nom,pn,pr);
		this.company=company;this.prix=prix;
	}

	public void ajout(){
		ajout(idS+",'"+nom+"',"+prixN+","+prixR+",'"+company+"',"+prix, "SpectacleA");
	}
	public void sup(){
		int tab[] = new int[1000];int i=0;
		ResultSet r=res("select idrc from RepresentationC where idsc="+getIdS());
		try{
			while(r.next())
			{
				tab[i++]=r.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		for(int j=0;j<tab.length;j++){

			exe("delete from  billet where idr="+tab[j]);
			exe("delete from  subvention where idr="+tab[j]);
			//exe("delete from  venter where idrc="+tab[j]);
			exe("delete from  representationa where idra="+tab[j]);	
		}
		exe("delete from spectaclea where idsa="+idS);
		
		}

}
