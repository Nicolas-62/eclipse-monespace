package com.fenetre.test;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreCadeau  extends JFrame{

	public FenetreCadeau() {
		
		this.setTitle("Ma deuxième fenêtre !!!!");
		this.setSize(800, 800);
		// emplacement de la fenêtre : null = centre de l'écran.
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setContentPane(new Panneau());
//		this.setContentPane(new PanneauImage());
//		this.setContentPane(new PanneauGradient());
		this.setContentPane(new PanneauCadeau());
		this.setVisible(true);
		

	}

}
