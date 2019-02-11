package com.fenetre.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanneauGradient extends JPanel{
	
	// Methode appelée automatiquement par l'objet PanneauGradient pour se dessiner,
	// à chaque redimentionnement de la fenêtre par exemple
	// elle prend en paramètre l'objet Graphics
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
	    GradientPaint gp = new GradientPaint(0, 0, Color.RED, 30, 0, Color.cyan, true);  
	    // coordonnées couleur x, y couleur, coordonnées couleur2 x2, y2, couleur2 dégradé répéte = true
	    g2d.setPaint(gp);
	    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());                              
	}
}
