import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Fenetre3 {
	public static void main(String[] args) {
		Environnement3 e3 = new Environnement3();
	}
}
class Environnement3{
	JFrame fenetre = new JFrame("une fenetre");
	// panneaux
	JPanel pHaut = new JPanel();
	JPanel pBas = new JPanel();
	// boutons
	JButton boutonR = new JButton("rouge");
	JButton boutonB = new JButton("Bleu");
	JButton boutonV = new JButton("Vert");
	JButton boutonJ = new JButton("Jaune");
	// zones de texte
	JTextArea zone = new JTextArea(3,20);
	JTextArea zoneCentre = new JTextArea(5,50);
	// les labels
	JLabel label = new JLabel("un texte");
	
	Environnement3(){
		// panel du haut
		pHaut.setLayout(new GridLayout(2,2));
		pHaut.add(boutonB);
		pHaut.add(boutonJ);
		pHaut.add(boutonR);
		pHaut.add(boutonV);
		// panel du bas
		pBas.setLayout(new FlowLayout());
		pBas.add(label);
		pBas.add(zone);
		// organisation de la frame
		fenetre.getContentPane().setLayout(new BorderLayout());
		fenetre.getContentPane().add(pHaut,BorderLayout.NORTH);
		fenetre.getContentPane().add(zoneCentre,BorderLayout.CENTER);
		fenetre.getContentPane().add(pBas,BorderLayout.SOUTH);
		
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
