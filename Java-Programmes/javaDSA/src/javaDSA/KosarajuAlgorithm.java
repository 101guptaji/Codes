/*
 * Strongly Connected Component (SSC):
    (https://www.youtube.com/watch?v=59fUtYYz7ZU&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&t=4h53m)
    - SSC is a componenet in which we can reach every vertex of the component from every other vertex in that componenet.
    Implementation:
    1. Kosaraju's Algorithm: (TC: O(V+E))
        - using reverse DFS
        Steps:
        a. Get nodes in stack (Topological Sort)
        b. Transpose the graph (source is destination and dest is source)
        c. Do DFS according to stack nodes on the transpose graph.
	
 */
package javaDSA;

import java.util.*;

public class KosarajuAlgorithm {

    static class Edge {
        int src;
        int dst;
        public Edge(int s, int d) {
            this.src = s;
            this.dst = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        //directed graph
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        
        graph[2].add(new Edge(2, 1));
        
        graph[3].add(new Edge(3, 4));
    }

    //main function of topological sort
    static void topoSort(ArrayList<Edge> graph[], int curr, boolean[] vis, Stack<Integer> st){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dst]){
                topoSort(graph, e.dst, vis, st);
            }
        }

        st.push(curr);
    }

    //function for DFS traversal on graph
    static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        vis[curr] = true;
        System.out.print(curr+" ");

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.dst]){
                dfs(graph, e.dst, vis);
            }
        }
    }

    //function to implement  Kosaraju's Algorithm
    @SuppressWarnings("unchecked")
    public static void kosaraju(ArrayList<Edge> graph[], int V){
        boolean vis[] = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        //topological sorting
        for(int i=0;i<V;i++){
            if(!vis[i]){
                topoSort(graph, i, vis, stack);
            }
        }

        //creating transpose graph
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i=0;i<V;i++){
            vis[i] = false;
            transpose[i] = new ArrayList<>();
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);

                transpose[e.dst].add(new Edge(e.dst, e.src));
            }
        }

        //DFS according to stack nodes on the transpose graph.
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(!vis[top]){
                dfs(transpose, top, vis);
                System.out.println();
            }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5; //No. of vertices
        ArrayList<Edge> graph[] = new ArrayList[V]; //graph using Adjancy list
        createGraph(graph); //creating graph

        System.out.println("Strongly Connected Components are:");
        kosaraju(graph, V);
    }
        
}
