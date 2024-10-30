/*
 * Program to check  if given tree is subtree of main tree
 */
package javaDSA;

public class BinaryTreeSubtree {
    static boolean identical(TreeNode root, TreeNode subroot){
        //if leaf node of both tree
        if(root == null && subroot == null){
            return true;
        }
        //if only one is leaf
        if(root == null || subroot == null){
            return false;
        }

        if(root.data == subroot.data){
            return identical(root.left, subroot.left) && identical(root.right, subroot.right);
        }
        else{
            return false;
        }
    }

    static boolean isSubtree(TreeNode root, TreeNode subroot){
        //base cases
        if(subroot == null){
            return true;
        }
        if(root == null){
            return false;
        }

        if(root.data == subroot.data){
            if(identical(root, subroot)){
                return true;
            }
            else{
                return false;
            }
        }

        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public static void main(String[] args) {
        //preordered tree in array
        int nodes[] = {1,2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.buildTree(nodes); 

        int[] subNodes = {2,4,-1,-1,5,-1,-1};

        BinaryTree bt2 = new BinaryTree();
        TreeNode subRoot = bt2.buildTree(subNodes);

        System.out.println("Is subtree: "+isSubtree(root, subRoot)); 


    }
}
