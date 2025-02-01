/*
 * The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. 
 * Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

	Given an integer n, find all distinct solutions to the n-queens puzzle.
	You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. 
	In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
 * 
 * Input: n = 1
	Output: [1]
	Explaination: Only one queen can be placed in the single cell available.

	Input: n = 4
	Output: [[2 4 1 3 ] [3 1 4 2 ]]
	Explaination: There are 2 possible solutions for n = 4.

	Input: n = 2
	Output: []
	Explaination: There are no possible solutions for n = 2.
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
	
	public static void saveBoard(char[][] board, List<List<String>> ans) {
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
		ans.add(res);
	}
	
	public static void helper(char[][] board, List<List<String>> ans, int col) {
		if(col == board.length) {
			saveBoard(board, ans);
			return;
		}
		for(int row=0;row<board.length;row++) {
			if(isSafe(row,col,board)) {
				board[row][col] = 'Q';
				helper(board, ans, col+1);
				board[row][col] = '.';
			}
		}
	}
	
	public static List<List<String>> getQueensPos(int n){
		List<List<String>> ans = new ArrayList<>();
		char[][] board = new char[n][n];
		
		helper(board, ans, 0);
		
		return ans;
	}
	
	public static void main(String[] args) {
		int n =4;
		List<List<String>> queensPos = getQueensPos(n);
		for(int i=0;i<queensPos.size();i++) {
			System.out.println(queensPos.get(i));
		}
	}

}
