/*
 * 802. Find Eventual Safe States
    There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

    A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

    Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

    Example 1:
    Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
    Output: [2,4,5,6]
    Explanation: The given graph is shown above.
    Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
    Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
    
    Example 2:
    Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
    Output: [4]
    Explanation:
    Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
    

    Constraints:
    n == graph.length
    1 <= n <= 104
    0 <= graph[i].length <= n
    0 <= graph[i][j] <= n - 1
    graph[i] is sorted in a strictly increasing order.
    The graph may contain self-loops.
    The number of edges in the graph will be in the range [1, 4 * 104].
 */
package dsaProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindSafeStatesGraph {

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<Integer> ans = new ArrayList<>(); // output array

        int[] nbrs = new int[V]; // to store no. of outgoing edges

        //transpose graph (reverse the directions of nodes in graph)
        ArrayList<ArrayList<Integer>> trans = new ArrayList<>();
        //initialization
        for(int i=0;i<V;i++){
            trans.add(new ArrayList<>());
        }
        //insertion to transpose graph
        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].length;j++){
                trans.get(graph[i][j]).add(i);
                nbrs[i]++;
            }
        }

        //store nodes having 0 outgoing edges in queue
        Queue<Integer> queue = new  LinkedList<>();
        for(int i=0;i<V;i++){
            //terminal node if it has no outgoing edges or neighbours
            if(nbrs[i] == 0){
                queue.add(i);
            }
        }

        //Topo sort using BFS
        while(!queue.isEmpty()){
            int curr = queue.remove();
            ans.add(curr);

            for(int dst : trans.get(curr)){
                //if only one neighbour then 
                if(--nbrs[dst] == 0){
                    queue.add(dst);
                }
            }
        }

        //sort the output array in ascending order
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};

        List<Integer> safeNodes = eventualSafeNodes(graph);

        System.out.println(safeNodes);
    }
}

/*
 * Approach
    just reverse the directions of nodes in graph (transpose)
    store nodes having 0 outgoing edges in queue
    apply topological sort
    sort the output array in ascending order
 */