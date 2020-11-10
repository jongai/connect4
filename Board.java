public class Board {

	int[][] board = new int[6][7];

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
