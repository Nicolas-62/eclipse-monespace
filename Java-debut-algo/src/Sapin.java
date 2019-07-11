import java.util.Scanner;

public class Sapin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lignes;
		Scanner sc = new Scanner(System.in);
		System.out.println("Combien de lignes ?");
		lignes = sc.nextInt();

		for (int i = 1; i <= lignes; i++) {
			for (int j = 1; j <= lignes - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= (i * 2) - 1; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

}
