/*
 * Given an incomplete Sudoku configuration in terms of a 9x9  2-D char square matrix, board[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.

	A sudoku solution must satisfy all of the following rules:
		Each of the digits 1-9 must occur exactly once in each row.
		Each of the digits 1-9 must occur exactly once in each column.
		Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
		
	Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and cannot be changed.
 */
package dsaProblems;

public class SudokuSolver {
	static boolean isSafe(char[][] board, int row, int col, char value) {
		// sub-grid starting row and column
		int rowSrc = 3 * (row / 3);
		int colSrc = 3 * (col / 3);
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == value || board[i][col] == value || board[rowSrc + i / 3][colSrc + i % 3] == value) {
				return false;
			}
		}

		return true;
	}

	public static boolean solve(char[][] board, int row, int col) {
		if (col == board.length) {
			row = row + 1;
			col = 0;
		}

		if (row == board.length) {
			return true;
		}

		if (board[row][col] != '0') {
			return solve(board, row, col + 1);
		}

		// fill empty place
		for (int i = 1; i <= 9; i++) {
			if (isSafe(board, row, col, (char) (i + '0'))) {
				board[row][col] = (char) (i + '0');
				if (solve(board, row, col + 1))
					return true;
				else
					board[row][col] = '0';
			}
		}

		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '0', '0', '7', '0', '0', '0', '0' },
				{ '6', '0', '0', '1', '9', '5', '0', '0', '0' },
				{ '0', '9', '8', '0', '0', '0', '0', '6', '0' },
				{ '8', '0', '0', '0', '6', '0', '0', '0', '3' },
				{ '4', '0', '0', '8', '0', '3', '0', '0', '1' },
				{ '7', '0', '0', '0', '2', '0', '0', '0', '6' },
				{ '0', '6', '0', '0', '0', '0', '2', '8', '0' },
				{ '0', '0', '0', '4', '1', '9', '0', '0', '5' },
				{ '0', '0', '0', '0', '8', '0', '0', '7', '9' } };
		solve(board, 0, 0);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
