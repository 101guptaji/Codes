/*
 * Given a binary tree, where every node value is a number. Find the sum of all the numbers that are formed from root to leaf paths. The formation of the numbers would be like 10*parent + current (see the examples for more clarification).

    Examples:
    Input : 6 3 5 2 5 N 4 N N 7 4
    Output: 13997
    Explanation : There are 4 leaves, resulting in leaf path of 632, 6357, 6354, 654 sums to 13997.

    Input : 10 20 30 40 60 N N
    Output : 2630
    Explanation: There are 3 leaves, resulting in leaf path of 1240, 1260, 130 sums to 2630.

    Input : 1 2 N
            1
            /
            2                    
    Output : 12
    Explanation: There is 1 leaf, resulting in leaf path of 12.
 */
package dsaProblems;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}


public class RootToLeafSum {
    static TreeNode buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (!queue.isEmpty() && i < ip.length) {

            // Get and remove the front of the queue
            TreeNode currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new TreeNode(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new TreeNode(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(TreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        TreeNode root = buildTree(s);
        printInorder(root);
        System.out.println();

        System.out.println("SUM: "+treePathsSum(root));
        
    }

    public static int preOrder(TreeNode root, int num){
        if(root == null){
            return 0;
        }
        
        num = 10*num+root.data;
        
        //leaf node
        if(root.left == null && root.right == null){
            return num;
        }
        
        return preOrder(root.left, num) + preOrder(root.right, num);
    }
    
    public static int treePathsSum(TreeNode root) {
        // add code here.
        return preOrder(root, 0);
    }
}
