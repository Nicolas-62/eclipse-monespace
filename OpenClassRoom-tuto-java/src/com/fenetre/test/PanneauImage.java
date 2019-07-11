package com.fenetre.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import fr.perso.mesclasses.Out;

public class PanneauImage extends JPanel{
	
	public void paintComponent(Graphics g) {
	    try {
	        Image img = ImageIO.read(new File("T-rex.jpg"));
//	        g.drawImage(img, 0, 0, this);
	        //Pour une image de fond
	        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);	        
	        //Pour une image de fond
	        //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	      } catch (IOException e) {
	        e.printStackTrace();
	      }  		
	}
}
