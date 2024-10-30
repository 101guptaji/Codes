package dsaProblems;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int data;
    TreeNode left, right;

    TreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }
}  

class BinaryTree {
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
}

public class NodesSumAtKthLevel {

    //level order traversal
    static int findSum(TreeNode root, int k){
        if(root == null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>(); //q = [1,null,2,3,null,4,5,6,null]
        q.add(root);
        q.add(null);
        
        int count = 1;

        while(!q.isEmpty() && count<k){
            TreeNode currNode = q.remove();
            if(currNode != null){
                //System.out.print(currNode.data+" ");
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
                    count++;
                }
            }
        }

        int sum = 0;
        while(q.peek() != null){
            sum += q.remove().data;
        }

        return sum;
    }

    public static void main(String[] args) {
        int nodes[] = {1,2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.buildTree(nodes);

        System.out.println(findSum(root, 2));

    }
}
