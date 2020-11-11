/**
 * The class for the board object which acts like the connect 4 playing board.
 *
 * @author  Jonathan Gai
 * @version 1.0
 * @since   2020-11-10
 */

public class Board {

	int[][] board = new int[6][7];

	/**
	 * The add method that addes a disc belowing to the player specified to the row.
	 *
	 * @param col The column that the disc is being dropping into.
	 * @param player The player ID (positive integer).
	 *
	 * @return -1 if the addition is not successful.
	 *         1  if the addition is successful.
	 */
	public int add(int col, int player) {
		if (col > 6 || col < 0) {
			return -1;
		}
		for (int i=0; i<6; i++) {
			if (board[i][col] == 0) {
				board[i][col] = player;
				return 0;
			}
		}
		return -1;
	}

	/**
	 * The print method that prints the board state.
	 */
	public void print() {
		System.out.println("\u001B[31m1 2 3 4 5 6 7\n-------------\u001B[0m");
		for (int i=5; i>=0; i--) {
			for (int j=0; j<6; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print(board[i][6]);
			System.out.println();
		}
	}

	/**
	 * The method that determines if there is a winner according to the board state.
	 *
	 * @return -1 if there is not winner.
	 *         Player ID if there is a winner.
	 */
	public int winner() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<7; j++) {
				if (board[i][j] != 0 && board[i][j] == board[i+1][j] && board[i+1][j] == board[i+2][j] && board[i+2][j] == board[i+3][j]) {
					return board[i][j];
				}
			}
		}
		for (int i=0; i<6; i++) {
			for (int j=0; j<4; j++) {
				if (board[i][j] != 0 && board[i][j] == board[i][j+1] && board[i][j+1] == board[i][j+2] && board[i][j+2] == board[i][j+3]) {
					return board[i][j];
				}
			}
		}
		for (int i=0; i<3; i++) {
			for (int j=0; j<4; j++) {
				if (board[i][j] != 0 && board[i][j] == board[i+1][j+1] && board[i+1][j+1] == board[i+2][j+2] && board[i+2][j+2] == board[i+3][j+3]) {
					return board[i][j];
				}
			}
		}
		for (int i=5; i>2; i--) {
			for (int j=0; j<4; j++) {
				if (board[i][j] != 0 && board[i][j] == board[i-1][j+1] && board[i-1][j+1] == board[i-2][j+2] && board[i-2][j+2] == board[i-3][j+3]) {
					return board[i][j];
				}
			}
		}
		return -1;
	}
}
