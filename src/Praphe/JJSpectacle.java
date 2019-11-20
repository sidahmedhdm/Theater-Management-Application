package Praphe;
import Projet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;

import Projet.SpectacleA;
import Projet.SpectacleC;
import Projet.Syst;


public class JJSpectacle extends JPanel {

	
	public JJSpectacle(){
		Syst s=new Syst();
		
		setLayout(null);
		setBackground(new Color(255,190,222));
		
		//info
		JPanel info=new JPanel(null);
		
		
		
		TitledBorder binfo=new TitledBorder(BorderFactory.createLineBorder(new Color(255,222,200),5), "Créer ou Acheter un Spéctacle");
		binfo.setTitleFont(s.FO.deriveFont((float)16));
		info.setBorder(binfo);
		add(info);
		info.setBounds(1,1,400,200);
		
		//***nom
		JTextField nom=new JTextField();
		JTextField prn=new JTextField();
		JTextField prr=new JTextField();
		
		nom.setBounds(180, 50, 180, 30);
		prn.setBounds(90, 100, 80, 30);
		prr.setBounds(280, 100, 80, 30);
		
		info.add(nom);info.add(prn);info.add(prr);
		
		JButton Val=s.bot(new JButton("Acheter"), "Ajouter");
		Val.setBounds(70, 150, 110, 30);
		info.add(Val);
		JButton Valc=s.bot(new JButton("Créer"), "Ajouter");
		Valc.setBounds(200, 150, 110, 30);
		info.add(Valc);
		JLabel l1,l2,l3;
		l1=new JLabel("Nom du Spéctacle:");
		info.add(l1);
		l2=new JLabel("Prix Normal:");
		info.add(l2);
		l3=new JLabel("Prix Réduit:");
		info.add(l3);
		
		l1.setBounds(50, 50, 110, 30);
		l2.setBounds(15, 100, 110, 30);
		l3.setBounds(200, 100, 110, 30);
		
        JPanel del=new JPanel(null);
		
		
		
		TitledBorder bdel=new TitledBorder(BorderFactory.createLineBorder(new Color(255,222,200),5), "Supprimer un Spéctacles");
		bdel.setTitleFont(s.FO.deriveFont((float)16));
		del.setBorder(bdel);
		add(del);
		del.setBounds(1,202,400,150);
	    JLabel ld=new JLabel("Vous Devez Dabord Séléctionner un Spéctacle . . .");
		del.add(ld);
		ld.setBounds(50, 50, 310, 30);
		JButton Sup=s.bot(new JButton("Supprimer"), "Supprimer");
		Sup.setBounds(150, 100, 130, 30);
		del.add(Sup);
		
		
		
		JPanel List=new JPanel(null);

		TitledBorder blis=new TitledBorder(BorderFactory.createLoweredSoftBevelBorder(), "Liste des Spéctacles");
		blis.setTitleFont(s.FO.deriveFont((float)16));
		List.setBorder(blis);
		add(List);
		List.setBounds(400,1,450,350);
	    JTextField re=new JTextField();
		List.add(re);
		re.setBounds(100,25, 200, 25);
		JButton rec=s.bot(new JButton("Rechercher"), "Autre");
		rec.setBounds(300, 25, 120, 22);
		List.add(rec);
		JLabel lre=new JLabel("ID ou Nom:");
		List.add(lre);
		lre.setBounds(35,25, 200, 25);
		
		JTabbedPane ListC=new JTabbedPane();
		ListC.setBounds(5,60,440,250);
		List.add(ListC);
		
		
		
		JPanel tab=new JPanel(null);
String[] titreC={"nb_Id","st_Nom","fl_Prix Nomral","fl_Prix Réduit"};
		
		JTable tableauC= s.GetTable("SpectacleC", titreC);
		JScrollPane taaC=new JScrollPane(tableauC,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		taaC.setBounds(5, 60, 440, 250);
		ListC.add("Spéctacle Créer",taaC);
		
String[] titreA={"nb_Id","st_Nom","fl_Prix Nomral","fl_Prix Réduit","st_Company","fl_Prix d'achat"};
		
		JTable tableauA= s.GetTable("SpectacleA", titreA);
		JScrollPane taaA=new JScrollPane(tableauA,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		taaA.setBounds(5, 60, 440, 250);
		ListC.add("Spéctacle Achetés",taaA);

		JLabel lmod=new JLabel("Séléctionner Un spéctacle . . .");
		lmod.setBounds(50, 315, 220, 28);
		List.add(lmod);
		
		
		JButton mod=s.bot(new JButton("Modifier"), "Modifier");
		mod.setBounds(250, 315, 120, 28);
		List.add(mod);
		
		
		//********************************JBUTTON
		 
		mod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int ida=0,idc=0;
				if(tableauA.getSelectedRow()==-1&&tableauC.getSelectedRow()==-1){
					System.out.println("Séléctioner");
				}
				else{
					if(tableauA.getSelectedRow()==-1)
						idc=Integer.parseInt(tableauC.getValueAt(tableauC.getSelectedRow(),0).toString());
					else ida=Integer.parseInt(tableauA.getValueAt(tableauA.getSelectedRow(),0).toString());
				try {
					if(idc!=0)
					{new Fenetre(s.extSC(idc));System.out.println(idc+"idc");}
					else new Fenetre(s.extSA(ida));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				}
		});
		Valc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SpectacleC nvC;
				s.actualiser();
				String par_nom=nom.getText();
				float par_pn=Float.parseFloat(prn.getText());
				float par_pr=Float.parseFloat(prr.getText());
				nvC=new SpectacleC(par_nom, par_pn, par_pr);
				nvC.ajout();
				//***************
				new JMessages("Spectacle créer id = "+nvC.getIdS());
				int i=0;
				while(tableauC.getValueAt(i, 0)!=null)
					i++;
				tableauC.setValueAt(nvC.getIdS(),i,0);
				tableauC.setValueAt(par_nom,i,1);
				tableauC.setValueAt(par_pn,i,2);
				tableauC.setValueAt(par_pr,i,3);
			}
		});
		Val.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				SpectacleA nvA;
				s.actualiser();
				
				String par_nom=nom.getText();
				float par_pn=Float.parseFloat(prn.getText());
				float par_pr=Float.parseFloat(prr.getText());
				//***********************
				JFrame ache=new JFrame();
				ache.setTitle("Acheter un Spéctacle");
				ache.setSize(400, 300);
				JPanel Ach=new JPanel(null);
				JTextField com=new JTextField();
				com.setBounds(200, 50, 150, 45);
				JTextField pa=new JTextField();
				pa.setBounds(200, 120, 150, 45);
				JLabel lcom=new JLabel("Company Origine :");
				JLabel lpa=new JLabel("Prix d'Achat  :");
				lpa.setBounds(20, 120, 150, 45);
				lcom.setBounds(20, 50, 200, 45);
				pa.setFont(s.FO.deriveFont((float)20));
				com.setFont(s.FO.deriveFont((float)20));
				lpa.setFont(s.FO.deriveFont((float)17));
				lcom.setFont(s.FO.deriveFont((float)17));
				ache.add(lpa);ache.add(lcom);
				JButton vala=s.bot(new JButton("Acheter"), "Ajouter");
				vala.setBounds(120,200,120,30);
				vala.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String par_comf="";float par_paf=0;
						par_comf=com.getText();
						par_paf=Float.parseFloat(pa.getText());
						s.actualiser();
						SpectacleA AA=new SpectacleA(par_nom, par_pn, par_pr, par_comf, par_paf);
						AA.ajout();
						new JMessages("Spéctacle Acheté Id = "+AA.getIdS());
						ache.setVisible(false);
						int i=0;
						while(tableauA.getValueAt(i,0)!=null)
							i++;
						tableauA.setValueAt(AA.getIdS(), i, 0);
						tableauA.setValueAt(par_nom, i, 1);
						tableauA.setValueAt(par_pn, i, 2);
						tableauA.setValueAt(par_pr, i, 3);
						tableauA.setValueAt(par_comf, i, 4);
						tableauA.setValueAt(par_paf, i, 5);
						}
				});
				Ach.add(pa);Ach.add(com);Ach.add(vala);				
				ache.getContentPane().add(Ach);
				ache.setVisible(true);
				//*********
			
				
				}
		});
		
	
		Sup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame att=new JFrame();
				att.setTitle("Attender");
				att.setVisible(true);
				att.setSize(400, 10);
				att.getContentPane().add(new JLabel("Veuillez Patientez"));
				att.setLocationRelativeTo(null);
				JTable tab;
				SpectacleC C=null;SpectacleA A=null;
				int ia=0,ic=0;
				boolean b=true;
				if(ListC.getSelectedIndex()==0){
					if(tableauC.getSelectedRow()==-1)
						{new JMessages("séléctionner Spectacle créer");b=false;}
					else ic=Integer.parseInt(tableauC.getValueAt(tableauC.getSelectedRow(), 0).toString());
				}else{
					if(tableauA.getSelectedRow()==-1)
						{new JMessages("séléctionner Spectacle acheté");b=false;}
					else ia=Integer.parseInt(tableauA.getValueAt(tableauA.getSelectedRow(), 0).toString());
				}
				
					if(b){
				if(ia==0) { C=s.extSC(ic); C.sup();}
				else { A=s.extSA(ia); A.sup();}
				if(C==null) tab=tableauA;
				else tab=tableauC;
				for(int u=0;u<tab.getColumnCount();u++){
					tab.setValueAt("", tab.getSelectedRow(), u);
				}}
				
			att.setVisible(false);
					
			}
			
		});
	}
}
