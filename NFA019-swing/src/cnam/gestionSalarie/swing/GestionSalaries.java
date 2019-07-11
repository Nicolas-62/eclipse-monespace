package cnam.gestionSalarie.swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionSalaries {

	private JFrame frame;
	private JTextField textField_Matricule;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private static JComboBox<String> comboBoxFonction;
	private JTextField textField_Telephone;
	private JTextField textField_DateNais;
	private JTextField textField_DateEmb;
	private JTextField textField_Salaire;
	private JTextField textField_Recherche;
	private List<Salarie> listSalarie = new ArrayList<Salarie>();
	private JList<Object> jlist = new JList<Object>();

//	private static String entete = "matricule\tnom\tprenom\tfonction\ttéléphone\tdate_nais\tdate_emb\tsalaire".replaceAll("\t", "    ");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionSalaries window = new GestionSalaries();
					window.frame.setVisible(true);
//					listSalarie.add(entete);
					System.out.println(comboBoxFonction.getSelectedItem().toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionSalaries() {
		initialize();
	}

	public void afficherSalarie(Salarie salarieListClic) {
		textField_Matricule.setText(salarieListClic.getMatricule());
		textField_Nom.setText(salarieListClic.getNom());
		textField_Prenom.setText(salarieListClic.getPrenom());
		comboBoxFonction.setSelectedItem(salarieListClic.getFonction());
		textField_Telephone.setText(salarieListClic.getTel());
		textField_DateNais.setText(salarieListClic.getDateNais());
		textField_DateEmb.setText(salarieListClic.getDateEmb());
		textField_Salaire.setText(salarieListClic.getSalaire());
	}

	public boolean verifChamps() {
		if (textField_Matricule.getText().length() == 0 || textField_Nom.getText().length() == 0
				|| textField_Prenom.getText().length() == 0
				|| comboBoxFonction.getSelectedItem().toString().length() == 0
				|| textField_Telephone.getText().length() == 0 || textField_DateNais.getText().length() == 0
				|| textField_DateEmb.getText().length() == 0 || textField_Salaire.getText().length() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public void ajouterSalarie() {
//		if(verifChamps){
			// ajout du salarie saisi à la liste
			listSalarie.add(new Salarie(textField_Matricule.getText(), textField_Nom.getText(), textField_Prenom.getText(),
					comboBoxFonction.getSelectedItem().toString(), textField_Telephone.getText(),
					textField_DateNais.getText(), textField_DateEmb.getText(), textField_Salaire.getText()));
			// mise à jour de la Jlist
			jlist.setListData(listSalarie.toArray());
//		}		
	}

	public void modifierSalarie(Salarie salarie) {
//		if(verifChamps){
			// ajout du salarie saisi à la liste
			salarie.setNom(textField_Matricule.getText());
			salarie.setPrenom(textField_Nom.getText());
			salarie.setFonction(comboBoxFonction.getSelectedItem().toString());
			salarie.setTel(textField_Telephone.getText());
			salarie.setDateNais(textField_DateNais.getText());
			salarie.setDateEmb(textField_DateEmb.getText());
			salarie.setSalaire(textField_Salaire.getText());
			// mise à jour de la Jlist
			
//		}			
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.setBounds(100, 100, 700, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// ENREGISTRER
		JButton enregistrer = new JButton("enregistrer");
		enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Flux.enregistrer(jlist);
			}
		});
		enregistrer.setBounds(333, 311, 91, 23);
		frame.getContentPane().add(enregistrer);
		
		// CHARGER
		JButton charger = new JButton("charger");
		charger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Flux.charger(jlist, listSalarie);
			}
		});
		charger.setBounds(434, 311, 91, 23);
		frame.getContentPane().add(charger);
		
		// AJOUTER
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterSalarie();
			}
		});

		btnAjouter.setBounds(60, 311, 177, 23);
		frame.getContentPane().add(btnAjouter);
		// MODIFIER
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// vérif si champ matricule saisi
				if(textField_Matricule.getText().length()!=0) {
					String matricule = textField_Matricule.getText();
					// vérif si ce salarié existe
					for(Salarie salarie : listSalarie) {
						// si il existe on met à jour ses infos et on sort de la boucle
						if(salarie.getMatricule().equals(matricule)) {
							modifierSalarie(salarie);
							// mise à jour de la Jlist
							jlist.setListData(listSalarie.toArray());
							break;
						}
					}
				}
			}
		});
		btnModifier.setBounds(60, 345, 177, 23);
		frame.getContentPane().add(btnModifier);
		// SUPPRIMER
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSupprimer.setBounds(60, 379, 177, 23);
		frame.getContentPane().add(btnSupprimer);
		// RECHERCHER
		JButton btnNewButton = new JButton("Rechercher");
		btnNewButton.setBounds(519, 437, 147, 23);
		frame.getContentPane().add(btnNewButton);

		// LISTE
		jlist = new JList<>();
		jlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Salarie salarieListClic = (Salarie) jlist.getModel().getElementAt(jlist.locationToIndex(e.getPoint()));
				afficherSalarie(salarieListClic);
			}
		});
		jlist.setBounds(333, 60, 331, 229);
		frame.getContentPane().add(jlist);

		JLabel lblLaGestionDes = new JLabel("La gestion des salariés");
		lblLaGestionDes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLaGestionDes.setBounds(20, 0, 177, 25);
		frame.getContentPane().add(lblLaGestionDes);

		JLabel lblMatricule = new JLabel("Matricule :");
		lblMatricule.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricule.setBounds(20, 60, 131, 19);
		frame.getContentPane().add(lblMatricule);

		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNom.setBounds(20, 90, 131, 14);
		frame.getContentPane().add(lblNom);

		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrenom.setBounds(20, 120, 131, 14);
		frame.getContentPane().add(lblPrenom);

		JLabel lblFonction = new JLabel("Fonction :");
		lblFonction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFonction.setBounds(20, 150, 131, 14);
		frame.getContentPane().add(lblFonction);

		JLabel lblTlphone = new JLabel("Téléphone :");
		lblTlphone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTlphone.setBounds(20, 180, 131, 14);
		frame.getContentPane().add(lblTlphone);

		JLabel lblDateDeNaissance = new JLabel("Date de naissance :");
		lblDateDeNaissance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateDeNaissance.setBounds(20, 210, 131, 14);
		frame.getContentPane().add(lblDateDeNaissance);

		JLabel lblDateDembauche = new JLabel("Date d'embauche :");
		lblDateDembauche.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateDembauche.setBounds(20, 240, 131, 14);
		frame.getContentPane().add(lblDateDembauche);

		JLabel lblSalaire = new JLabel("Salaire :");
		lblSalaire.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalaire.setBounds(20, 270, 131, 14);
		frame.getContentPane().add(lblSalaire);

		textField_Matricule = new JTextField();
		textField_Matricule.setBounds(161, 61, 156, 20);
		frame.getContentPane().add(textField_Matricule);
		textField_Matricule.setColumns(10);

		textField_Nom = new JTextField();
		textField_Nom.setColumns(10);
		textField_Nom.setBounds(161, 89, 156, 20);
		frame.getContentPane().add(textField_Nom);

		textField_Prenom = new JTextField();
		textField_Prenom.setColumns(10);
		textField_Prenom.setBounds(161, 119, 156, 20);
		frame.getContentPane().add(textField_Prenom);

		comboBoxFonction = new JComboBox();
		comboBoxFonction.setModel(new DefaultComboBoxModel(new String[] { "Ingénieur informaticien",
				"Analyste programmeur", "Technicien développeur", "Escroc" }));
		comboBoxFonction.setBounds(161, 148, 156, 22);
		frame.getContentPane().add(comboBoxFonction);

		textField_Telephone = new JTextField();
		textField_Telephone.setColumns(10);
		textField_Telephone.setBounds(161, 179, 156, 20);
		frame.getContentPane().add(textField_Telephone);

		textField_DateNais = new JTextField();
		textField_DateNais.setColumns(10);
		textField_DateNais.setBounds(161, 209, 156, 20);
		frame.getContentPane().add(textField_DateNais);

		textField_DateEmb = new JTextField();
		textField_DateEmb.setColumns(10);
		textField_DateEmb.setBounds(161, 239, 156, 20);
		frame.getContentPane().add(textField_DateEmb);

		textField_Salaire = new JTextField();
		textField_Salaire.setColumns(10);
		textField_Salaire.setBounds(161, 269, 156, 20);
		frame.getContentPane().add(textField_Salaire);

		JLabel lblMotCl = new JLabel("Mot clé :");
		lblMotCl.setBounds(10, 420, 48, 14);
		frame.getContentPane().add(lblMotCl);

		textField_Recherche = new JTextField();
		textField_Recherche.setBounds(10, 438, 499, 20);
		frame.getContentPane().add(textField_Recherche);
		textField_Recherche.setColumns(10);

		JLabel lblListeDesSalaries = new JLabel("Liste des salaries");
		lblListeDesSalaries.setBounds(333, 40, 400, 14);
		frame.getContentPane().add(lblListeDesSalaries);
	}
}
