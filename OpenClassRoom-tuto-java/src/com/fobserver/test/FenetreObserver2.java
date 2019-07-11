package com.fobserver.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fenetre.test.PanneauDynamique;

public class FenetreObserver2 extends JFrame{
	// le JPanel qui contient la balle
	private PanneauDynamique pan = new PanneauDynamique();
	// les deux boutons
	private JButton bouton = new JButton("bouton 1");
	private JButton bouton2 = new JButton("bouton 2");
	// le JPanel qui va contenir deux JPanel, celui de la balle et celui des boutons
	private JPanel container = new JPanel();
	private JLabel label = new JLabel("Le JLabel");
	private JLabel label2 = new JLabel("Le JLabel n°2");
	private int compteur = 0;

	public FenetreObserver2() {
		this.setTitle("Animation");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		// ajout du premier JPanel qui contient la balle
		container.add(pan, BorderLayout.CENTER);

		// Ce sont maintenant nos classes internes qui écoutent nos boutons
		bouton.addActionListener(new BoutonListener());
		bouton2.addActionListener(new Bouton2Listener());
		bouton2.addActionListener(new Bouton2Listener2());

		// creation du JPanel qui contient les boutons
		JPanel south = new JPanel();
		south.add(bouton);
		south.add(bouton2);
		// ajout du JPanel "boutons" au JPanel container
		container.add(south, BorderLayout.SOUTH);
		
		// Personnalisation du Label
		Font police = new Font("Tahoma", Font.BOLD, 16);
		label.setFont(police);
		label.setForeground(Color.blue);
		label.setHorizontalAlignment(JLabel.CENTER);
		label2.setFont(police);
		label2.setForeground(Color.blue);
		label2.setHorizontalAlignment(JLabel.CENTER);
		// creation du JPanel qui contient les labels :
		JPanel north = new JPanel();
		north.setLayout(new BorderLayout());
		north.add(label, BorderLayout.NORTH);
		north.add(label2, BorderLayout.SOUTH);
		// ajout du JPanel "labels" au JPanel container
		container.add(north, BorderLayout.NORTH);
		// ajout du JPanel container au JPanel de la fenêtre
		this.setContentPane(container);
		this.setVisible(true);
		go();
	}

	/*
	 * On créer ici deux classes internes, elles ont accès aux attributs de la
	 * classe dans laquelle elles sont déclarées. Dans le cas qui nous intéresse,
	 * cela permet de créer une implémentation de l'interface ActionListener
	 * détachée de notre classe Fenetre, mais pouvant utiliser ses attributs.
	 * Ces classes ont même accès aux attributs private
	 */
	// Classe écoutant notre premier bouton
	class BoutonListener implements ActionListener {
		// Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent arg0) {
			label.setText("Vous avez cliqué sur le bouton 1");
		}
	}

	// Classe écoutant notre second bouton
	class Bouton2Listener implements ActionListener {
		// Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			label.setText("Vous avez cliqué sur le bouton 2");
		}
	}
	class Bouton2Listener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			label2.setText("Ca t'amuses de cliquer ?");
		}
	}

	private void go() {
		// Les coordonnées de départ de notre rond
		int x = pan.getPosX(), y = pan.getPosY();
		// Le booléen pour savoir si l'on recule ou non sur l'axe x
		boolean backX = false;
		// Le booléen pour savoir si l'on recule ou non sur l'axe y
		boolean backY = false;

		// Dans cet exemple, j'utilise une boucle while
		// Vous verrez qu'elle fonctionne très bien
		while (true) {
			// Si la coordonnée x est inférieure à 1, on avance
			if (x < 1)
				backX = false;
			// Si la coordonnée x est supérieure à la taille du Panneau moins la taille du
			// rond, on recule
			if (x > pan.getWidth() - 50)
				backX = true;
			// Idem pour l'axe y
			if (y < 1)
				backY = false;
			if (y > pan.getHeight() - 50)
				backY = true;

			// Si on avance, on incrémente la coordonnée
			if (!backX)
				pan.setPosX(++x);
			// Sinon, on décrémente
			else
				pan.setPosX(--x);
			// Idem pour l'axe Y
			if (!backY)
				pan.setPosY(++y);
			else
				pan.setPosY(--y);

			// On redessine notre Panneau
			pan.repaint();
			// Comme on dit : la pause s'impose ! Ici, trois millièmes de seconde
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
