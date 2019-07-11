package com.tuto.bouton;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreTypesLayout extends JFrame{
	
	private JPanel pan = new JPanel();	
	private JButton bouton = new JButton("Mon premier bouton");
	
	public FenetreTypesLayout() {
		this.setTitle("Des boutons !");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		pan.add(bouton);
		/* On fait du JPanel le content pan de notre fenêtre, 
		 * celui ci intancie un objet d'agencement par défaut.
		 */
		this.setContentPane(pan);
		
		/* ou ben on ajoute le bouton au content pane de la JFrame
		 * celui ci ne possède pas d'objet d'agencement, bouton prends tout l'espace de la fenêtre
		 */
	    this.getContentPane().add(bouton);
	    /* les layouts managers
	     * 
	     * 1. l'objet BorderLayout()
	     */
	    this.setLayout(new BorderLayout());	    
	    this.getContentPane().add(new JButton("CENTER"), BorderLayout.CENTER);
	    this.getContentPane().add(new JButton("EAST"), BorderLayout.EAST);
		this.setVisible(true);
		/*
		 * 2. l'objet gridLayout()
		 * 
		 */
	    // on définit le layout à utiliser sur le content pane
	    // trois lignes, deux colonnes
		
		this.setLayout(new GridLayout(3,2));
		this.getContentPane().add(new JButton("1"));
		this.getContentPane().add(new JButton("2"));
		
		GridLayout gd = new GridLayout();
		gd.setRows(3);		
		gd.setColumns(2);
		gd.setHgap(5); //Cinq pixels d'espace entre les colonnes (H comme Horizontal)
		gd.setVgap(5); //Cinq pixels d'espace entre les lignes (V comme Vertical) 
		//Ou en abrégé : 
		GridLayout gdi = new GridLayout(3, 2, 5, 5);
		/*
		 * 3. l'objet BoxLayout()
		 * 
		 */
		JPanel b1 = new JPanel();
		b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
		b1.add(new JButton("Bouton première ligne"));
		
		JPanel b2 = new JPanel();
		b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
		b2.add(new JButton("Bouton 1 deuxième ligne"));
		b2.add(new JButton("Bouton 2 deuxième ligne"));
		
		JPanel b3 = new JPanel();
		b3.setLayout(new BoxLayout(b3, BoxLayout.PAGE_AXIS));
		b3.add(b1);
		b3.add(b2);
		this.getContentPane().add(b3);
		this.setVisible(true);

		/*
		 * 3.2 l'objet Box()
		 * c'est une conteneur paramétré avec un BoxLayout()
		 */
	    //On crée un conteneur avec gestion horizontale
	    Box b4 = Box.createHorizontalBox();
	    b4.add(new JButton("Bouton 1"));
	    //Idem
	    Box b5 = Box.createHorizontalBox();
	    b5.add(new JButton("Bouton 1 deuxième ligne"));
	    b5.add(new JButton("Bouton 2 deuxième ligne"));
    
	    Box b6 = Box.createVerticalBox();
	    b6.add(b4);
	    b6.add(b5);
	    this.getContentPane().add(b4);		    
	}
	

}
