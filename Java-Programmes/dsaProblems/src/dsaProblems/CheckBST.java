/*
 * Given the root of a binary tree. Check whether it is a BST or not.
    Note: We are considering that BSTs can not contain duplicate Nodes.
    A BST is defined as follows:
        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.

    Input: root = [2, 1, 3, N, N, N, 5]
    Output: true 
    Explanation: The left subtree of every node contains smaller keys and right subtree of every node contains greater keys. Hence, the tree is a BST.
    
    Input: root = [2, N, 7, N, 6, N, 9] 
    Output: false 
    Explanation: Since the node to the right of node with key 7 has lesser key value, hence it is not a valid BST.
    
    Input: root = [10, 5, 20, N, N, 9, 25]
    Output: false
    Explanation: The node with key 9 present in the right subtree has lesser key value than root node.
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

public class CheckBST {
    static boolean isBSTUtil(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        
        if(root.data<=min || root.data>=max){
            return false;
        }
        
        return isBSTUtil(root.left, min, root.data) 
            && isBSTUtil(root.right, root.data, max);
    }
    
    // Function to check whether a Binary Tree is BST or not.
    static boolean isBST(TreeNode root) {
        // code here.
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        
        return isBSTUtil(root, min, max);
    }

    // function to build tree from level order array
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            TreeNode currTreeNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currTreeNode.left = new TreeNode(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currTreeNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currTreeNode.right = new TreeNode(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currTreeNode.right);
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
        System.out.println("Enter tree data or N for null");
        String s = br.readLine();
        TreeNode root = buildTree(s);
        if (isBST(root))
            System.out.println("true");
        else
            System.out.println("false");
    }

}