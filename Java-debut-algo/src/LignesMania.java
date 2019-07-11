
public class LignesMania {

	public static int testModif(int val) {
		val = val + 1;
		return val; // val a changé
	}

	public static void main(String args[]) {
		int k = 10;
		System.out.println("k = " + testModif(k)); // k n’a pas changé
	}
}
