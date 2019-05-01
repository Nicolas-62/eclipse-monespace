import javax.swing.JFrame;

public class Fenetre1bis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Environnement1 evr = new Environnement1();

	}

}

class Environnement1 {
	JFrame fenetre = new JFrame("Une fenetre");

	Environnement1() {
		fenetre.setSize(400, 600);
		fenetre.setVisible(true);
	}
}