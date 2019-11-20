package Praphe;
import Projet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.ContextNotEmptyException;
import javax.swing.*;
import javax.swing.text.AbstractDocument.Content;

import Projet.Syst;


public class JMessages extends JFrame{

	Container pane = getContentPane();
	public JMessages(String message){
		setLocationRelativeTo(null);
		Syst s=new Syst();
		
		setSize(250,150);
		setTitle("Messages");
		JPanel paneau=new JPanel(null);
		JButton bu= s.bot(new JButton("OK"), "Autre");
		JLabel mes=new JLabel(message);
		bu.setBounds(60,70,90,25);
		mes.setBounds(25,20,300,25);
		paneau.add(bu);
		paneau.add(mes);
		bu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		pane.add(paneau);
		setVisible(true);
		
	}
}
