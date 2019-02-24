import fr.perso.mesclasses.*;

public class Test_1 {

	public static void main(String[] args) {
		
		String A = "423";
		String B = "12";
		
		String C = A + B;
		System.out.println("C = "+C);
		System.out.println("entrer un chiffre : ");
		double chiffre = Clavier.readDouble();
		System.out.println(chiffre);

	}

}
