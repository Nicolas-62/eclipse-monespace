import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int lightX = 5; // the X position of the light of power
		int lightY = 7; // the Y position of the light of power
		int initialTX = 30; // Thor's starting X position
		int initialTY = 40; // Thor's starting Y position

		// game loop
		while (true) {
// The remaining amount of turns Thor can move. Do not remove this line.
			if (initialTX > lightX) {
				initialTX -= 1;
			} else if (initialTX < lightX) {
				initialTX += 1;
			}
			if (initialTY > lightY) {
				initialTY -= 1;
			} else if (initialTY < lightY) {
				initialTY += 1;
			}
			if (initialTY == lightY && initialTX == lightX) {
				break;
			}
		}
		System.out.println(initialTY+" "+initialTX);
	}

}
