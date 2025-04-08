/*
 * 
 * Given a binary tree, the task is to determine the diameter of the tree. 
   The diameter/width of a tree is defined as the number of edges on the longest path between any two nodes. 
 */
package javaDSA;

public class BinaryTreeDiameter {
    static int diameter;

    //Function to find the height of the tree (total height = total levels)
    static int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        diameter = Math.max(diameter, leftHeight+rightHeight);

        return Math.max(leftHeight, rightHeight)+1;
    }

    //function to find diameter of the tree
    //TC: O(n), SC: O(h)
    static int getDiameter(TreeNode root){
        if(root == null){
            return 0;
        }
        diameter = 0;

        findHeight(root);

        return diameter;

    }
    
    public static void main(String[] args) {
        //preordered tree in array
        int nodes[] = {1,2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.buildTree(nodes);
        /*
                    1
            2               3
        4       5               6
         */
        
        System.out.println("\nDiameter of the tree is: "+getDiameter(root));
    }
}

/*
 * Step by step approach:
    Initialize a variable diameter, which will store the diameter of the tree. (initially set to 0).
    Recursively traverse the binary tree. For each node, find the height of the left and right subtree. 
    Then compare the sum of (height of left subtree + height of right subtree) with the diameter variable. 
    If it is greater than diameter, then update the value of diameter.

    Time Complexity: O(n), where n is the number of nodes in tree.
    Auxiliary Space: O(h) due to recursive calls.
 */