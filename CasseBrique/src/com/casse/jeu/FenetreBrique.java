package com.casse.jeu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreBrique extends JFrame implements KeyListener {

	private Panneau pan = new Panneau();
	private JPanel container = new JPanel();
	private JPanel containerLabel = new JPanel();
	private JLabel message = new JLabel("Perdu !");
	private JLabel messageScore = new JLabel("Score : "+this.score+"  ");
	private int score = 0;
	private boolean animated = true;
	private boolean rightPressed, leftPressed;
	private int x, y;
	private int dx = 2;
	private int dy = 3;
	private int r = pan.balleRay;
	private boolean start = true;

	FenetreBrique() {
		this.setTitle("Animation");
		this.setSize(600, 420);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		pan.setBackground(Color.gray);
		
		containerLabel.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		
		Font police = new Font("Tahoma", Font.BOLD, 16);
		message.setFont(police);
		message.setForeground(Color.white);
		// la ligne suivante marche pas
		message.setHorizontalAlignment(JLabel.RIGHT);
		message.setSize(this.getWidth(), 30);
		
		messageScore.setFont(police);
		messageScore.setBackground(Color.yellow);
		messageScore.setForeground(Color.blue);
		// la ligne suivante marche pas
		messageScore.setHorizontalAlignment(JLabel.LEFT);
		messageScore.setSize(this.getWidth(), 30);		
		
		containerLabel.add(messageScore, BorderLayout.EAST);
		containerLabel.add(message, BorderLayout.WEST);
		container.add(containerLabel, BorderLayout.NORTH);
		
		this.setContentPane(container);
		this.addKeyListener(this);
		this.setVisible(true);
		go();
	}

	@Override
	// methodes pour faire bouger le pave et fermer la fenetre
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyCode() == 39) {
			rightPressed = true;
		} else if (arg0.getKeyCode() == 37) {
			leftPressed = true;
			// une fois le jeu terminé appuyer sur la touche entrée ferme le programme
		} else if (arg0.getKeyCode() == 10 && animated == false) {
			System.exit(1);
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == 39) {
			rightPressed = false;
		} else if (arg0.getKeyCode() == 37) {
			leftPressed = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	private void go() {
		// definition de la position des éléments, à faire une fois les elements mis en
		// place par le constructeur
		if (start) {
			pan.setPosX(pan.getWidth() / 2);
			pan.setPosY(pan.getHeight() - pan.paveHeight - r);
			pan.setPaveX((pan.getWidth() - pan.paveWidth) / 2);
			start = false;
		}

		// Les coordonnées de départ de notre rond
		x = pan.getPosX();
		y = pan.getPosY();
//		 System.out.println("hauteur jframe : "+this.getHeight());
//		 System.out.println("hauteur container : "+container.getHeight());
//		 System.out.println("hauteur pan : "+pan.getHeight());
//		 System.out.println("hauteur message : "+message.getHeight());
//		 System.out.println("hauteur pave : "+pan.paveHeight);
//		 System.out.println("hauteur balle : "+r);
//		 System.out.println("posY : "+pan.getPosY());
		// Boucle dans laquelle se fait le rafraichissement du panel, voir à la fin de la boucle
		while (this.animated) {
			// detection des colisions entre la balle et les briques
			for (int r = 0; r < pan.briques.length; r++) {
				for (int c = 0; c < pan.briques[r].length; c++) {
					if (pan.briques[r][c].getStatut() == 1) {
						if (x > (pan.briques[r][c].getX() - r) && x < (pan.briques[r][c].getX() + pan.briqueWidth)
								&& y > (pan.briques[r][c].getY() - r)
								&& y < (pan.briques[r][c].getY() + pan.briqueHeight)) {
							// changement du statut de la brique, elle a été touche et ne sera plus affichée
							pan.briques[r][c].setStatut(0);
							// mise à jour du score
							score++;
							messageScore.setText("Score : "+this.score+"  ");
							if (score == pan.briqueRowCount * pan.briqueColumnCount) {
								try {
									message.setText("Gagné !!");
									message.setForeground(Color.blue);
									animated = false;
								} catch (SecurityException e) {
									e.printStackTrace();
								}
							}
							dy = -dy;
						}
					}
				}
			}
			// mouvements du pave
			if (leftPressed && pan.paveX > 0) {
				pan.setPaveX(pan.paveX - 7);
			} else if (rightPressed && pan.paveX + pan.paveWidth < pan.getWidth()) {
				pan.setPaveX(pan.paveX + 7);
			}
			// detection des colisions entre la balle et la fenêtre
			if (x + dx < 0) {
				dx = -dx;
			} else if (x + dx > pan.getWidth() - r) {
				dx = -dx;
			}
			if (y + dy < 0) {
				dy = -dy;
			} else if (y + dy > (pan.getHeight() - r - pan.paveHeight)) {
				if (x > pan.paveX && x < (pan.paveX + pan.paveWidth)) {
					dy = -dy;
				} else if (y + dy > pan.getHeight() - r) {
					try {
						message.setForeground(Color.blue);
						animated = false;
					} catch (SecurityException e) {
						e.printStackTrace();
					}
				}
			}
			// mise à jour de la position de la balle et nouvel affichage du panel
			pan.setPosX(x += dx);
			pan.setPosY(y += dy);
			pan.repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
