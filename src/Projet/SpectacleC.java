package Projet;
import Praphe.*;

import java.awt.List;
import java.sql.*;

public class SpectacleC extends Spectacle {
	

	public SpectacleC (){	}
	
	
	public SpectacleC (String nom,float pn,float pr){
		super(nom,pn,pr);

		
	}
	public void ajout(){
		ajout(idS+",'"+nom+"'"+","+prixN+","+prixR, "SpectacleC");	}
	public void sup(){
		int tab[] = new int[1000];int i=0;
		ResultSet r=res("select idra from RepresentationA where idsa="+getIdS());
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
			exe("delete from  venter where idrc="+tab[j]);
			exe("delete from  representationc where idrc="+tab[j]);	
		}
		exe("delete from spectaclec where idsc="+idS);
		
		}
}
