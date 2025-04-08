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
	// Time Complexity: O(n!*n), n! for generating all permutations and O(n) for validation of each permutation.
	// public static boolean isSafe(ArrayList<Integer> board, int row, int col) {
	// 	for (int i = 0; i < board.size(); i++) {
	// 		int oldRow = board.get(i);
	// 		int oldCol = i + 1;
	// 		if (oldRow == row || Math.abs(row - oldRow) == Math.abs(col - oldCol)) {
	// 			return false;
	// 		}
	// 	}

	// 	return true;
	// }

	public static void helper(int col, int n, ArrayList<Integer> board, ArrayList<ArrayList<Integer>> ans,
			boolean[] visited, boolean[] diag1, boolean[] diag2) {
		if (col > n) {
			ans.add(new ArrayList<>(board));
			return;
		}

		for (int row = 1; row <= n; row++) {
			if (!visited[row] && !diag1[row + col] && !diag2[row - col + n]) {
				visited[row] = diag1[row + col] = diag2[row - col + n] = true;

				board.add(row);
				helper(col + 1, n, board, ans, visited, diag1, diag2);
				board.remove(board.size() - 1);

				visited[row] = diag1[row + col] = diag2[row - col + n] = false;
			}
		}
	}

	public static ArrayList<ArrayList<Integer>> getQueensPos(int n) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> board = new ArrayList<>();

		boolean visited[] = new boolean[n + 1];

		// Major diagonals (row + col) and Minor diagonals (row - col + n)
		boolean[] diag1 = new boolean[2 * n + 1];
		boolean[] diag2 = new boolean[2 * n + 1];

		helper(1, n, board, ans, visited, diag1, diag2);

		return ans;
	}

	public static void printBoard(ArrayList<ArrayList<Integer>> ans) {
		for (int i = 0; i < ans.size(); i++) {
			List<String> res = new ArrayList<String>();
			for (int j = 0; j < ans.get(i).size(); j++) {
				String row = "";
				int col = ans.get(i).get(j);
				for (int k = 1; k <= ans.get(i).size(); k++) {
					if (k == col) {
						row += 'Q';
					} else {
						row += '.';
					}
				}
				res.add(row);
			}
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		int n = 4;
		ArrayList<ArrayList<Integer>> queensPos = getQueensPos(n);
		System.out.println(queensPos);

		// printBoard(queensPos);
	}

}


/*
 * Approach:  Using Backtracking with Pruning
 * 	Start from the first column and try placing a queen in each row.
	Keep arrays to track which rows are already occupied. Similarly, for tracking major and minor diagonals are already occupied.
	If a queen placement conflicts with existing queens, skip that row and backtrack the queen to try the next possible row (Prune and backtrack during conflict).

	Time complexity : O(n!) For generating all permutations.
	Auxiliary Space : O(n)
 */