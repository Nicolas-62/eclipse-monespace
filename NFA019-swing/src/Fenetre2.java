import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Fenetre2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Environnement2 e = new Environnement2();
		Environnement2bis ebis = new Environnement2bis();

	}
}
class Environnement2{
	JFrame fenetre = new JFrame("une fenetre");
	JButton bouton = new JButton("cliquer ici");
	JTextField monTexte = new JTextField("Ecrire ici", 50);
	
	Environnement2(){
		fenetre.getContentPane().setLayout(new FlowLayout());
		fenetre.getContentPane().add(bouton);
		fenetre.getContentPane().add(monTexte);
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
class Environnement2bis{
	JFrame fenetre = new JFrame("une fenetre");
	JButton bouton = new JButton("cliquer ici");
	JTextField monTexte = new JTextField("Ecrire ici",50);
	
	Environnement2bis(){
		fenetre.getContentPane().setLayout(new GridLayout(1,2));
		
		fenetre.getContentPane().add(bouton);
		fenetre.getContentPane().add(monTexte);
		fenetre.pack();
		fenetre.setVisible(true);
	}
}
