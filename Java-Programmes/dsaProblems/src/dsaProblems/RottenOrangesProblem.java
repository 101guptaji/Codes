/*
 * 994. Rotting Oranges (type: Medium):
    You are given an m x n grid where each cell can have one of three values:
    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.
    Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

    Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

    Example 1:
    Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
    Output: 4

    Example 2:
    Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
    Output: -1
    Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
    
    Example 3:
    Input: grid = [[0,2]]
    Output: 0
    Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
    
    Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 10
    grid[i][j] is 0, 1, or 2.
 */
package dsaProblems;

import java.util.*;

public class RottenOrangesProblem {

    static class Orange{
        int row, col, time;

        Orange(int r, int c, int t){
            row = r;
            col = c;
            time = t;
        }
    }

    public static int findRottenTime(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;

        int fresh = 0;
        Queue<Orange> queue = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 1){
                    fresh++;
                }
                else  if(arr[i][j] == 2){
                    queue.add(new Orange(i, j, 0));
                    arr[i][j] = 0;
                }
            }
        }

        if(queue.isEmpty() && fresh == 0){
            return 0;
        }

        //BFS
        int maxTime = 0;
        int rowDiff[] = {-1,1,0,0};
        int colDiff[] = {0,0,-1,1};

        while(!queue.isEmpty()){
            Orange curr = queue.remove();
            maxTime = Math.max(maxTime, curr.time);

            for(int i=0;i<rowDiff.length;i++){
                int adjRow = curr.row+rowDiff[i];
                int adjCol = curr.col+colDiff[i];

                if(adjRow>=0 && adjRow<m && adjCol>=0 && adjCol<n && arr[adjRow][adjCol] == 1){
                        queue.add(new Orange(adjRow, adjCol, curr.time+1));

                        fresh--;
                        arr[adjRow][adjCol] = 0;
                }
            }
        }

        if(fresh != 0){
            return -1;
        }

        return maxTime;
    }
    
    public static void main(String[] args) {
        int grid[][]= {{2,0,1}}; //{{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(findRottenTime(grid));
    }
}
