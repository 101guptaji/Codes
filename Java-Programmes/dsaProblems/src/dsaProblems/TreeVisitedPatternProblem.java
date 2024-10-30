/*
 * Problem: https://www.hackerrank.com/challenges/java-vistor-pattern/problem?isFullScreen=true
 * An important concept in Object-Oriented Programming is the open/closed principle, which means writing code that is open to extension 
 * but closed to modification. In other words, new functionality should be added by writing an extension for the existing code rather than 
 * modifying it and potentially breaking other code that uses it. 
 * This challenge simulates a real-life problem where the open/closed principle can and should be applied.

	A Tree class implementing a rooted tree is provided in the editor. It has the following publicly available methods:
	getValue(): Returns the value stored in the node.
	getColor(): Returns the color of the node.
	getDepth(): Returns the depth of the node. Recall that the depth of a node is the number of edges between the node and the tree's root, 
	so the tree's root has depth 0 and each descendant node's depth is equal to the depth of its parent node +1.
	In this challenge, we treat the internal implementation of the tree as being closed to modification, 
	so we cannot directly modify it; however, as with real-world situations, the implementation is written in such a way that 
	it allows external classes to extend and build upon its functionality. 
	More specifically, it allows objects of the TreeVis class (a Visitor Design Pattern) to visit the tree and traverse the tree structure 
	via the accept method.
	
	There are two parts to this challenge.
	
	Part I: Implement Three Different Visitors
	Each class has three methods you must write implementations for:
	getResult(): Return an integer denoting the result, which is different for each class:
	The SumInLeavesVisitor implementation must return the sum of the values in the tree's leaves only.
	The ProductRedNodesVisitor implementation must return the product of values stored in all red nodes, 
		including leaves, computed modulo 1000000007. Note that the product of zero values is equal to 1.
	The FancyVisitor implementation must return the absolute difference between the sum of values stored in the tree's non-leaf nodes 
		at even depth and the sum of values stored in the tree's green leaf nodes. Recall that zero is an even number.
	visitNode(TreeNode node): Implement the logic responsible for visiting the tree's non-leaf nodes such that the getResult method 
		returns the correct result for the implementing class' visitor.
	
	visitLeaf(TreeLeaf leaf): Implement the logic responsible for visiting the tree's leaf nodes such that the getResult method returns the 
	correct result for the implementing class' visitor.
	
	Part II: Read and Build the Tree
	Read the n-node tree, where each node is numbered from 1 to n. 
	The tree is given as a list of node values (x1,x2,...xn), a list of node colors (c1,c2,...cn), and a list of edges. 
	Construct this tree as an instance of the Tree class. The tree is always rooted at node number 1.
	
	Your implementations of the three visitor classes will be tested on the tree you built from the given input.
	
	Input Format
	The first line contains a single integer, n, denoting the number of nodes in the tree. 
	The second line contains n space-separated integers describing the respective values of x1,x2,..xn.
	The third line contains  space-separated binary integers describing the respective values of c1,c2,..cn. 
	Each  denotes the color of the  node, where 0 denotes red and 1 denotes green.
	Each of the  subsequent lines contains two space-separated integers, ui and vi, describing an edge between nodes ui and vi.
	
	Constraints
	It is guaranteed that the tree is rooted at node .
	
	Output Format:
	Do not print anything to stdout, as this is handled by locked stub code in the editor. 
	The three getResult() methods provided for you must return an integer denoting the result for that class' visitor (defined above). 
	Note that the value returned by ProductRedNodesVisitor's getResult method must be computed modulo 10*9 + 7.
	
	Sample Input:
	5
	4 7 2 5 12
	0 1 0 0 1
	1 2
	1 3
	3 4
	3 5
	Sample Output:	
	24
	40
	15
 */

package dsaProblems;

import java.util.*; 

enum Color { RED, GREEN }

abstract class Tree {

	private int value; 
	private Color color; 
	private int depth;

	public Tree(int value, Color color, int depth) 
	{ 
		this.value = value; 
		this.color = color; 
		this.depth = depth; 
	}
	
	public int getValue() { return value; }
	
	public Color getColor() { return color; }
	
	public int getDepth() { return depth; }
	
	public abstract void accept(TreeVis visitor); 
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis { 
	int result = 0;

	public int getResult() { 
		return result; 
	}

	public void visitNode(TreeNode node) { 
		
	}
	
	public void visitLeaf(TreeLeaf leaf) { 
		result += leaf.getValue(); 
	} 
}

class ProductOfRedNodesVisitor extends TreeVis { 
	long result = 1L;

	public int getResult() { 
		return (int) result; 
		}
	
	public void visitNode(TreeNode node) { 
		if (node.getColor() == Color.RED) {
			result = (result * node.getValue()) % (1000000007); 
		} 
	}

	public void visitLeaf(TreeLeaf leaf) { 
		if (leaf.getColor() == Color.RED) { 
			result = (result * leaf.getValue()) % (1000000007); 
		} 
	} 
}

class FancyVisitor extends TreeVis { 
	int sumOfNode = 0; 
	int sumOfLeaf = 0;

	public int getResult() { 
		return Math.abs(sumOfNode - sumOfLeaf); 
	}

	public void visitNode(TreeNode node) { 
		if (node.getDepth() % 2 == 0) { 
			sumOfNode += node.getValue(); 
		} 
	}


	public void visitLeaf(TreeLeaf leaf) { 
		if (leaf.getColor() == Color.GREEN) { 
			sumOfLeaf += leaf.getValue(); 
		} 
	} 
}

public class TreeVisitedPatternProblem {

		public static Tree solve() { // read the tree from STDIN and return its root as a return value of this function 
			Scanner sc = new Scanner(System.in); int n = sc.nextInt();

			int[] vals = new int[n];
	
			for (int i = 0; i < n; i++) {
			    vals[i] = sc.nextInt();
			
			}
			Color[] colors = new Color[n];
	
			for (int i = 0; i < n; i++) {
			    colors[i] = sc.nextInt() == 1 ? Color.GREEN : Color.RED;
			}
	
			Map<Integer, Set<Integer>> nodeEdges = new HashMap<>();
			for (int i = 0; i < n - 1; i++) {
			    int u = sc.nextInt();
			    int v = sc.nextInt();
			    if (!nodeEdges.containsKey(u)) {
			        nodeEdges.put(u, new HashSet<Integer>());
			    }
			    if (!nodeEdges.containsKey(v)) {
			        nodeEdges.put(v, new HashSet<Integer>());
			    }
			    nodeEdges.get(u).add(v);
			    nodeEdges.get(v).add(u);
			}
			
			Map<TreeNode, Integer> nodeIndexMap = new HashMap<>();
			List<TreeNode> parents = new ArrayList<>();
			
			TreeNode root = new TreeNode(vals[0], colors[0], 0);
			nodeIndexMap.put(root, 1);
			parents.add(root);
	
			while (!parents.isEmpty()) {
			    List<TreeNode> nextLevelParents = new ArrayList<>();
			    for (TreeNode node : parents) {
			        int depth = node.getDepth();
			        int parentIndex = nodeIndexMap.get(node);
			
			        for (int childIndex : nodeEdges.get(parentIndex)) {
			
			            nodeEdges.get(childIndex).remove(parentIndex);
			
			            if (!nodeEdges.get(childIndex).isEmpty()) {
			                TreeNode child = new TreeNode(vals[childIndex - 1], colors[childIndex - 1], depth + 1);
			                nextLevelParents.add(child);
			                nodeIndexMap.put(child, childIndex);
			                node.addChild(child);
			            } else {
			                TreeLeaf leaf = new TreeLeaf(vals[childIndex - 1], colors[childIndex - 1], depth + 1);
			                node.addChild(leaf);
			            }
			        }
			    }
			    parents = nextLevelParents;
			}
			sc.close();
			return root;
	}

	public static void main(String[] args) { 
		Tree root = solve(); 
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor(); 
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor(); 
		FancyVisitor vis3 = new FancyVisitor();
	
		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);
		
		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();
		
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	} 
}