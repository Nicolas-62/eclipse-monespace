package com.fenetre.test;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanneauDynamique extends JPanel{
	private int posX;
	private int posY;
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.red);
		g.fillOval(posX, posY, 50, 50);
		
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	

}
