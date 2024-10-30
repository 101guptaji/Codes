/*
 * 1. Dijkstra's Algorithm:
	- Sortest distance from the source to all vertices.
    - does not properly when distance (weight) is negative
	- implementation using BFS with priority queue.
    - Time Complexity: O(E + E*log(V))
 */
package javaDSA;

import  java.util.*;

public class DijkstrasAlgorithm {

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

        graph[1].add(new Edge(1, 0, 2));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 4));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 1, 7));
        graph[3].add(new Edge(3, 4, 2));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 3));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    //pair class to store node and its distance from source
    static class Pair implements Comparable<Pair>{
        int node, dist;

        Pair(int n, int d){
            node =n;
            dist = d;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist; //ascending sort on distance
        }
    }

    //function to implement Dijkstra's Algorithm
    //Time Complexity: O(E + E*log(V)), where E*logV due to priority queue and E for traversing by edge
    public static void dijkstra(ArrayList<Edge> graph[], int src){
        //priority to store nodes with distance in sorted order
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //distance array which store distancee for each node
        int[] dist = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];

        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair p = pq.remove();

            if(!vis[p.node]){
                vis[p.node] = true;

                for(int i=0;i<graph[p.node].size();i++){
                    Edge e = graph[p.node].get(i);

                    //update sortest distance (Relaxation)
                    if(!vis[e.dst] && dist[e.src]+e.weight < dist[e.dst]){ 
                        dist[e.dst] = dist[e.src] + e.weight;
                        pq.add(new Pair(e.dst, dist[e.dst]));
                    }
                    
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();

    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6; //No. of vertices
        ArrayList<Edge> graph[] = new ArrayList[V]; //graph using Adjancy list
        createGraph(graph); //creating graph

        dijkstra(graph, 0);
    }
}
