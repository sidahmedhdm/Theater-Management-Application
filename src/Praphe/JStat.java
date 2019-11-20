package Praphe;
import Projet.*;
import Projet.*;

import javax.swing.*;
/*
import JMessages;
import RepresentationA;
import RepresentationC;
import Spectacle;
import Syst;
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JStat extends JPanel{

	
	
	public JStat(){
		Syst s=new Syst();
		
		//panel
		JButton q1=s.bot(new JButton("Taux Remplissage"), "Modifier");
		JButton q2=s.bot(new JButton("Jours de Vents"), "Modifier");
		JButton q3=s.bot(new JButton("Recette"), "Modifier");
		
		//bounds
		q1.setBounds(80, 260, 200, 40);
		q2.setBounds(310, 260, 200, 40);
		q3.setBounds(560, 260, 200, 40);
		
		
		//copier
        JLabel id=new JLabel("Représentation:");
		
		JTextField prix=new JTextField();
		JButton spec=s.bot(new JButton("Choisir un Représentation"), "Modifier");
		prix.setEditable(false);
		prix.setBounds(240, 35, 140, 25);
		add(prix);
		spec.setBounds(400, 35, 230, 25);
		add(spec);
		JLabel idr=new JLabel("Nom ( date ) :");
		idr.setBounds(160, 35,100, 25);
		add(idr);
		//coller
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
		
		q1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			float res=0;
			float max=0;
			float ta=0;
			int t=0;
			RepresentationA A=null;
			RepresentationC C=null;
			ResultSet r;
			int id=Integer.parseInt(idrepr.getText());
			if(id>1000000){
				C=s.extRC(id);
			}else A=s.extRA(id);
			if(C==null)
			{//A
				max=A.getMax();
						}else{
				max=C.getMax(); 
						
			}
			r=s.res("select * from Billet where idr="+id); 
			try{
				while(r.next()) res++;
			}catch(SQLException e){
				e.printStackTrace();
			}
			if(res!=0) {ta=res/max; t= (int) (ta*100);System.out.println(res+"05");}
			new JMessages("Taux de remplissage moyen :"+t+" %");
			}
		});
		
		//q2
		q2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int id2=Integer.parseInt(idrepr.getText());
				String dated="";
				String datef="";
				int nbrj=0;
				ResultSet r=s.res("select dateb from billet where idr="+id2+" order by dateb");
				try{
					if(r.next()) dated=r.getString(1);
					while(r.next()) datef=r.getString(1);
				}catch(SQLException e){
					e.printStackTrace();
				}
				if(dated.equals(datef)) nbrj=1;
				else
				nbrj=s.datojours(datef)-s.datojours(dated)+1;
				
				new JMessages("Nombre de jours de vente :"+nbrj);
			
			}
		});
		
		q3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int id3=Integer.parseInt(idrepr.getText());
				String[] ti_sub={"nb_Id","nb_Id Représentation","fl_Somme","st_Organisation"};
				JTable t_sub=s.GetTable("subvention where idr="+id3,ti_sub);
				JScrollPane s_s=new JScrollPane(t_sub);
				s_s.setBounds(20, 92, 400, 130);
				add(s_s);
				String[] ti_bil={"nb_Id","nb_Id Représentation","st_Date","st_Réduction","fl_Prix","st_Référence"};
				JTable t_bil=s.GetTable("Billet where idr="+id3,ti_bil);
				JScrollPane s_b=new JScrollPane(t_bil);
				s_b.setBounds(440, 92, 400, 130);
				add(s_b);
				float totals=0,totalb=0;
				int i=0;
				while(t_sub.getValueAt(i, 0)!=null){
					totals+=Float.parseFloat(t_sub.getValueAt(i, 2).toString());i++;
				}i=0;
				while(t_bil.getValueAt(i, 0)!=null){
					totalb+=Float.parseFloat(t_bil.getValueAt(i, 4).toString());i++;		
				}
				JLabel tos=new JLabel("Total Subventions :"+totals+" da");
				JLabel tob=new JLabel("Total Billets :"+totalb+" da");
				tos.setBounds(140, 225, 200, 30);
				tob.setBounds(470,225, 200, 30);
				add(tos); add(tob);
			
				//***
				JLabel toss=new JLabel("Subventions :");
				JLabel tobb=new JLabel("Billets :");
				toss.setBounds(140,65, 200, 30);
				tobb.setBounds(470,65, 200, 30);
				add(toss); add(tobb);
			
				//***
				
				tos.setFont(s.FO.deriveFont((float)15));
				tob.setFont(s.FO.deriveFont((float)15));
				toss.setFont(s.FO.deriveFont((float)15));
				tobb.setFont(s.FO.deriveFont((float)15));
				
			}
		});
		
		
		
		
		//add
		add(q1); add(q2); add(q3); 
		
		
		
		
		
		
		
		
		
		
		
		
		
		setBorder(BorderFactory.createLineBorder(Color.red));
		setLayout(null);
		setPreferredSize(new Dimension(200,200));
		setBackground(new Color(255,222,200));
		
	}
}
