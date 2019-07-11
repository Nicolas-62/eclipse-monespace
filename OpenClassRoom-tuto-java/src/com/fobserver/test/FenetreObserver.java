package com.fobserver.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class FenetreObserver extends JFrame implements ActionListener{

		private BoutonObs bouton = new BoutonObs("salut gros naze");
		private JPanel container = new JPanel();
		private JLabel label = new JLabel("Mon premier Label");
		// Compteur de clics :
		private int compteur;
		
		public FenetreObserver() {
			this.setTitle("Des boutons !");
			this.setSize(600, 400);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);	
			container.setLayout(new BorderLayout());
			
			//Nous ajoutons notre fenêtre à la liste des auditeurs de notre bouton
		    bouton.addActionListener(this);
		    
			container.add(bouton, BorderLayout.SOUTH);
			// Personnalisation du label :
			Font police = new Font("Tahoma", Font.BOLD, 16);
			label.setFont(police);
			label.setForeground(Color.blue);
			label.setHorizontalAlignment(JLabel.CENTER);
			
			
			container.add(label, BorderLayout.NORTH);
			this.setContentPane(container);
			this.setVisible(true);
		}

		// Methode qui sera appelée lors d'un clic sur le bouton
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		    //Lorsque l'on clique sur le bouton, on met à jour le JLabel
		    this.compteur++;
		    label.setText("Vous avez cliqué " + this.compteur + " fois");			
		}
		
}
