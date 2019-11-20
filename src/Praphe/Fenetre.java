package Praphe;
import Projet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import Projet.RepresentationA;
import Projet.RepresentationC;
import Projet.Spectacle;
import Projet.SpectacleA;
import Projet.SpectacleC;

public class Fenetre extends JFrame{
	
	private Container pane=getContentPane();
	
	public Fenetre(Spectacle S) throws IOException{
		
		JPanel principal=new JPanel(null);
		JPanel top=new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
		principal.add(top);
		top.setBackground(new Color(255,150,150));
		JLabel img=new JLabel(new ImageIcon("img/spec.png"));
		
		img.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		top.add(img);
		top.setBounds(1, 1, 980,130);
		
		
		
		JLabel t1=new JLabel(S.getNom());
		JLabel background=S.img("src/img/spec.png");
		
		JLabel Nom,PrixN,PrixR;
		Nom=new JLabel("Nom de Spéctacle");
		JLabel l1=new JLabel(S.getNom());
		PrixN=new JLabel("Prix de Référence Normal");
		JLabel l2=new JLabel(""+S.getPrixN());
		PrixR=new JLabel("Prix de Référence Réduit");
		JLabel l3=new JLabel(S.getPrixR()+"");
		Nom.setFont(S.FO.deriveFont((float)17));
		PrixN.setFont(S.FO.deriveFont((float)17));
		PrixR.setFont(S.FO.deriveFont((float)17));
		t1.setFont(S.FO);
		t1.setForeground(new Color(200, 50, 20));
		top.add(t1);
		top.add(background);

		PrixN.setBounds(10,90,300,40);
		PrixR.setBounds(10,130,300,40);
		Nom.setBounds(10,50,300,40);
		
		
		JPanel in=new JPanel(null);//******************************* in
		


		l1.setForeground(Color.BLUE);
		l1.setBounds(250,50, 150, 40);
		l1.setFont(S.FO.deriveFont((float)17));
		in.add(l1);
		

		l2.setForeground(Color.BLUE);
		l2.setBounds(250,90, 150, 40);
		l2.setFont(S.FO.deriveFont((float)17));
		in.add(l2);
		

		l3.setForeground(Color.BLUE);
		l3.setBounds(250,130, 150, 40);
		l3.setFont(S.FO.deriveFont((float)17));
		in.add(l3);
		
		
		
		JPanel info = new JPanel(null);
		info.add(in);
		info.setBackground(new Color(210, 140, 140));
		info.setBounds(1, 130, 980, 530);
		principal.add(info);		
		
		in.add(Nom);
		in.add(PrixN);
		in.add(PrixR);
		int n = 160;
		String ch="C";
		if(S.getClass().toString().equals("class SpectacleA")) {
			ch="A";
			JLabel ach=new JLabel("(Spéctacle Acheté)");
			ach.setFont(S.FO.deriveFont((float)16));
			ach.setForeground(Color.BLUE);
			ach.setBounds(100, 25, 200, 20);
			in.add(ach);
			
			n=220;
			JLabel Comp=new JLabel("Company Origine");
			JLabel l4=new JLabel(S.getCompany());
			
			JLabel Prix=new JLabel("Prix D'Achat ");
			JLabel l5=new JLabel(""+S.getPrix());
			l5.setBounds(250, 210, 150, 40);
			l4.setBounds(250,170, 150, 40);
			l4.setFont(S.FO.deriveFont((float)17));
			l5.setFont(S.FO.deriveFont((float)17));
			l4.setForeground(Color.blue);
			l5.setForeground(Color.blue);
			in.add(l4);
			in.add(l5);
			in.setBackground(Color.white);
		
			
			Comp.setBounds(10,170,300,40);
			Prix.setBounds(10,210,300,40);
			Comp.setFont(S.FO.deriveFont((float)17));
			Prix.setFont(S.FO.deriveFont((float)17));
			in.add(Comp);
			in.add(Prix);
		}
		JLabel ln;
		for(int i=50;i<n;i+=40)
			{
			ln=new JLabel(":");
		ln.setBounds(230,i, 100, 40);
		ln.setFont(S.FO.deriveFont((float)17));
		in.add(ln);
			}
		
		TitledBorder bin=new TitledBorder(BorderFactory.createLineBorder(Color.BLUE, 3), "Information");
		in.setBorder(bin);
		bin.setTitleFont(S.FO.deriveFont((float)15));
		
		//tab
		JPanel rep=new JPanel();
		JTable tab;
		
		if(ch=="A"){
		String[] titre={"nb_ID","st_Date","nb_Nombre Places"};	
		tab=S.GetTable("RepresentationA where idSA="+S.getIdS(),titre);
		
		}else {

			String[] titre={"nb_ID","st_Date","fl_Cous de MS","nb_Nombre Places"};	
			tab=S.GetTable("RepresentationC where idSC="+S.getIdS(),titre);
		}
		JScrollPane scr=new JScrollPane(tab);
		
		JPanel list_rep=new JPanel(null);

		list_rep.setBounds(400, 05, 380, 142);
		list_rep.add(scr);
		scr.setBounds(6,20, 365,117);
		in.setBounds(400, 150, 380, 280);
		info.add(list_rep);
		TitledBorder b_lis=new TitledBorder(BorderFactory.createLineBorder(Color.blue,3),"Liste Représentation");
		list_rep.setBorder(b_lis);
		
		JTextField i_dat=new JTextField();
		JTextField i_sal=new JTextField();
		JTextField i_cout=new JTextField();
		JButton b_aj=S.bot(new JButton("Ajouter"),"Ajouter");
		
		JPanel i_=new JPanel(null);
		JLabel l_dat=new JLabel("Date :");
		JLabel l_sal=new JLabel("Nombre de places :");
		JLabel l_cou=new JLabel("Cout de MS :");
		JLabel form=new JLabel("Remplire les Champs");
		
		if(S.getClass().toString().equals("class SpectacleA")) {l_cou.setVisible(false);
		i_cout.setVisible(false);}
		
		
		//bounds
		i_.setBounds(5, 5, 392, 270);
		i_dat.setBounds(170, 70, 150, 30);
		i_sal.setBounds(170, 120, 150, 30);
		i_cout.setBounds(170, 170, 150, 30);
		l_dat.setBounds(20, 70, 150, 30);
		l_sal.setBounds(20, 120, 150, 30);
		l_cou.setBounds(20, 170, 150, 30);
		form.setBounds(100, 30, 200, 30);
		b_aj.setBounds(130, 220, 150, 30);
		
		//text
		i_dat.setFont(S.FO.deriveFont((float)15));
		i_sal.setFont(S.FO.deriveFont((float)15));
		i_cout.setFont(S.FO.deriveFont((float)15));
		l_dat.setFont(S.FO.deriveFont((float)15));
		l_sal.setFont(S.FO.deriveFont((float)15));
		l_cou.setFont(S.FO.deriveFont((float)15));
		form.setFont(S.FO.deriveFont((float)17));
		form.setForeground(Color.BLUE);
	
		
		TitledBorder b_i=new TitledBorder(BorderFactory.createLineBorder(Color.blue, 3),"Ajouter Représentation");
		i_.setBorder(b_i);
		b_i.setTitleFont(S.FO.deriveFont((float)15));
		b_lis.setTitleFont(S.FO.deriveFont((float)13));
		
		
		
		
		info.add(i_);
		i_.add(i_cout);i_.add(i_dat);i_.add(i_sal);

		i_.add(l_cou);i_.add(l_dat);i_.add(l_sal);
		i_.add(form);
		i_.add(b_aj);
		
		
		
		b_aj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int s=Integer.parseInt(i_sal.getText());
				float c=Float.parseFloat(i_cout.getText());
				String d=i_dat.getText();
				if(S.getClass().toString().equals("class SpectacleA")) {
					S.actualiser();
					RepresentationA ra =new RepresentationA(d, (SpectacleA)S, s);
					ra.ajout();
					int i=0;
					for(i=0;i<tab.getRowCount();i++){
						if(tab.getValueAt(i,0)==null){
							break;
						}
					}
					tab.setValueAt(ra.getIdR(), i, 0);
					tab.setValueAt(d, i, 1);
					tab.setValueAt(s, i, 2);
				}
				else{
					S.actualiser();
					RepresentationC rc =new RepresentationC(c,d, (SpectacleC)S, s);
					rc.ajout();
					int i=0;
					for(i=0;i<tab.getRowCount();i++){
						if(tab.getValueAt(i,0)==null){
							break;
						}
					}
					tab.setValueAt(rc.getIdR(), i, 0);
					tab.setValueAt(d, i, 1);
					tab.setValueAt(c, i, 2);
					tab.setValueAt(s, i, 3);
					
					
				}
				
			}
		});
		
		JButton b_su=S.bot(new JButton("Supprimer"), "Supprimer");
		JButton b_mod=S.bot(new JButton("Modifier"), "Modifier");
		
		b_su.setBounds(50,320, 140, 40);
		b_mod.setBounds(220,320, 140, 40);

		info.add(b_mod);		info.add(b_su);
		b_mod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int int_=2;
				boolean t_C=false;
				if(S.getClass().toString().equals("class SpectacleC")){
					t_C =true;
					int_=3;
				}
				//*******************************
				
				
				JFrame f_mo=new JFrame();
				JPanel p_mod=new JPanel(null);

				JTextField m_dat=new JTextField(""+tab.getValueAt(tab.getSelectedRow(), 1));
				JTextField m_sal=new JTextField(""+tab.getValueAt(tab.getSelectedRow(), int_));
				JTextField m_cout=new JTextField(""+tab.getValueAt(tab.getSelectedRow(), 2));
				JButton m_aj=S.bot(new JButton("Modifier"),"Modifier");
				
				JPanel i_m=new JPanel(null);
				JLabel lm_dat=new JLabel("Date :");
				JLabel lm_sal=new JLabel("Nombre de places :");
				JLabel lm_cou=new JLabel("Cout de MS :");
				JLabel m_form=new JLabel("Modifier les Champs");
				
				//bounds
				i_m.setBounds(10, 5, 392, 270);
				m_dat.setBounds(170, 70, 150, 30);
				m_sal.setBounds(170, 120, 150, 30);
				m_cout.setBounds(170, 170, 150, 30);
				lm_dat.setBounds(20, 70, 150, 30);
				lm_sal.setBounds(20, 120, 150, 30);
				lm_cou.setBounds(20, 170, 150, 30);
				m_form.setBounds(100, 30, 200, 30);
				m_aj.setBounds(130, 220, 150, 30);
				
				//text
				m_dat.setFont(S.FO.deriveFont((float)15));
				m_sal.setFont(S.FO.deriveFont((float)15));
				m_cout.setFont(S.FO.deriveFont((float)15));
				lm_dat.setFont(S.FO.deriveFont((float)15));
				lm_sal.setFont(S.FO.deriveFont((float)15));
				lm_cou.setFont(S.FO.deriveFont((float)15));
				m_form.setFont(S.FO.deriveFont((float)17));
				m_form.setForeground(Color.BLUE);
			
				
				TitledBorder b_im=new TitledBorder(BorderFactory.createLineBorder(Color.blue, 3),"Modifier Représentation");
				i_m.setBorder(b_im);
				b_im.setTitleFont(S.FO.deriveFont((float)15));
				
				boolean t_A=!t_C;
				
				m_aj.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(t_A){
							int idra=0;
							idra=Integer.parseInt(tab.getValueAt(tab.getSelectedRow(), 0).toString());
							int sm=Integer.parseInt(m_sal.getText());
							//float cm=Float.parseFloat(m_cout.getText());
							String dm=m_dat.getText();
							
							S.exe("update RepresentationA set datee='"+dm+"' where idra="+idra);
							S.exe("update RepresentationA set nbr="+sm+" where idra="+idra);
							tab.setValueAt(dm, tab.getSelectedRow(), 1);
							tab.setValueAt(sm, tab.getSelectedRow(), 2);
							
							
						}else{
							int idrc=0;
							idrc=Integer.parseInt(tab.getValueAt(tab.getSelectedRow(), 0).toString());
							int sm=Integer.parseInt(m_sal.getText());
							float cm=Float.parseFloat(m_cout.getText());
							String dm=m_dat.getText();
							
							S.exe("update RepresentationC set datee='"+dm+"' where idrc="+idrc);
							S.exe("update RepresentationC set nbr="+sm+" where idrc="+idrc);
							S.exe("update RepresentationC set cout="+cm+" where idrc="+idrc);
							
							tab.setValueAt(dm, tab.getSelectedRow(), 1);
							tab.setValueAt(cm, tab.getSelectedRow(), 2);
							tab.setValueAt(sm, tab.getSelectedRow(), 3);
							
						}
					}
				});
				
			
				
				
				i_m.add(m_cout);i_m.add(m_dat);i_m.add(m_sal);
				i_m.add(lm_cou);i_m.add(lm_dat);i_m.add(lm_sal);
				i_m.add(m_form);
				i_m.add(m_aj);
			    p_mod.add(i_m);
				
				
				f_mo.getContentPane().add(p_mod);
				f_mo.setTitle("Modifier Représentation");
				f_mo.setSize(430, 330);
				f_mo.setVisible(true);
				//**********************************
			}
		});
		
		
		b_su.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int idr=Integer.parseInt(tab.getValueAt(tab.getSelectedRow(), 0).toString());
				System.out.println("id="+idr);

				S.exe("delete from Billet where idr="+idr);
				if(S.getClass().toString().equals("class SpectacleA")){
					 
					S.exe("delete from RepresentationA where idra="+idr);
					tab.setValueAt("", tab.getSelectedRow(), 0);
					tab.setValueAt("", tab.getSelectedRow(), 1);
					tab.setValueAt("", tab.getSelectedRow(), 2);
					
				}else{
					S.exe("delete from RepresentationC where idra="+idr);
					tab.setValueAt("", tab.getSelectedRow(), 0);
					tab.setValueAt("", tab.getSelectedRow(), 1);
					tab.setValueAt("", tab.getSelectedRow(), 2);
					tab.setValueAt("", tab.getSelectedRow(), 3);
					
					
				}
				
				
				
			}
		});
		
		
		
		JButton vendre = S.bot(new JButton("Vendre Représentation"), "Autre");
		JButton subvention = S.bot(new JButton("Ajouter Subvention"), "Autre");
		
		vendre.setBounds(1, 390, 200, 30);
		subvention.setBounds(199, 390, 200, 30);
		
		subvention.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		info.add(vendre);info.add(subvention);

		//sub
		
subvention.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//*******************************
				
				
				JFrame f_mo=new JFrame();
				JPanel p_mod=new JPanel(null);

				
				JTextField Somme=new JTextField();
				JTextField Comp=new JTextField();
				JButton m_aj=S.bot(new JButton("Valider"),"Ajouter");
				
				JLabel l_Somme=new JLabel("Somme :");
				JLabel l_Comp=new JLabel("Organisation :");
				
				
				//bounds
				Somme.setBounds(170, 60, 150, 30);
				Comp.setBounds(170, 110, 150, 30);
				l_Somme.setBounds(20, 60, 150, 30);
				l_Comp.setBounds(20, 110, 150, 30);
				m_aj.setBounds(130, 170, 150, 30);
				
				//text
				Somme.setFont(S.FO.deriveFont((float)17));
				Comp.setFont(S.FO.deriveFont((float)17));
				l_Somme.setFont(S.FO.deriveFont((float)17));
				l_Comp.setFont(S.FO.deriveFont((float)17));
				
				
				TitledBorder b_im=new TitledBorder(BorderFactory.createLineBorder(Color.blue, 3),"Ajouter Subvention");
				p_mod.setBorder(b_im);
				b_im.setTitleFont(S.FO.deriveFont((float)15));
				
				
				
				m_aj.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
							int idra=0;
							idra=Integer.parseInt(tab.getValueAt(tab.getSelectedRow(), 0).toString());
							//float cm=Float.parseFloat(m_cout.getText());
							S.actualiser();
							Stat sub=new Stat();
							if(S.getClass().toString().equals("class SpectacleA")){
								RepresentationA A=S.extRA(idra);
							sub.Subvention(A, Comp.getText(), Float.parseFloat(Somme.getText()));
						}else{
							RepresentationC C=S.extRC(idra);
							sub.Subvention(C,Comp.getText(), Float.parseFloat(Somme.getText()));
						}
						f_mo.setVisible(false);
						new JMessages("Subvention Ajouté");
						
						
							
						
					}
				});
				
			//add

				p_mod.add(Comp);
				p_mod.add(m_aj);
				p_mod.add(l_Comp);
				p_mod.add(Somme);
				p_mod.add(l_Somme);
				
				
				
				
				
				f_mo.getContentPane().add(p_mod);
				f_mo.setTitle("Ajouter Subvention");
				f_mo.setSize(430, 250);
				f_mo.setVisible(true);
				//**********************************
			}
		});
		

		
		//
		
		
		//copier
		
vendre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				//*******************************
				
				
				JFrame f_mo=new JFrame();
				JPanel p_mod=new JPanel(null);

				
				JTextField Somme=new JTextField();
				JTextField Comp=new JTextField();
				JButton m_aj=S.bot(new JButton("Valider"),"Ajouter");
				
				JLabel l_Somme=new JLabel("Prix :");
				JLabel l_Comp=new JLabel("Compagnie :");
				
				
				//bounds
				Somme.setBounds(170, 60, 150, 30);
				Comp.setBounds(170, 110, 150, 30);
				l_Somme.setBounds(20, 60, 150, 30);
				l_Comp.setBounds(20, 110, 150, 30);
				m_aj.setBounds(130, 170, 150, 30);
				
				//text
				Somme.setFont(S.FO.deriveFont((float)17));
				Comp.setFont(S.FO.deriveFont((float)17));
				l_Somme.setFont(S.FO.deriveFont((float)17));
				l_Comp.setFont(S.FO.deriveFont((float)17));
				
				
				TitledBorder b_im=new TitledBorder(BorderFactory.createLineBorder(Color.blue, 3),"Vendre Représentation");
				p_mod.setBorder(b_im);
				b_im.setTitleFont(S.FO.deriveFont((float)15));
				
				
				
				m_aj.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
							int idra=0;
							idra=Integer.parseInt(tab.getValueAt(tab.getSelectedRow(), 0).toString());
							RepresentationC C=S.extRC(idra);
							S.actualiser();
							C.Vente(Comp.getText(), Float.parseFloat(Somme.getText()));
						
							f_mo.setVisible(false);
							new JMessages("Spéctacle Vendu");

						
					}
				});
				
			//add

				p_mod.add(Comp);
				p_mod.add(m_aj);
				p_mod.add(l_Comp);
				p_mod.add(Somme);
				p_mod.add(l_Somme);
				
				
				
				
				
				f_mo.getContentPane().add(p_mod);
				f_mo.setTitle("Vendre Un Représentation");
				f_mo.setSize(430, 250);
				f_mo.setVisible(true);
				//**********************************
			}
		});
		if(S.getClass().toString().equals("class SpectacleA"))
			vendre.setEnabled(false);

		
		//
		
		setTitle("Spéctacle");
		pane.add(principal);
		setSize(800,600);
		setLocation(200,0);
		setVisible(true);
	}

}
