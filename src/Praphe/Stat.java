package Praphe;
import Projet.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import Projet.RepresentationA;
import Projet.RepresentationC;
import Projet.Syst;

public class Stat extends Syst{

	private static int id=505;
	

	public boolean Subvention(RepresentationC A ,String org,double somme){
		
		ResultSet r=Rech("idR",""+A.getIdR(), "Subvention");
		try{
			while(r.next()){
				if(r.getString(4).equals(org)) return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		ajout((id++)+","+A.getIdR()+","+somme+",'"+org+"'", "Subvention");
		return true;
		
	}
	public boolean Subvention(RepresentationA A ,String org,double somme){
		
		ResultSet r=Rech("idR",""+A.getIdR(), "Subvention");
		try{
			while(r.next()){
				if(r.getString(4).equals(org)) return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		ajout((id++)+","+A.getIdR()+","+somme+",'"+org+"'", "Subvention");
		return true;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
}
