/*
 * Given: n*n chess-board and n queens.
 * Print all solutions where all queens are safe;
 * 
 */
package dsaProblems;
import java.util.*;

public class NQueensProblem {
	public static boolean isSafe(int row, int col, char[][] board) {
		int n = board.length;
		//horizontal
		for(int c=0;c<n;c++) {
			if(board[row][c] == 'Q')
				return false;
		}
		//vertical
		for(int r=0;r<n;r++) {
			if(board[r][col] == 'Q')
				return false;
		}
		//upper left
		//int r = row;
		for(int r=row, c=col;r>=0 && c>=0;r--,c--) {
			if(board[r][c] == 'Q')
				return false;
		}
		//upper right
		for(int r=row, c=col;r>=0 && c<n;r--,c++) {
			if(board[r][c] == 'Q')
				return false;
		}
		//lower left
		for(int r=row, c=col;r<n && c>=0;r++,c--) {
			if(board[r][c] == 'Q')
				return false;
		}
		//lower right
		for(int r=row, c=col;r<n && c<n;r++,c++) {
			if(board[r][c] == 'Q')
				return false;
		}
		
		return true;
	}
	
	public static void saveBoard(char[][] board, List<List<String>> allBoard) {
		List<String> res = new ArrayList<String>();
		for(int i=0;i<board.length;i++) {
			String row = "";
			for(int j=0;j<board.length;j++) {
				if(board[i][j] == 'Q')
					row += "Q";
				else
					row += ".";
			}
			res.add(row);
		}
		allBoard.add(res);
	}
	
	public static void helper(char[][] board, List<List<String>> allBoard, int col) {
		if(col == board.length) {
			saveBoard(board, allBoard);
			return;
		}
		for(int row=0;row<board.length;row++) {
			if(isSafe(row,col,board)) {
				board[row][col] = 'Q';
				helper(board, allBoard, col+1);
				board[row][col] = '.';
			}
		}
	}
	
	public static List<List<String>> getQueensPos(int n){
		List<List<String>> allBoard = new ArrayList<>();
		char[][] board = new char[n][n];
		
		helper(board, allBoard, 0);
		
		return allBoard;
	}
	
	public static void main(String[] args) {
		int n =4;
		List<List<String>> queensPos = getQueensPos(n);
		for(int i=0;i<queensPos.size();i++) {
			System.out.println(queensPos.get(i));
		}
	}

}