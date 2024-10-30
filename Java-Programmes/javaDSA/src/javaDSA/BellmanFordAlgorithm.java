/*
 * 2. Bellman Ford Algorithm:
	- similar to Dijkstra's Algorithm but it also works if weight or distance is negative.
	- takes more time than Dijkstra.
	- does not work for negative weight cycle (i.e. sum of weights of all edges in a cycle is negative)
	- TC: O(V*E)
 */

package javaDSA;

import  java.util.*;

public class BellmanFordAlgorithm {

    static class Edge{
        int src, dst, weight;

        public Edge(int s, int d, int w){
            src = s;
            dst = d;
            weight = w;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        //Initialization
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));
        
        graph[3].add(new Edge(3, 4, 4));
        
        graph[4].add(new Edge(4, 1, -1)); //graph[4].add(new Edge(4, 1, -10));
    }

    //Time Complexity: O(V*E)
    public static void bellmanFord(ArrayList<Edge> graph[], int src){
        int V = graph.length;
        int dist[] = new int[V];
        for(int i=0;i<V;i++){
            if(i != src)
                dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<V-1;i++){ //TC: O(V)

            //TC: O(E)
            for(int j=0;j<V;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dst;

                    if(dist[u] != Integer.MAX_VALUE && dist[u]+e.weight < dist[v]){
                        dist[v] = dist[u] + e.weight;
                    }
                }
            }
        }

        //Detecting Negative Weight Cycle
        for(int j=0; j<graph.length; j++) {
            for(int k=0; k<graph[j].size(); k++) {
                Edge e = graph[j].get(k);
                int u = e.src;
                int v = e.dst;

                if(dist[u] != Integer.MAX_VALUE && dist[u]+e.weight < dist[v]) {
                    System.out.println("negative weight cycle exists");
                    break;
                }
            }
        }
    

        for(int i=0;i<V;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5; //No. of vertices
        ArrayList<Edge> graph[] = new ArrayList[V]; //graph using Adjancy list
        createGraph(graph); //creating graph

        bellmanFord(graph, 0);
    }
}
