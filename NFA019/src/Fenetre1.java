import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre1 {
	public static void main(String[] args) {
		
		JFrame jf = new JFrame("Java avec Reza");
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(50, 50, 800, 600);
		JLabel jl = new JLabel("Swing demo 1");
		jl.setBounds(20, 20, 300, 30);
		jf.getContentPane().add(jl);
		jf.getContentPane().setLayout(null);
		
		// troisieme parametre 
		JDialog jd = new JDialog(jf,"a dialog",true);
		jd.setBounds(50, 50, 200, 100);
		jd.setVisible(true);
	}
}
