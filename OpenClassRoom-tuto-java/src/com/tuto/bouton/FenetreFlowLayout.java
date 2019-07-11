package com.tuto.bouton;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreFlowLayout extends JFrame{
	
	private  JPanel pan = new JPanel();
	
	public FenetreFlowLayout(){
		this.setTitle("Des boutons !");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		pan.setLayout(new FlowLayout());
		pan.add(new JButton("bouton 1"));
		pan.add(new JButton("bouton 2"));
		pan.add(new JButton("bouton 3"));
		pan.add(new JButton("bouton 4"));
		pan.add(new JButton("bouton 5"));
		this.getContentPane().add(pan);
		this.setVisible(true);
		
	}

}
