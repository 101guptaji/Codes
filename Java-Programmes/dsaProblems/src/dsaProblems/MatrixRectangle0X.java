/*
 * Write a code which inputs two numbers n and m and creates a matrix of size n x m (n rows and m columns) in which every elements is either X or 0. The Xs and 0s must be filled alternatively, the matrix should have outermost rectangle of Xs, then a rectangle of 0s, then a rectangle of Xs, and so on.

    Examples:  
    Input: n = 3, m = 3
    Output: Following matrix 
    X X X
    X 0 X
    X X X

    Input: 4, 5
    Output: Following matrix
    X X X X X
    X 0 0 0 X
    X 0 0 0 X
    X X X X X

    Input:  5, 5
    Output: Following matrix
    X X X X X
    X 0 0 0 X
    X 0 X 0 X
    X 0 0 0 X
    X X X X X

    Input:  6, 7
    Output: Following matrix
    X X X X X X X
    X 0 0 0 0 0 X
    X 0 X X X 0 X
    X 0 X X X 0 X
    X 0 0 0 0 0 X
    X X X X X X X 
 */
package dsaProblems;

import java.util.*;;

public class MatrixRectangle0X {
    
    //function to create matrix of alterative 'X' and '0' following spiral form
    public static ArrayList<ArrayList<Character>> constructMatrix(int n, int m) {        
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();        
        for(int i = 0; i < n; i++) {            
            ArrayList<Character> row = new ArrayList<>(Collections.nCopies(m, 'X'));            
            matrix.add(row);        
        }

        /* 
        top - first row index
        bottom - last row index
        left - first column index
        right - last column index
        */
       int top = 0, bottom = n - 1, left = 0, right = m - 1;        
       char fillChar = 'X';

       while(top <= bottom && left <= right) {    

            // Fill top row            
            for(int i = left; i <= right; i++) {                
                matrix.get(top).set(i, fillChar);            
            }            
            top++; // Move down the top boundary

            // Fill right column            
            for(int i = top; i <= bottom; i++) {                
                matrix.get(i).set(right, fillChar);            
            }            
            right--; // Move left the right boundary

            // Fill bottom row            
            if(top <= bottom) {                
                for(int i = right; i >= left; i--) {                    
                    matrix.get(bottom).set(i, fillChar);                
                }                
                bottom--; // Move up the bottom boundary            
            }

            // Fill left column            
            if(left <= right) {                
                for(int i = bottom; i >= top; i--) {                    
                    matrix.get(i).set(left, fillChar);                
                }                
                left++; // Move right the left boundary            
            }

            // Alternate between 'X' and '0' for each layer            
            fillChar = (fillChar == 'X') ? '0' : 'X';        
        }

        return matrix;    
    }

   // Helper function to print the matrix    
   public static void printArrayMatrix(ArrayList<ArrayList<Character>> matrix) {        
        for(ArrayList<Character> row : matrix) {            
            for(Character ch : row) {                
                System.out.print(ch + " ");            
            }            
            System.out.println();        
        }    
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of matrix (n*m)");
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Character>> matrix =  constructMatrix(n, m);
        printArrayMatrix(matrix);

        sc.close();
    }
}
