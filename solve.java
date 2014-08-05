package leetcode;

public class solve {
	public static void solve(char[][] board) {

		// 1. scan the char box by point. check whether this point is enclosed
		// by 'X' rowise.
		// 2. Check whether this point is enclosed by 'X' collomwise.
		// 3. If so, flip this point to 'X', otherwise go to next point.
		// Note: There is no need to care about boundary nodes.
		if (board.length == 0 || board[0].length == 0) {
			return;
		}
		char bigO = 'O';
		for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[0].length - 1; j++) {
				if (board[i][j] == bigO && hasBound(board, i, j) == true) {
					board[i][j] = 'X';
				}
			}
		}
	}

	public static boolean hasBound(char[][] board, int i, int j) {

		char bigX = 'X';
		boolean result1 = false;
		boolean result2 = false;
		boolean result3 = false;
		boolean result4 = false;
		int m = 0, n = board.length - 1;
		while (m <= i && i <= n) {
			if (board[m][j] != bigX) {
				m++;
			} else if (board[m][j] == bigX) {
				result1 = true;
			}
			if (board[n][j] != bigX) {
				n--;
			} else if (board[n][j] == bigX) {
				result2 = true;
			}
			if (result1 && result2 == true) {
				result3 = true;
				break;
			}
		}
		m = 0;
		n = board[0].length - 1;
		result1 = false;
		result2 = false;
		while (m <= j && j <= n) {
			if (board[i][m] != bigX) {
				m++;
			} else if (board[i][m] == bigX) {
				result1 = true;
			}
			if (board[i][n] != bigX) {
				n--;
			} else if (board[i][n] == bigX) {
				result2 = true;
			}
			if (result1 && result2 == true) {
				result4 = true;
				break;
			}
		}
		return result3 && result4;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board[][] = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
		solve.solve(board);
		
	} 
}
