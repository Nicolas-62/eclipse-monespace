package cnam.calculatrice.swing;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculatrice {

	private JFrame frame = new JFrame();;
	private JTextField champ = new JTextField();
	private String nb1 = "";
	private String nb2 = "";
	private Double result = null;
	private String operateur = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculatrice window = new Calculatrice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculatrice() {
		initialize();
	}

	// Annule toute les operations en cours et vide l'affichage
	public void supprimer() {
		effacer();
		nb1 = "";
		nb2 = "";
		result = null;
		operateur = "";
	}

	// vide l'affichage
	public void effacer() {
		champ.setText("");
	}

	// affiche un nombre
	public void afficher(String nb) {
		champ.setText(nb);
	}
	// ajoute un chiffre au nombre en cours et affiche ce nombre
	public void ajouter(String nb) {
		// si un resultat est déjà affiché on reset tout ajoute le chiffre au premier nombre
		if (result != null) {
			supprimer();
			nb1 += nb;
			afficher(nb1);
		}
		// si on a déjà tapé l'operateur on ajoute le chiffre au nb2
		else if (operateur.length()!=0) {
			effacer();
			nb2 += nb;
			afficher(nb2);
		} 
		// sinon on ajoute le chiffre au nombre 1
		else {
			if (nb1.length() < 10) {
				nb1 += nb;
				afficher(nb1);
			}
		}
	}
	// effectue l'opération entre les deux nombres et enregistre le resultat
	public void calculer() {
		// on calcule que si le nombre 2 est renseigné
		Double val1 = Double.parseDouble(nb1);
		Double val2 = Double.parseDouble(nb2);
		if ("+".equals(operateur))
			result = val1 + val2;
		if ("-".equals(operateur))
			result = val1 - val2;
		if ("x".equals(operateur))
			result = val1 * val2;
		if ("/".equals(operateur))
			result = val1 / val2;
	}
	// enregistre l'opérateur
	public void ajoutOperateur(String ope) {
		// si le nombre 2 est déjà renseigné :
		// effectue l'operation et enregistre le resultat dans nb1
		if (nb2.length()!=0) {
			calculer();
			nb1 = Double.toString(result);
			nb2 = "";
			result = null;
		}
		operateur = ope;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCalculatriceTdNfa = new JLabel("calculatrice TD NFA0019");
		lblCalculatriceTdNfa.setBounds(25, 11, 196, 14);
		frame.getContentPane().add(lblCalculatriceTdNfa);

		champ.setBounds(25, 40, 368, 20);
		frame.getContentPane().add(champ);
		champ.setColumns(10);

		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter("0");
			}
		});
		btn0.setBounds(25, 210, 91, 23);
		frame.getContentPane().add(btn0);

		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter("1");
			}
		});
		btn1.setBounds(25, 160, 91, 23);
		frame.getContentPane().add(btn1);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter("2");
			}
		});
		btn2.setBounds(126, 160, 91, 23);
		frame.getContentPane().add(btn2);
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter("3");
			}
		});
		btn3.setBounds(227, 160, 91, 23);
		frame.getContentPane().add(btn3);
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter("4");
			}
		});
		btn4.setBounds(25, 120, 91, 23);
		frame.getContentPane().add(btn4);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter("5");
			}
		});
		btn5.setBounds(126, 120, 91, 23);
		frame.getContentPane().add(btn5);
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter("6");
			}
		});
		btn6.setBounds(227, 120, 91, 23);
		frame.getContentPane().add(btn6);
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter("7");
			}
		});
		btn7.setBounds(25, 80, 91, 23);
		frame.getContentPane().add(btn7);
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter("8");
			}
		});
		btn8.setBounds(126, 80, 91, 23);
		frame.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter("9");
			}
		});
		btn9.setBounds(227, 80, 91, 23);
		frame.getContentPane().add(btn9);

		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimer();
			}
		});
		btnC.setBounds(126, 210, 91, 23);
		frame.getContentPane().add(btnC);

		JButton btnEgal = new JButton("=");
		btnEgal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// il faut que le deuxime nombre soit renseigné pour calculer
				if (nb2.length()!=0) {
					calculer();
					afficher(Double.toString(result));
				}
			}
		});
		btnEgal.setBounds(227, 210, 91, 23);
		frame.getContentPane().add(btnEgal);

		JButton btnDivision = new JButton("/");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoutOperateur("/");
			}
		});
		btnDivision.setBounds(343, 80, 50, 23);
		frame.getContentPane().add(btnDivision);

		JButton btnMultiplication = new JButton("x");
		btnMultiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoutOperateur("x");
			}
		});		
		btnMultiplication.setBounds(343, 120, 50, 23);
		frame.getContentPane().add(btnMultiplication);

		JButton btnMoins = new JButton("-");
		btnMoins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoutOperateur("-");
			}
		});			
		btnMoins.setBounds(343, 160, 50, 23);
		frame.getContentPane().add(btnMoins);

		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajoutOperateur("+");
			}
		});		
		btnPlus.setBounds(343, 210, 50, 23);
		frame.getContentPane().add(btnPlus);

	}
}
