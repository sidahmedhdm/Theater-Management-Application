package Praphe;
import Projet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Projet.Syst;




public class Principale extends JFrame {
	
	
	
	
	private Container pane = getContentPane();
	
	public Principale(boolean admin){
		Syst s=new Syst();
	JPanel pano=new JPanel(null);//*****JPANEL
	JPanel prin=new JPanel();
	JPanel cote=new JPanel();
	JPanel Top=new JPanel();//top
	
	
	Top.setBounds(1,1,999,210);
	cote.setBounds(1,200,109,530);	
	prin.setBounds(92, 200, 900, 550);
	
	pano.add(cote);
	
	JLabel i=new Syst().img("src/img/cote.png");
	cote.add(i);
	JTabbedPane tab;
	UIManager.put("TabbedPane.selected",new Color(255,240,245)); 
	
	
	
	
	tab=new JTabbedPane();
	prin.add(tab);
	
	//JLabel l = new JLabel("COMPTHEA");
	//l.setFont(new Syst().FO.deriveFont((float)95));
	Top.setBackground(new Color(240,50,50));
	cote.setBackground(new Color(240,50,50));
	pano.setBackground(new Color(240,50,50));
	JLabel l = new Syst().img("src/img/top.jpg");
	Top.add(l);
	prin.setBackground(new Color(240,50,50));
	
	//******************************* JPanel Tab
	JPanel pan_Spect=new JJSpectacle();
	JPanel pan_Bille=new JBilleterie(admin);
	JPanel pan_Recet=new JRecette();
	JPanel pan_Depon=new JDeponse();
	JPanel pan_stat=new JStat();
	tab.add("Spéctacle", pan_Spect);
	tab.add("Billeterie", pan_Bille);
	if (admin){tab.add("Recette", pan_Recet);
	tab.add("Déponse", pan_Depon);
	tab.add("Statistique", pan_stat);}
	
	tab.setBorder(BorderFactory.createLineBorder(new Color(250,255,255)));
	tab.setFont(new Syst().FO.deriveFont((float)17));
	tab.setBackground(new Color(240,50,50));
	JButton k=new Syst().bot(new JButton("Supprimer"),"Supprimer");
	//Top.add(k);
	
	tab.setBackgroundAt(0,new Color(255,222,200));//spec
	tab.setBackgroundAt(1,new Color(255,222,200));//bill
	if(admin) {tab.setBackgroundAt(2,new Color(200,255,200));//rec
	tab.setBackgroundAt(3,new Color(255,222,200));//deop
	}
	tab.setForegroundAt(0,new Color(255,0,0));//spec
	tab.setForegroundAt(1,new Color(255,20,20));//bill
	if(admin){tab.setForegroundAt(2,new Color(255,20,20));//rec
	tab.setForegroundAt(3,new Color(255,20,20));//deo
	}
	tab.setFocusable(false);
	tab.setFocusCycleRoot(false);
	tab.setBorder(BorderFactory.createLineBorder(new Color(240,50,50)));
	tab.setFont(new Font(Font.SERIF,Font.TYPE1_FONT, 26));
	//System.out.println(tab.getTabLayoutPolicy());
	
	
	
	tab.setPreferredSize(new Dimension(860, 400));
	
    pano.add(prin);
	pano.add(Top);

	pane.add(pano);
	
		
		

	setDefaultCloseOperation(EXIT_ON_CLOSE);
		Image Icn=new ImageIcon("src/img/logo.ico").getImage().getScaledInstance(3, 3, Image.SCALE_DEFAULT);
		setIconImage(Icn);
		setTitle("COMPTHEA");
		setLocation(200,0);
		setSize(1000, 750);
		
		JMenuBar jmb=new JMenuBar();
		JMenu jm=new JMenu("Fichier");
		JMenuItem jmi=new JMenuItem("Actualiser");
		jmb.add(jm); jm.add(jmi);
		jmi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Principale(admin);
			}
		});

        //Set the active tab background to white
      this.setJMenuBar(jmb);
		jmb.add(s.men());
	
	setVisible(true);

}
}