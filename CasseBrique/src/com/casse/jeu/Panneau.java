package com.casse.jeu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panneau extends JPanel {

	// variables pour les briques
	protected int briqueRowCount = 3;
	protected int briqueColumnCount = 5;
	protected int briqueWidth = 75;
	protected int briqueHeight = 20;
	protected int briquePadding = 30;
	protected int briqueOffsetTop = 50;
	protected int briqueOffsetLeft = 50;
	// position de la balle
	protected int posX;
	protected int posY;
	protected int balleRay = 20;
	// tableau de briques
	protected Brique[][] briques = new Brique[briqueRowCount][briqueColumnCount];
	// variables du pave
	protected int paveHeight = 10;
	protected int paveWidth = 75;
	protected int paveX;
	// Instanciation des briques à la constrution du panel;
	Panneau(){
		this.creerBriques();
	}
	public void paintComponent(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		this.drawBalle(g);
		this.drawPave(g);
		this.drawBriques(g);

	}
	public void drawBalle(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(posX, posY, balleRay, balleRay);	
	}
	public void drawBriques(Graphics g) {
		for (int r = 0; r < briques.length; r++) {
			for (int c = 0; c < briques[r].length; c++) {
				if (briques[r][c].getStatut() == 1) {
					int briqueX = (c * (briqueWidth + briquePadding)) + briqueOffsetLeft;
					int briqueY = (r * (briqueHeight + briquePadding)) + briqueOffsetTop;
					briques[r][c].setX(briqueX);
					briques[r][c].setY(briqueY);
					g.setColor(Color.blue);
					g.fillRect(briqueX, briqueY, briqueWidth, briqueHeight);
				}
			}
		}
	}

	public void drawPave(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(paveX, this.getHeight()-paveHeight, paveWidth, paveHeight);
	}

	public void creerBriques() {
		for (int r = 0; r < briques.length; r++) {
			for (int c = 0; c < briques[r].length; c++) {
				this.briques[r][c] = new Brique();
			}
		}
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
	/**
	 * @return the paveX
	 */
	public int getPaveX() {
		return paveX;
	}
	/**
	 * @param paveX the paveX to set
	 */
	public void setPaveX(int paveX) {
		this.paveX = paveX;
	}
}
