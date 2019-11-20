package Praphe;
import Projet.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.*;

import Projet.Syst;

import javax.swing.*;

public class JDeponse extends JPanel {
	public JDeponse(){
		this.setLayout(null);
		Syst s=new Syst();
		JLabel spec=new JLabel("Déponse de Tous les Spéctacles:");
		spec.setFont(new Font("Times New Roman", Font.BOLD, 15));
		add(spec);
		spec.setBounds(10,27,250,30);
		

		//DATABASE acha
		ResultSet a_r=s.res("select prixa from spectaclea");
		float a_total=0,a_moy=0;
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
		if(a_nbr!=0) a_moy=a_total/a_nbr;
		
		//Achat *****************************************
		String[] titrev={"Déponse des achats"," "};
		Object[][] datav=new Object[3][2];
		datav[0][0]="Nombre Spectacles Achetés:";
		datav[1][0]="Prix Moyenne d'achat:";
		datav[2][0]="Déponse Total des Achats:";
		datav[0][1]=""+a_nbr;
		datav[1][1]=""+a_moy+" da";
		datav[2][1]=""+a_total+" da";
		
		TableColumn ju;
		
		
		
		
		JTable vent=new JTable(datav,titrev);
		ju= vent.getColumnModel().getColumn(0);
		ju.setPreferredWidth(140);
		vent.setBackground(Color.cyan);
		
		
		
		JScrollPane scr=new JScrollPane(vent);
		scr.setBounds(40, 60, 300, 100);
		add(scr);
		//DATABASE ms
				ResultSet m_r=s.res("select cout from representationc");
				float m_total=0,m_moy=0;
				int m_nbr=0;
				try{
					while(m_r.next())
					{
						m_nbr++;
						m_total+=m_r.getFloat(1);
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
				if(m_nbr!=0) m_moy=m_total/m_nbr;
				
		//Mise en scene**********************************************
		String[] titres={"Cout de Mise en scène"," "};
		Object[][] datas=new Object[3][2];
		datas[0][0]="Nombre de Spectacles  Mise en scène:";
		datas[1][0]="Prix Moyenne de Mise en scène:";
		datas[2][0]="Déponse Total de Mise en scène:";
		datas[0][1]=""+m_nbr;
		datas[1][1]=""+m_moy+" da";
		datas[2][1]=""+m_total+" da";
		
		TableColumn jus;
		
		
		
		
		JTable subv=new JTable(datas,titres);
		jus= subv.getColumnModel().getColumn(0);
		jus.setPreferredWidth(210);
		subv.setBackground(Color.cyan);
		
		
		
		JScrollPane scrs=new JScrollPane(subv);
		add(scrs);
		scrs.setBounds(430, 60, 350, 100);
		
		
		/*Billeterie *****************************************
				String[] titreb={"Recette de Billeterie"," "};
				Object[][] datab=new Object[3][2];
				datab[0][0]="Nombre Billet Vendu:";
				datab[1][0]="Prix Moyenne de Vente:";
				datab[2][0]="Recette Total de Vente:";
				datab[0][1]="00";
				datab[1][1]="00.00";
				datab[2][1]="00.00";
				
				TableColumn jub;
				
				
				
				
				JTable bill=new JTable(datab,titreb);
				jub= bill.getColumnModel().getColumn(0);
				jub.setPreferredWidth(140);
				bill.setBackground(Color.cyan);
				
				
				
				JScrollPane scrb=new JScrollPane(bill);
				scrb.setBounds(590,60, 250, 100);
				add(scrb);
		
		ColumnGroup k;
		
		/*
		datav[0][0]="Nombre Subvention";
		datav[1][0]="Nombre Spectacles ont Sub";
		datav[2][0]="Moyenne Subv Pour Specta";
		datav[3][0]="Recette Subvention";
		*/
		//donne
		JLabel spect=new JLabel("Déponses de Spéctacle donnée:");
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
		setBackground(new Color(255,222,200));
	}
}
