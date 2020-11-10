import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String c = "y";
		int player_count = 3;
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
			System.out.println(b.winner() + " wins");
			System.out.println("Continue to play? (y/n)");
			scan.nextLine();
			c = scan.nextLine();
		}
	}
}
