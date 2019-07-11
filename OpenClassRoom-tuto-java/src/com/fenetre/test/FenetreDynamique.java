

package com.fenetre.test;

import javax.swing.JFrame;

import com.tuto.bouton.PanneauDynamique;

public class FenetreDynamique extends JFrame{
	private PanneauDynamique pan = new PanneauDynamique();
	
	public FenetreDynamique(){
		this.setTitle("Des objets qui bougent !!");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(this.pan);
		this.setVisible(true);
		this.go();
		
		
	}
	private void go() {
		int x = pan.getPosX();
		int y = pan.getPosY();
		boolean reculeX = false;
		boolean reculeY = false;
		
		while(true) {
			if(x < 1) {
				reculeX=false;		
			}
			if(x > pan.getWidth()-50) {
				reculeX=true;
			}
			if(y < 1) {
				reculeY=false;
			}
			if(y > pan.getHeight()-50){
				reculeY = true;
			}
			if(reculeX) {
				x--;
			}else {
				x++;
			}
			if(reculeY) {
				y--;
			}else {
				y++;
			}
			pan.setPosX(x);
			pan.setPosY(y);
			pan.repaint();		
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
