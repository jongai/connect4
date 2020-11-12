import java.util.Scanner;

/**
 * The main class that contains the gameplay mechanics for connect 4 game.
 *
 * @author  Jonathan Gai
 * @version 1.0
 * @since   2020-11-10
 */

public class Main {
	/**
	 * The main method that uses Board class to play connect 4.
	 *
	 * @param args Not expected.
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String c = "y";
		int player_count = 2;
		while(c.toLowerCase().equals("y")) {
			Board b = new Board();
			int player = 0;
			System.out.print("\033[H\033[2J");
			System.out.flush();
			b.print();
			while (b.winner() == -1) {
				System.out.print("Player " + (player + 1) + ": ");
				while(b.add(scan.nextInt() - 1, player + 1) == -1) {
					System.out.println("Not Valid");
					System.out.print("Player " + (player + 1) + ": ");
				}
				System.out.print("\033[H\033[2J");
				System.out.flush();
				b.print();
				player = (player + 1) % player_count;
			}
			if (b.winner() != -2) {
				System.out.println(b.winner() + " wins");
			}
			else {
				System.out.println("Draw");
			}
			System.out.println("Continue to play? (y/n)");
			scan.nextLine();
			c = scan.nextLine();
		}
	}
}
