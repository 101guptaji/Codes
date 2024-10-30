/*
 * https://www.youtube.com/watch?v=59fUtYYz7ZU&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop
    Graphs:
        - A network of connected nodes.
        Vertex = nodes of the graphs
        Edge = line connecting two Vertices .
        Weight = distance (or time) from  one node to another
        Graphs can be directed or undirected, can be unidirectional or bi-directional.

    Application of Graphs:
    1. Maps
    2. Social sites
    3. Delivery Network

    Ways of creating a Graphs:
    1. Adjacency List (array of ArrayLists)
    2. Adjacency Matrix
    3. Edge List
    4. 2D matrix (Implicit Graph)

    1. Adjacency List:
        ArrayList<Edge> graph[V]; //where V=no. of Vertices 
        static class Edge{
            int src;
            int dest;
        }
	
	
 */
package javaDSA;

import java.util.*;;

public class Graph1 {

    static class Edge{
        int src, dst, weight;

        public Edge(int s, int d, int w){
            src = s;
            dst = d;
            weight = w;
        }
    }

    //function to create graph using adjancy list
    static void createGraph(ArrayList<Edge> graph[]){
        //Initialization
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2,2));

        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0,2));
        graph[2].add(new Edge(2, 1,10));
        graph[2].add(new Edge(2, 3, -1));

        graph[3].add(new Edge(3, 1,0));
        graph[3].add(new Edge(3, 2,-1));

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 4; // No. of vertices

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println("Printing neighbours and weights of 2:");
        for(int i=0;i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dst+" "+e.weight);
        }
        System.out.println();



    }
}
