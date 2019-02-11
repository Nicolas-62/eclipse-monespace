import java.util.Scanner;

public class TriangleRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ligne;
		Scanner sc = new Scanner(System.in);
		System.out.println("Combien de lignes ?");
		ligne = sc.nextInt();

		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.print('\n');
		}
	}

}
