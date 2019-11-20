package Praphe;
import Projet.*;
import java.sql.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import Projet.Spectacle;
public class JSpectacle extends JFrame  {

	Container pane=this.getContentPane();


	
	public JSpectacle(){

		Spectacle s=new Spectacle();
		
		String tbl[]={"nb_IDS","st_NOM","fl_Prix Normal","fl_Prix Réduit"};
		JTable tableau = s.GetTable("SpectacleC",tbl );
		JScrollPane scrol=new JScrollPane(tableau);
		JPanel p=new JPanel();
		p.add(scrol);
		
		pane.setBackground(Color.white);
		this.setTitle("Gestion des Cliens");
		this.setSize(1100, 500);
		pane.setLayout(new GridLayout(1, 2));
		
		
		 //Les données du tableau
		JMenuBar mb=new JMenuBar();
		JMenu m=new JMenu("Systeme");
		JMenuItem mi=new JMenuItem("Videz La Base De Donnée");
		mi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				s.videzDB();
				setVisible(false);new JSpectacle();
			}
		});
		m.add(mi);mb.add(m);
		mb.add(m);mb.add(m);
		this.setJMenuBar(mb);

	    //database
	
	  
	
	JPanel p2=new JPanel();
	pane.add(p2);
	
	
	JPanel p21=new JPanel(new FlowLayout(0,80,20)); 
	JPanel p22=new JPanel();
	
	p2.add(p21);p2.add(p22);
	
	JTextField nom=new JTextField( );
	JTextField prenom=new JTextField( );
	JTextField tel=new JTextField();
   nom.setPreferredSize( new Dimension( 150, 24 ) );
    prenom.setPreferredSize( new Dimension( 150, 24 ) );
    tel.setPreferredSize( new Dimension( 150, 24 ) );
  
    p21.add(new JLabel("Nom :      ") );p21.add(nom);
	p21.add(new JLabel("Prénom :") );p21.add(prenom);
	p21.add(new JLabel("Num Tél :") ); p21.add(tel);

	JPanel p211=new JPanel(new FlowLayout(0,30,10));
	JButton ok=new JButton("Ajoutez");
	p211.add(ok);
	JButton mod=new JButton("Modifier");
	p211.add(mod);
	JButton sup=new JButton("Supprimer");
	p211.add(sup);
	p21.add(p211);
	p21.setBorder(BorderFactory.createTitledBorder("Client"));
	p211.setBorder(BorderFactory.createTitledBorder("Action"));
	sup.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int i= tableau.getSelectedRow();
			int idc=Integer.parseInt(tableau.getModel().getValueAt(i, 0).toString());
			
		/*	s.exe("delete from Visite where idc="+idc);
			s.exe("delete from Vente where idc="+idc);
			s.exe("delete from RDV where idc="+idc);
			s.exe("delete from ANIMAL where idc="+idc);
			s.sup(idc, "Client");*/
			//new Jf("Client qui a ID= "+idc+" a été supprimé");

			tableau.removeRowSelectionInterval(1,3);
			
			tableau.getModel().setValueAt("0", i, 0);
			tableau.getModel().setValueAt("", i, 1);
			tableau.getModel().setValueAt("", i, 2);
			//tableau.getModel().setValueAt("", i, 3);
		}
	});
		mod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i= tableau.getSelectedRow();
				int idc=Integer.parseInt(tableau.getModel().getValueAt(i, 0).toString());
				String nm=nom.getText(),prn=prenom.getText(),tl=tel.getText();
				s.exe("update Client set nomc='"+nm+"' where idC="+idc);
				s.exe("update Client set prenomc='"+prn+"' where idC="+idc);
				s.exe("update Client set num_tlfn='"+tl+"' where idC="+idc);
				tableau.setValueAt(nm, i, 1);
				tableau.setValueAt(prn, i, 2);
				tableau.setValueAt(tl, i, 3);
				System.out.println("Client Modifié");
				
			}
		});	

	
	
	tableau.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e){
			int i = tableau.getSelectedRow();
			nom.setText(tableau.getModel().getValueAt(i, 1).toString());
			prenom.setText(tableau.getModel().getValueAt(i, 2).toString());
			tel.setText(tableau.getModel().getValueAt(i, 3).toString());
					
		}
	});
		ok.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String nm=nom.getText(),prn=prenom.getText(),tl=tel.getText();
			Spectacle cl;
			//cl.actualiser();
			//cl.ajout();
			/*tableau.setValueAt(cl.getIdc(), cl.getIdc()-149, 0);
			tableau.setValueAt(nm, cl.getIdc()-149, 1);
			tableau.setValueAt(prn, cl.getIdc()-149, 2);
			tableau.setValueAt(tl,cl.getIdc()-149, 3);
			*/

			//new Jf("Client ajouté avec succé sous ID:"+cl.getIdc());
			
			
		}
	});
	
	JButton ba=new JButton("Ajouter un ANIMAL");
	ba.setPreferredSize(new Dimension(150,29));
	ba.setBackground(Color.getHSBColor(25, 25, 50));
	p21.add(new JLabel("   "));
	p21.add(ba);
	ba.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int i = tableau.getSelectedRow();
			int id=Integer.parseInt(tableau.getModel().getValueAt(i, 0).toString());
			//Client c=s.extC(id);
		//	new JAnimal(c);
			setVisible(false);
		}
	});
	
	
	ok.setBackground(Color.LIGHT_GRAY);
	mod.setBackground(Color.GRAY);
	sup.setBackground(new Color(253,98,113));
	
	JButton br=new JButton("Rechercher");
	
	
	JTextField tr=new JTextField();
	br.setBackground(Color.CYAN);
	tr.setPreferredSize(new Dimension(150, 24));
	p22.setLayout(new FlowLayout());
	p22.add(new JLabel("ID:"));
	p22.add(tr);
	p22.add(br);
	
	br.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int idc=Integer.parseInt(tr.getText());
			int y=0;
			while(Integer.parseInt(tableau.getValueAt(y, 0).toString())!=idc)
				y++;
			tableau.setRowSelectionInterval(y,y);
			//new Jf("Client a été séléctioné");
		}
	});
	
p22.setPreferredSize(new Dimension(450, 50));
p21.setPreferredSize(new Dimension(500,300));
	//p2.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
	//p21.setBorder(BorderFactory.createLineBorder(Color.red,3));
	//p22.setBorder(BorderFactory.createLineBorder(Color.green,3));
	

	pane.add(p);
			
			
			p.setBackground(new Color(255,245,255));
			setVisible(true);
		
   
	}}

	     
	

