/*
 * -Diameter = No. of nodes in the longest path between 2 nodes
    -Diameter of a tree = No. of nodes in the longest path between leftmost node and rightmost node

    https://www.youtube.com/watch?v=-DzowlcaUmE
 */
package javaDSA;

public class BinaryTreeDiameter {
    //Function to find the height of the tree (total height = total levels)
    static int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return Math.max(leftHeight, rightHeight)+1;
    }

    //function to find diameter of the tree
    //TC: O(n^2)
    static int getDiameter(TreeNode root){
        if(root == null){
            return 0;
        }
        int diam1 = getDiameter(root.left);
        int diam2 = getDiameter(root.right);
        int diam3 = findHeight(root.left)+findHeight(root.right)+1;

        return Math.max(Math.max(diam1, diam2), diam3);

    }

    //Approach 2:
    static class TreeInfo{
        int height, diameter;

        TreeInfo(int ht, int dm){
            height = ht;
            diameter = dm;
        }
    }
    //function to find diameter of the tree
    //TC: O(n)
    static TreeInfo getDiameter2(TreeNode root){
        if(root == null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left = getDiameter2(root.left);
        TreeInfo right = getDiameter2(root.right);

        int myHeight = Math.max(left.height, right.height)+1;

        int diam1 = left.diameter;
        int diam2 = right.diameter;
        int diam3 = left.height+right.height+1;

        int myDiameter = Math.max(Math.max(diam1, diam2), diam3);

        return new TreeInfo(myHeight, myDiameter);

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

        //System.out.println("\nDiameter of the tree is: "+getDiameter(root));

        System.out.println("\nDiameter of the tree is: "+getDiameter2(root).diameter);
    }
}
