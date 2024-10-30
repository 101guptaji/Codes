/*
 * Minimum Spanning Tree (MST):
    - It is a subset of the edges of a connected weighted undirected graph
        that connects all the vertices together, without any cycle and with the
        minimum possible total edge weight.
    - all vertices are connected 
    - no cycle
    - total weight is minimum for each vertices.
    Ways to implementation:		
    1. Prim's Algorithm:
        - BFS with priority queue.
 */
package javaDSA;

import java.util.*;

public class PrimsAlgorithm {
    
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

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    //pair class to store node and its distance from source
    static class Pair implements Comparable<Pair>{
        int node, cost;

        Pair(int n, int d){
            node =n;
            cost = d;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; //ascending sort on distance
        }
    }

    //function to implement Prim's Algorithm
    //Time Complexity: O(E + E*log(V)), where E*logV due to priority queue and E for traversing by edge
    public static void primsAlgo(ArrayList<Edge> graph[], int src){
        //priority to store nodes with distance in sorted order
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        boolean vis[] = new boolean[graph.length];
        int mstCost = 0;

        ArrayList<Edge> mst = new ArrayList<>();

        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair p = pq.remove();

            if(!vis[p.node]){
                vis[p.node] = true;
                mstCost += p.cost;

                mst.add(new Edge(src, p.node, p.cost));

                for(int i=0;i<graph[p.node].size();i++){
                    Edge e = graph[p.node].get(i);

                    //update sortest distance (Relaxation)
                    if(!vis[e.dst]){ 
                        pq.add(new Pair(e.dst, e.weight));
                    }
                    
                }
            }
        }

        System.out.println("Minimum cost "+mstCost);
        
        for(Edge e : mst){
            System.out.println(e.src+"->"+e.dst+" cost= "+e.weight);
        }

    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 4; //No. of vertices
        ArrayList<Edge> graph[] = new ArrayList[V]; //graph using Adjancy list
        createGraph(graph); //creating graph

        primsAlgo(graph, 0);
    }
}
