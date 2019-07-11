package com.testsEntretien.java;

// Enonce exercice sur les noeuds
public class Node {
	
	Node left, right;
	int val;
	
	// il n'y avait pas de constructeurs, je les ai ajouté pour contruire un arbre d'essai
	Node(){}
	Node(int val){
		this.val=val;
	}
	Node(int val, Node left, Node right){
		this.left=left;
		this.right=right;
		this.val=val;
	}
	Node find(int val) {	
		Node node = new Node();
		return node;
	}
	@Override
	// Méthode que j'ai rajouté pour afficher le noeud
	public String toString() {
		return String.format("Node [val=%s]", val);
	}
	// test
	/* un noeud a au plus deux enfants, celui de gauche (left) est plus petit que celui de droite (right)
	 * un noeud n'a qu'un parent, le noeud racine n'a pas de parents
	 * Implémenter la méthode fin(int val) qui retourne le noeud 
	 * ayant pour valeur val ou null si aucun noeud ne possède cette valeur.
	 * Vous devrez optimiser l'usage de la RAM
	 */
	public static void main(String[] args) {
		/* premier arbre fournit :
		 * un deuxième arbre était fournit avec un million de valeur, 
		 * il fallait retrouver le noeud ayant pour valeur 0 soit celui tout en bas à gauche de l'arbre
		 * 
		 */
		// Construction arbre de noeuds
		/*				8
					  /   \
					 6      13
				   /  \    /  \
			      4    7  10   15
			     / \     / \   / \
			    2   5   9  11 14 17
	     */
		Node n = new Node(8, 
					new Node(6, 
							new Node(4, 
									new Node(2), 
									new Node(5)), 
							new Node(7)), 
					new Node(13, 
							new Node(10, 
									new Node(9), 
									new Node(11)), 
							new Node(15, 
									new Node(14),
									new Node(17))));
		// test recherche
		System.out.println(n.find(14));
	}

}
