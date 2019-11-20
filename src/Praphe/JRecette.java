package Praphe;
import Projet.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.*;

import Projet.Syst;

import javax.swing.*;

public class JRecette extends JPanel {
	public JRecette(){
		this.setLayout(null);
		Syst s=new Syst();
		JLabel spec=new JLabel("Recette de Tous les Spéctacles:");
		spec.setFont(new Font("Times New Roman", Font.BOLD, 15));
		add(spec);
		spec.setBounds(10,27,250,30);
		
		
		
		//DATABASE Vente
		ResultSet v_r=s.res("select prixv from venter");
		float v_total=0,v_moy=0;
		int v_nbr=0;
		try{
			while(v_r.next())
			{
				v_nbr++;
				v_total+=v_r.getFloat(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(v_nbr!=0) v_moy=v_total/v_nbr;
		
		//Vente *****************************************
		String[] titrev={"Recette de vente"," "};
		Object[][] datav=new Object[3][2];
		datav[0][0]="Nombre Spectacles Vendu:";
		datav[1][0]="Prix Moyenne de Vente:";
		datav[2][0]="Recette Total de Vente:";
		datav[0][1]=""+v_nbr;
		datav[1][1]=""+v_moy+" da";
		datav[2][1]=""+v_total+" da";
		
		TableColumn ju;
		
		
		
		
		JTable vent=new JTable(datav,titrev);
		ju= vent.getColumnModel().getColumn(0);
		ju.setPreferredWidth(140);
		vent.setBackground(Color.cyan);
		
		
		
		JScrollPane scr=new JScrollPane(vent);
		scr.setBounds(10, 60, 250, 100);
		add(scr);
		
		//DATABASE Subvention
		ResultSet s_r=s.res("select somme from subvention");
		float s_total=0,s_moy=0;
		int s_nbr=0;
		try{
			while(s_r.next())
			{
				s_nbr++;
				s_total+=s_r.getFloat(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(s_nbr!=0) s_moy=s_total/s_nbr;
		
		//Subvention**********************************************
		String[] titres={"Recette de Subvention"," "};
		Object[][] datas=new Object[3][2];
		datas[0][0]="Nombre total des subvention:";
		datas[1][0]="Prix moyenne de subvention:";
		datas[2][0]="Recette Total de Subvention:";
		datas[0][1]=""+s_nbr;
		datas[1][1]=""+s_moy+" da";
		datas[2][1]=""+s_total+" da";
		
		TableColumn jus;
		
		
		
		
		JTable subv=new JTable(datas,titres);
		jus= subv.getColumnModel().getColumn(0);
		jus.setPreferredWidth(140);
		subv.setBackground(Color.cyan);
		
		
		
		JScrollPane scrs=new JScrollPane(subv);
		add(scrs);
		scrs.setBounds(280, 60, 280, 100);
		
		//DATABASE Billet
		ResultSet b_r=s.res("select prix from billet");
		float b_total=0,b_moy=0;
		int b_nbr=0;
		try{
			while(b_r.next())
			{
				b_nbr++;
				b_total+=b_r.getFloat(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(b_nbr!=0) b_moy=b_total/b_nbr;
		//DATABASE Billet
		ResultSet a_r=s.res("select prix from abonnement");
		float a_total=0;
		int a_nbr=0;
		try{
			while(a_r.next())
			{
				a_nbr++;
				a_total+=a_r.getFloat(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
				
		//Billeterie *****************************************
				String[] titreb={"Recette de Billeterie"," "};
				Object[][] datab=new Object[6][2];
				datab[0][0]="Nombre Billet Vendu:";
				datab[1][0]="Prix Moyenne de Billet:";
				datab[2][0]="Recette Total des Billets:";
				datab[3][0]="Nombre Abonnemet :";
				datab[4][0]="Recette Total des Abonnements :";
				datab[5][0]="Recette Total :";
				
				datab[0][1]=""+b_nbr;
				datab[1][1]=""+b_moy+" da";
				datab[2][1]=""+b_total+" da";
				datab[3][1]=""+a_nbr;
				datab[4][1]=""+a_total+" da";
				datab[5][1]=""+(a_total+b_total)+" da";
				
				TableColumn jub;
				
				
				
				
				JTable bill=new JTable(datab,titreb);
				jub= bill.getColumnModel().getColumn(0);
				jub.setPreferredWidth(230);
				bill.setBackground(Color.cyan);
				
								
				JScrollPane scrb=new JScrollPane(bill);
				scrb.setBounds(570,60, 280, 118);
				add(scrb);
		
	//	ColumnGroup k;
		
		/*
		datav[0][0]="Nombre Subvention";
		datav[1][0]="Nombre Spectacles ont Sub";
		datav[2][0]="Moyenne Subv Pour Specta";
		datav[3][0]="Recette Subvention";
		*/
		//donne
		JLabel spect=new JLabel("Recette de Spéctacle donnée:");
		spect.setFont(new Font("Times New Roman", Font.BOLD, 15));
		add(spect);
		spect.setBounds(10,220,250,30);
		//don
		JTextField don=new JTextField();
		don.setFont(new Font("Times New Roman", Font.BOLD, 15));
		add(don);
		don.setBounds(200,270,250,30);
		
		//jlab
		JLabel nom=new JLabel("Nom ou ID du Spéctacle:");
		nom.setFont(new Font("Times New Roman", Font.BOLD, 15));
		add(nom);
		nom.setBounds(30,270,250,30);

		//jbo
		JButton rech=s.bot(new JButton("Rechercher"), "Autre");
		//rech.setFont(new Font("Times New Roman", Font.BOLD, 15));
		add(rech);
		rech.setBounds(350,320,150,30);
		
		
		
		
		
		
		
		setPreferredSize(new Dimension(200,200));
		setBackground(new Color(200,255,200));
		System.out.println(getWidth()+":"+getHeight());
	}
}
