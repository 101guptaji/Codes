/*
 * Binary Search Tree (BST):
    -Each node has atmost 2 child  nodes;
    -Left subtree nodes value are always less than root.
    -Right subtree nodes value are always greater than root.
    -Inorder traversal of BST gives a sorted sequence.
    -Insert Time COmplexity: O(H), where H = height of the tree = log(n), where n = No. of nodes.

    Deletion of a node in BST:
    - case 1: deletion node has no child i.e leaf node
        -> Delete the node and return null to parent
    - case 2: one child
        -> Delete the node and replace with child node
    - case 3: two child
        -> Replace the deletion value with the inorder successor.
        -> Delete the node for inorder successor.
        -> Inorder successor node is next node after deletion node in the inorder traversal. 
 */
package javaDSA;

import java.util.ArrayList;

public class BST {

    //function to insert nodes in BST
    //Time COmplexity: O(H), where H = height of the tree
    TreeNode insert(TreeNode root, int val){
        if(root == null){
            root = new TreeNode(val);
            return root;
        }

        if(root.data > val){
            //left subtree
            root.left = insert(root.left,val);
        }
        else{
            //right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    //function to print  BST nodes in sorted order
    void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    //function to search for an element in the BST
    //TC: O(H) = O(log n)
    boolean search(TreeNode root, int ele){
        if(root == null){
            return false;
        }

        if(root.data == ele){ //element found
            return true;
        }
        else if(root.data > ele){ //search in left subtree
            return search(root.left, ele);
        }
        else{ //search in right subtree
            return search(root.right, ele);
        }
    }

    //function to delete a node from BST
    TreeNode delete(TreeNode root, int key){
        if(root == null){
            return null;
        }

        if(root.data > key){
            root.left = delete(root.left, key);
        }
        else if(root.data < key){
            root.right = delete(root.right, key);
        }
        else{ //root.data = key

            //case 1: leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            
            //case 2: node with one child
            if(root.left == null){
                return delete(root.right, key);
            }
            else if(root.right == null){
                return delete(root.left, key);
            }

            //case 3: node with 2 childs
            TreeNode nextIS = inorderSuccessor(root.right);
            root.data = nextIS.data;
            root.right = delete(root.right, nextIS.data);
        }
        return root;
    }

    //function to find next node after root in inorder traversal
    TreeNode inorderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    //funtion to print nodes from node X to node Y in tthe tree (inorder)
    void printInRange(TreeNode root, int X, int Y){
        if(root == null){
            return;
        }

        if(root.data >= X && root.data <= Y){ //required nodes lie from left subtree to right subtree including root
            printInRange(root.left, X, Y);
            System.out.print(root.data+" ");
            printInRange(root.right, X, Y);
        }
        else  if(root.data >= Y){ //all required nodes are in left subtree
            printInRange(root.left, X, Y);
        }
        else{ //all required nodes are in right subtree
            printInRange(root.right, X, Y);
        }
    }

    //function to print all paths of tree from from root node to a leaf node
    void printRoot2Leaf(TreeNode root, ArrayList<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);
        //if reached leaf node, print the path
        if(root.left == null && root.right == null){
            //print path
            System.out.print("Path: "+path.get(0));
            for(int i=1;i<path.size();i++){
                System.out.print(" -> "+path.get(i));
            }
            System.out.println();
        }
        else{ //non-leaf node
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.removeLast();
    }

    public static void main(String[] args) {
        int values[] = {5,1,3,2,4,6,7};
        BST bst = new BST();
        TreeNode root = null;
        
        System.out.println("Printing nodes of BST in sorted order:");
        for(int i=0;i<values.length;i++){
            root = bst.insert(root, values[i]);
        }
        /*
                    5
            1               6
                3              7
            2       4
         */
        
        bst.inOrder(root);
        System.out.println();

        int ele = 5;
        System.out.print("\nIs "+ele+" available in the tree? ");
        if(bst.search(root, ele)){
            System.out.println("Yes");
            bst.delete(root, ele);
            System.out.println("\nBST after deleting node "+ele);
            bst.inOrder(root);
            System.out.println();
        }
        else{
            System.out.println("No");
        }
        
        System.out.println("\nPrinting all nodes from 3 to 7");
        bst.printInRange(root, 3, 7);
       
        System.out.println("\nPrinting all paths from root to a leaf node");
        bst.printRoot2Leaf(root, new ArrayList<Integer>());
    }
}
