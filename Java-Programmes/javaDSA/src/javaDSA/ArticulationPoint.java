/*
 * Articulation Point:
    - It is similar to Bridge in Graph.
    - It is a vertex in an undirected connected graph such that if we remove this vertex, it disconnects the graph.  
    Tarjan's Algorithm: 
        - Ancestor: a node A that was discovered beforee curr node in DFS, isthe ancestor of curr.
        - A node is a Articulation Point if:
            - it is starting node of DFS (i.e. parent = -1) with more than 1 disconnected children.
            - It is the only node which connect 2 or more nodes.
            -

     (https://www.youtube.com/watch?v=59fUtYYz7ZU&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&t=6h)
 */

package javaDSA;

import java.util.*;;

public class ArticulationPoint {
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
    // TC: O(V+E)
    static void tarjanDFS(ArrayList<Edge> graph[], int curr, boolean vis[], int[] dtime, int[] low, int time, int parent, boolean isArticulation[]){
        vis[curr] = true;
        dtime[curr] = low[curr] = ++time;
        int child = 0;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            //check for parent 
            if(e.dst == parent)
                continue;

            if(!vis[e.dst]){
                tarjanDFS(graph, e.dst, vis, dtime, low, time, curr, isArticulation);

                low[curr] = Math.min(low[curr], low[e.dst]);

                //condition for articulation point: only node which connect 2 or more nodes.
                if(dtime[curr] <= low[e.dst]){
                    isArticulation[curr] = true;
                }
                child++;
            }
            //check for ancestor
            else{
                low[curr] = Math.min(low[curr], dtime[e.dst]);
            }
        }

        //starting node of DFS (i.e. parent = -1) with more than 1 disconnected children
        if(parent == -1 && child > 1){
            isArticulation[curr] = true;
        }
    }

    //function to find Articulation point
    public static void findArticulation(ArrayList<Edge> graph[], int V){
        boolean vis[] = new boolean[V];
        
        int dtime[] = new int[V];  //discovery time
        int low[] = new int[V]; //lowest discovery time
        int t = 0;
        boolean isArticulation[] = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                tarjanDFS(graph, i, vis, dtime, low, t, -1, isArticulation);
            }
        }

        System.out.println("Articulation Points are: ");
        for(int i=0;i<isArticulation.length;i++){
            if(isArticulation[i])
                System.out.print(i+", ");
        }

    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5; //No. of vertices
        ArrayList<Edge> graph[] = new ArrayList[V]; //graph using Adjancy list
        createGraph(graph); //creating graph

        findArticulation(graph, V);
    }
}
