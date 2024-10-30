/*
 * Tree:
    -a heirachical data structure consist of root, branches, and leafs.

    Binary tree:
    -tree having atmost 2 child node for each parent node.
    -Preorder, inorder and postorder traversal are DFS(depth first search), 
    whereas  LevelOrder traversal is a BFS(Breadth First Search)

    https://www.youtube.com/watch?v=-DzowlcaUmE
 */
package javaDSA;

import java.util.Queue;
import java.util.LinkedList;

class TreeNode{
    int data;
    TreeNode left, right;

    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}  

public class BinaryTree {
    int index = -1;

    //function to build binary tree  using array of preOrder
    public TreeNode buildTree(int[] nodes){
        index++;
        if(nodes[index] == -1){
            return null;
        }

        TreeNode newNode = new TreeNode(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return  newNode;
    }

    //PreOrder Traversal: root -> left subtree -> right subtree
    //Time  Complexity: O(n)
    void preOrder(TreeNode root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //InOrder Traversal: left subtree -> root -> right subtree
    void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    //PostOrder Traversal: left subtree -> right subtree -> root
    void postOrder(TreeNode root){
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    //level order traversal
    void leverOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>(); //q = [1,null,2,3,null,4,5,6,null]
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            TreeNode currNode = q.remove();
            if(currNode != null){
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
            else{
                //print new line
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
        }
    }

    //Function to count no. of nodes in the tree 
    int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return leftNodes+rightNodes+1;
    }

    //Function to find the height of the tree (total height = total levels)
    int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return Math.max(leftHeight, rightHeight)+1;
    }

    public static void main(String[] args) {
        //preordered tree
        int nodes[] = {1,2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.buildTree(nodes);
        /*
                    1
            2               3
        4       5               6
         */
        System.out.println("Root: "+root.data);

        System.out.println("\nPreorder Traversal");
        bt.preOrder(root);

        System.out.println("\nInorder Traversal");
        bt.inOrder(root);

        System.out.println("\nPostorder Traversal");
        bt.postOrder(root);

        System.out.println("\nLevelOrder Traversal");
        bt.leverOrder(root);

        System.out.println("\nTotal No. of nodes in the tree are: "+bt.countNodes(root));
        
        System.out.println("\nHeight of the tree is: "+bt.findHeight(root));
    }   
}
