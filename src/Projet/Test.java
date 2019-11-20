package Projet;
import Praphe.*;
import java.awt.*;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Test {
	static int faut=0;
static Connection c=null;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String url="jdbc:derby://localhost:1527/compthea";
		try{
			c=DriverManager.getConnection(url,"root","root");
		}catch(Exception e){
			e.printStackTrace();
		}

		Syst ss=new Syst(c);
		File fi=new File("system.txt");
		
		
		FileReader fr=new FileReader(fi);
		
		if(fr.read()==-1){
			fr.close();
			FileWriter fw=new FileWriter(fi);
			fw.write("Data base Créer");
			fw.close();
		ss.create();}
		
		Salle sa =new Salle(100);
		ss.actualiser();
		
		boolean admin=false;
		String user="";
		String pass="";
		JFrame entre=new JFrame();
		JButton ad=ss.bot(new JButton("Administrateur"), "Autre");
		JButton gr=ss.bot(new JButton("Gérant"), "Autre");
		JTextField us=new JTextField();
		JTextField pas=new JTextField();
		JLabel lus=new JLabel("Admin:");
		JLabel lpas=new JLabel("Mot passe:");
		

		lus.setBounds(30,50, 150, 25);
		lpas.setBounds(30, 150, 150, 25);
		us.setBounds(200, 50, 150, 25);
		pas.setBounds(200, 150, 150, 25);
		ad.setBounds(10, 220, 150, 25);
		gr.setBounds(220, 220, 150, 25);

		entre.setTitle("Login");
		entre.getContentPane().setLayout(null);

		entre.getContentPane().add(lpas);
		entre.getContentPane().add(lus);
		entre.getContentPane().add(us);
		entre.getContentPane().add(pas);
		entre.getContentPane().add(ad);
		entre.getContentPane().add(gr);
		entre.setSize(400, 300);
		entre.setVisible(true);
		
		ad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(faut<3){
				if(pas.getText().equals("root")&&us.getText().equals("root")){
					new Principale(true);
					entre.setVisible(false);
					
				}else {faut++;new JMessages("Admin ou Mot pass incorrect");}
				}else ad.setEnabled(false);
			}
		});
		gr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Principale(false);
				entre.setVisible(false);
			}
		});
		
		/*
		try {
		c.close();
	}catch(Exception e){
		e.printStackTrace();
	}*/
		
	}

}
