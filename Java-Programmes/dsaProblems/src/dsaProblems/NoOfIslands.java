/*
 * Find the number of islands
    Difficulty: Medium
    Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of '0's (Water) and '1's(Land). Find the number of islands.

    Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

    Examples:
    Input: grid = [[0,1],[1,0],[1,1],[1,0]]
    Output: 1

    Input: grid = [[0,1,1,1,0,0,0],[0,0,1,1,0,1,0]]
    Output: 2
    
    Expected Time Complexity: O(n*m)
    Expected Space Complexity: O(n*m)

    Constraints:
    1 ≤ n, m ≤ 500
    grid[i][j] = {'0', '1'}
 */
package dsaProblems;

public class NoOfIslands {

    //dfs traversal in all 8 direction
    static void dfs(char[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m)
            return;
        if(grid[i][j]!='1')
            return;

        grid[i][j] = '2';

        dfs(grid,i-1,j-1); //top left
        dfs(grid,i-1,j); //top
        dfs(grid,i-1,j+1); //top right
        dfs(grid,i,j-1); //left
        dfs(grid,i,j+1); //right
        dfs(grid,i+1,j-1); //bottom left
        dfs(grid,i+1,j); //bottom
        dfs(grid,i+1,j+1); //bottom right
    }
    
    // Function to find the number of islands.
    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;
        
        //traversing all cells
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    //check for all connected lands
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char grid[][] = {{'0','1','1','1','0','0','0'},{'0','0','1','1','0','1','0'}};
            
        int ans = numIslands(grid);
        System.out.println("No. of Islands= "+ans);
    }
}
