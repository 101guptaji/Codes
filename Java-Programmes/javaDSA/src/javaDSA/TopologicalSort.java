/*
 * Topological Sorting:
    - works on Directed Acyclic Graphs(DAGs) only. 
    - DAG is a directed graph with no cycles.
    - Topological Sorting is a linear order of vertices such that
        for every directed edge u->v, the vertex 'u' comes before v in the order.
    - Algorithm using DFS:
        - traverse all neighbors of a node and push all neighbors in stack.
        - Now, pop elements from stack

 */
package javaDSA;

import java.util.*;


public class TopologicalSort {

    static class Edge{
        int src, dst;

        Edge(int s, int d){
            src = s;
            dst = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    //main function of topological sort
    static void topoSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stack){
        
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dst]){
                topoSortUtil(graph, e.dst, vis, stack);
            }
        }

        stack.push(curr);
    }

    //function to sort graph topologically
    static void topoSort(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];

        Stack<Integer> stack = new Stack<Integer>();

        //if  all nodes of graph are not connected or not have path to all nodes 
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topoSortUtil(graph, i, vis, stack);
            }
        }
        
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topoSort(graph);
    }
}
