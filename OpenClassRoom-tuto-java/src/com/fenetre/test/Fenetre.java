package com.fenetre.test;

import java.awt.Color;
import java.awt.color.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre {

	public Fenetre() {
		
		JFrame fenetre = new JFrame();
		
		fenetre.setTitle("Ma première fenêtre !!!!");
		fenetre.setSize(400, 100);
		fenetre.setLocationRelativeTo(null);
		// Instanciation d'un objet JPanel
		JPanel pan = new JPanel();
		pan.setBackground(Color.ORANGE);
		fenetre.setContentPane(pan);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		

	}

}
