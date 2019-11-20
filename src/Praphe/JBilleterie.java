package Praphe;
import java.awt.*;
import Projet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Projet.Abonnement;
import Projet.Billet;
import Projet.Spectacle;
import Projet.Syst;
public class JBilleterie extends JPanel {
	
	
	public JBilleterie(boolean admin){
		Syst s=new Syst();
		setLayout(null);
		JPanel billet=new JPanel(null);
		JPanel abonnement=new JPanel(null);
		
		TitledBorder bbi=new TitledBorder(BorderFactory.createLineBorder(Color.red), "Billet");
		bbi.setTitleFont(new Font("arial", Font.BOLD, 25));
		
		billet.setBorder(bbi);
		
		billet.setBounds(1, 1, 425, 350);
		add(billet);
		
		TitledBorder bab=new TitledBorder(BorderFactory.createLineBorder(Color.red), "Abonnement");
		bab.setTitleFont(new Font("arial", Font.BOLD, 25));
		
		abonnement.setBorder(bab);
		
		abonnement.setBounds(426,1,425, 350);
		add(abonnement);
		
		JLabel id=new JLabel("Représentation:");
		
		JTextField prix=new JTextField();
		JButton spec=s.bot(new JButton("Choisir un Représentation"), "Modifier");
		prix.setEditable(false);
		prix.setBounds(90, 35, 90, 25);
		billet.add(prix);
		spec.setBounds(185, 35, 230, 25);
		billet.add(spec);
		JLabel idr=new JLabel("Nom ( date ) :");
		idr.setBounds(10, 35,100, 25);
		billet.add(idr);
		JTextField autre=new JTextField("Autre");
		autre.setBounds(300,150,82,30);
		billet.add(autre);
		autre.setVisible(false);
		String[] categorie={"Enfant","Personnes âgée","Chômeur","Etudiant","Autre"};
		JComboBox cat=new JComboBox(categorie);
		cat.setBounds(180,150,100,30);
		billet.add(cat);
		
		cat.setAction(new Action() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				switch(cat.getSelectedIndex()) {
				case 4:autre.setVisible(true);break;
				default : autre.setVisible(false);
				}
			}
			
			@Override
			public void setEnabled(boolean arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removePropertyChangeListener(PropertyChangeListener arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void putValue(String arg0, Object arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public Object getValue(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void addPropertyChangeListener(PropertyChangeListener arg0) {
				// TODO Auto-generated method stub
				
			}
		});;
		
		int idrepresentation=0;
		
		JLabel lcat=new JLabel("Catégorie de Client    :");
		lcat.setBounds(20,150,180,30);
		billet.add(lcat);
		
		String date=s.daAct();
		JTextField daa=new JTextField(date);
		daa.setBounds(180, 110,70, 30);
		billet.add(daa);
		daa.setEditable(false);
		JLabel da=new JLabel("Date d'Aujourdhuit     : ");
		da.setBounds(20, 110, 180, 30);
		billet.add(da);
		JButton md=s.bot(new JButton(""), "Modifier");
		md.setBounds(255, 110, 25, 30);
		billet.add(md);
		
		JPanel inf=new JPanel(null);
		TitledBorder bin=new TitledBorder(BorderFactory.createLineBorder(new Color(200,20,30), 2), "plus information de billet");
		inf.setBorder(bin);
		bin.setTitleFont(s.FO.deriveFont((float)18));
		inf.setBounds(5,210,414,135);
		billet.add(inf);
		
		JButton generer=s.bot(new JButton("Créer Billet"), "Ajouter");
		generer.setBounds(180,185,180,25);
		billet.add(generer);
		
		JLabel iredu=new JLabel("Réduction : ");
		JLabel irefe=new JLabel("Référence : ");
		JLabel iprix=new JLabel("Prix Final : ");
		JTextField ired=new JTextField("NULL");
		JTextField iref=new JTextField("NULL");
		JTextField ipri=new JTextField("NULL");
		ired.setEditable(false);
		iref.setEditable(false);
		ipri.setEditable(false);

		iredu.setBounds(25, 30, 150, 25);
		irefe.setBounds(25, 60, 150, 25);
		iprix.setBounds(25, 90, 150, 25);
		ired.setBounds(170, 30, 100, 25);
		iref.setBounds(170, 60, 100, 25);
		ipri.setBounds(170, 90, 100, 25);
		inf.add(iredu);inf.add(irefe);inf.add(iprix);
		inf.add(ired);inf.add(iref);inf.add(ipri);
		
		JTextField idrepr=new JTextField();
		spec.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//****************************
				JFrame rep=new JFrame();
				JPanel pan_rep=new JPanel(null);
				JLabel nom_spec=new JLabel("Nom du Spéctacle :");
				JTextField nom=new JTextField();
				JButton spect=s.bot(new JButton("Valider"), "Modifier");
				
				
				//bounds
				nom_spec.setBounds(20, 20, 200, 30);
				nom.setBounds(140, 20, 200, 30);
				spect.setBounds(343,20,120,30);
				
				
				//add
				pan_rep.add(nom);pan_rep.add(nom_spec);
				pan_rep.add(spect);
				
				
				//action
				spect.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						String par=nom.getText();
						Spectacle S=null;boolean b=true;
						JTable tab;
						ResultSet r=s.Rech("nomc", "'"+par+"'", "SpectacleC");
					try{
						if(r.next()){
							S=s.extSC(r.getInt(1));b=false;
						}
					}catch(SQLException e){
						e.printStackTrace();
					}
					if(b){
						r=s.Rech("noma", "'"+par+"'", "SpectacleA");
						try{
							if(r.next()){
								S=s.extSA(r.getInt(1));
							}
						}catch(SQLException e){
							e.printStackTrace();
						}
					}
					if(S!=null){
						if(b){
						String[] titre={"nb_Id","st_Date","nb_Nombre Places"};
						tab=s.GetTable("RepresentationA where idsa="+S.getIdS(), titre);
					}else {

						String[] titre={"nb_Id","st_Date","fl_Cout MS","nb_Nombre Places"};
						tab=s.GetTable("RepresentationC where idsc="+S.getIdS(), titre);
					}
						JScrollPane stab=new JScrollPane(tab);
						stab.setBounds(35, 60, 400, 300);
						pan_rep.add(stab);
						JButton selec=s.bot(new JButton("Séléctionner Réprésentation"), "Ajouter");
						selec.setBounds(100, 410, 250, 30);
						pan_rep.add(selec);
						pan_rep.repaint();
						selec.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								// TODO Auto-generated method stub
								String da;
								if(tab.getSelectedRow()==-1)
									new JMessages("Vous devez séléctionner un Représention").setSize(300, 150);
								else{
									prix.setText(nom.getText()+"("+tab.getValueAt(tab.getSelectedRow(), 1)+")");
									rep.setVisible(false);
									idrepr.setText(tab.getValueAt(tab.getSelectedRow(), 0).toString());
								    
								}
							}
						});
						
						}else new JMessages("Spéctacle n'existe pas");
					
					}
				});
				
				
				
				
				
				rep.getContentPane().add(pan_rep);
				rep.setTitle("Représentation");
				rep.setSize(500,500);
				rep.setVisible(true);
				//******************************
			}
		});
		
		JTextField x_nom=new JTextField();
		JTextField x_prenom=new JTextField();
		JTextField x_data=new JTextField(""+s.daAct());
		String daexp=s.daAct().substring(0, 3)+(1+Integer.parseInt(s.daAct().substring(3, 4)))+s.daAct().substring(4, 10);
		JTextField x_datex=new JTextField(daexp);
		
		JLabel l_nom=new JLabel("Nom  :");
		JLabel l_prenom=new JLabel("Prénom  :");
		JLabel l_data=new JLabel("Date Abonnement  :");
		JLabel l_datex=new JLabel("Date Expération  :");
		
		//bounds
		x_nom.setBounds(200, 40, 150, 30);
		x_prenom.setBounds(200, 90, 150, 30);
		x_data.setBounds(200, 140, 150, 30);
		x_datex.setBounds(200, 190, 150, 30);
		
		l_nom.setBounds(30, 40, 150, 30);
		l_prenom.setBounds(30, 90, 150, 30);
		l_data.setBounds(30, 140, 150, 30);
		l_datex.setBounds(30, 190, 150, 30);
		
		//add
		abonnement.add(x_nom);abonnement.add(x_prenom);abonnement.add(x_data);abonnement.add(x_datex);
		abonnement.add(l_nom);abonnement.add(l_prenom);abonnement.add(l_data);abonnement.add(l_datex);
		
		JRadioButton typ_a=new JRadioButton("Abonnement trois spectacles");
		JRadioButton typ_3=new JRadioButton("Abonnement entrée libre annuelle");
		ButtonGroup typ=new ButtonGroup();
		typ.add(typ_a);typ.add(typ_3);
		typ_a.setBounds(5, 250, 195, 30);
		typ_3.setBounds(200, 250, 220, 30);

		abonnement.add(typ_3);		abonnement.add(typ_a);
		
		typ_a.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				x_data.setVisible(false);
				x_datex.setVisible(false);
				l_data.setVisible(false);
				l_datex.setVisible(false);
			}
		});
		typ_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				x_data.setVisible(true);
				x_datex.setVisible(true);
				l_data.setVisible(true);
				l_datex.setVisible(true);
				}
		});
		typ_3.setSelected(true);
		JButton ab_bu=s.bot(new JButton("Créer Abonnement"), "Ajouter");
		ab_bu.setBounds(50, 295, 200, 40);
		abonnement.add(ab_bu);
		
		ab_bu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String par_nom=x_nom.getText();
				String par_prenom=x_prenom.getText();
				String par_data=x_data.getText();
				String par_datex=x_datex.getText();
				Abonnement Ab=null;
				s.actualiser();
				if(typ_3.isSelected()){
					Ab=new Abonnement(par_nom, par_prenom, par_data, par_datex);
				}
				else Ab=new Abonnement(par_nom, par_prenom, par_data);
			Ab.ajout();
			new JMessages("Abonnement Créer");
			}
			
		});
		
		generer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int idrp=Integer.parseInt(idrepr.getText());
				String datb=daa.getText();
				String par_cat=cat.getSelectedItem().toString();
				s.actualiser();
				Billet baj=null;
				s.actualiser();
				if(idrp<1000000){s.actualiser();
				
					 baj=new Billet(s.extRA(idrp), datb, par_cat);
				}
				else{s.actualiser();
				RepresentationC Cr=s.extRC(idrp);
				baj=new Billet(Cr, datb, par_cat);

				
				}
			baj.ajout();
			ired.setText(baj.getR()+" %");
			iref.setText(baj.getRef());
			ipri.setText(""+baj.getPrix());
			
			
			}
		});
		md.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			daa.setEditable(true);
			}
		});
		JButton Réduction=s.bot(new JButton("Activer"), "Autre");
		JLabel act=new JLabel("Activer Réduction");
		act.setBounds(275,40,200,25);
		inf.add(act);
		Réduction.setBounds(275, 70, 120, 30);
		Réduction.setEnabled(admin);
		inf.add(Réduction);
		Réduction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Billet Bo=new Billet();
				if(Bo.getAdmin()){
					Bo.setAdmin(false);
					Réduction.setText("Activer");

					new JMessages("Réduction Désactiver");	
				}
				else{
					Bo.setAdmin(true);
					Réduction.setText("Désactiver");
					new JMessages("Réduction Activer");
					}
				
			}
		});
		
		
	}
}
