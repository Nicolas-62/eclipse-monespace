
public class Abc {
	public static int[] changerValeur(int a, int b, int c) {
		int d;
		d = a;
		a = b;
		b = c;
		c = d;
		int[] tab = { a, b, c };
		return tab;
	}

	public static void main(String[] args) {
		int a = 2, b = 3, c = 4;
		int[] tab = changerValeur(a, b, c);

	}
}
