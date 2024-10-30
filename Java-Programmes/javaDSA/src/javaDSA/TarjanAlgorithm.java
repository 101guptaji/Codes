/*
 * Bridge in Graphs:
    - Bridge is a edge whose deletion increases the number of connected componenets in the graph.
    - Implementation:
    1. Tarjan's Algorithm:
        - used to find Bridge in graph
        - Discovery time (initial time from source to node)
        - Lowest Discovery time4

     (https://www.youtube.com/watch?v=59fUtYYz7ZU&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&t=5h21m)
 */
package javaDSA;

import java.util.*;

public class TarjanAlgorithm {
    
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

        //undirected graph
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
    }

    //function for Tarjan's Algorithm using DFS
    //TC: O(V+E)
    static void tarjanDFS(ArrayList<Edge> graph[], int curr, boolean vis[], int[] dtime, int[] low, int time, int parent){
        vis[curr] = true;
        dtime[curr] = low[curr] = ++time;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(e.dst == parent)
                continue;

            if(!vis[e.dst]){
                tarjanDFS(graph, e.dst, vis, dtime, low, time, curr);

                low[curr] = Math.min(low[curr], low[e.dst]);

                //condition for bridge 
                if(dtime[curr] < low[e.dst]){
                    System.out.println("Bridge: "+curr+" -> "+e.dst);
                }
            }
            else{
                low[curr] = Math.min(low[curr], dtime[e.dst]);
            }
        }
    }

    //function to implement Tarjan's Algorithm
    public static void getBridge(ArrayList<Edge> graph[], int V){
        boolean vis[] = new boolean[V];
        
        int dtime[] = new int[V];  //discovery time
        int low[] = new int[V]; //lowest discovery time
        int t = 0;

        for(int i=0;i<V;i++){
            if(!vis[i]){
                tarjanDFS(graph, i, vis, dtime, low, t, -1);
            }
        }

    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5; //No. of vertices
        ArrayList<Edge> graph[] = new ArrayList[V]; //graph using Adjancy list
        createGraph(graph); //creating graph

        getBridge(graph, V);
    }
}
