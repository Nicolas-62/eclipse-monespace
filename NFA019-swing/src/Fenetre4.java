import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Fenetre4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Environement4 e4= new Environement4();
    }
}
class Environement4{
    JFrame fenetre = new JFrame("Une fenetre");
    //les panneaux
    JMenuBar barreDeMenus = new JMenuBar();
    JPanel phaut= new JPanel();
    JPanel pbas= new JPanel();
    //-----------
// les boutons
    JButton boutonR= new JButton("Rouge");
    JButton boutonB= new JButton("Bleu");
    JButton boutonV= new JButton("Vert");
    JButton boutonJ= new JButton("Jaune");
    //les zones de texte
    JTextArea zone= new JTextArea(3,20);
    JTextArea zoneCentre= new JTextArea(5,50);

    //les labels
    JLabel label =new JLabel("UN texte");

    //Les menus
    JMenu menuJOurs= new JMenu("jours");
    JMenu menuMois= new JMenu("Mois");

    JMenuItem mItemLundi = new JMenuItem("Lundi");
    JMenuItem mItemMardi = new JMenuItem("Mardi");
    JMenuItem mItemDimanche  = new JMenuItem("Dimanche");
    JMenuItem mItemMai = new JMenuItem("Mai");
    JMenuItem mItemJuin = new JMenuItem("Juin");

    Environement4(){
        //----panel du haut 
        phaut.setLayout(new GridLayout(2,2));
        phaut.add(boutonR);
        phaut.add(boutonB);
        phaut.add(boutonV);
        phaut.add(boutonJ);
        //--------- panel du bas
        pbas.setLayout(new FlowLayout());
        pbas.add(label);
        pbas.add(zone);

        //-------------menu
        menuJOurs.add(mItemLundi);
        menuJOurs.add(mItemMardi);
        menuJOurs.addSeparator();
        menuJOurs.add(mItemDimanche);
        menuMois.add(mItemMai);
        menuMois.add(mItemJuin);
        barreDeMenus.add(menuJOurs);
        barreDeMenus.add(menuMois);
        //--------------------- organisation de la Frame
        fenetre.setJMenuBar(barreDeMenus);
        fenetre.getContentPane().setLayout(new BorderLayout());
        fenetre.getContentPane().add(phaut,BorderLayout.NORTH);
        fenetre.getContentPane().add(zoneCentre,BorderLayout.CENTER);
        fenetre.getContentPane().add(pbas,BorderLayout.SOUTH);
        fenetre.pack();
        fenetre.setVisible(true);
    }
}