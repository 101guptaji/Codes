/*
    2. Depth First Search(DFS):
        - Keep going to the 1st neighbor.
        - use Recursion to go depth of each neighbor.
        - 
 */
package javaDSA;

import java.util.*;;

public class DFS1 {
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

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));

    }

    //Time Complexity: O(V+E), where V = no. of vertics and E = No. of Edges
    static void dfs(ArrayList<Edge> graph[], boolean vis[], int curr){
        
        System.out.print(curr+" ");
        vis[curr] = true;

        //traversing all neighbours
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            //if neighbour is not visited, then traverse 
            if(!vis[e.dst]){
                dfs(graph, vis, e.dst);
            }
        }
    }

    //function to print all paths from src to dest
    //TC: O(V*V)
    static void printAllPaths(ArrayList<Edge> graph[], boolean vis[], String path, int src, int dest){
        if(src == dest){
            path += dest;
            System.out.println(path);
            return;
        }

        path += src+"->";
        vis[src] = true;

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);

            //if neighbour is not visited, then traverse 
            if(!vis[e.dst]){
                printAllPaths(graph, vis,path, e.dst, dest);
                vis[e.dst] = false;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
         /*
         1 --- 3
        /      | \
       0       |  5 -- 6
        \      | /
        2 ---- 4
        */
        int V = 7; //No. of vertices
        ArrayList<Edge> graph[] = new ArrayList[V]; //graph using Adjancy list
        createGraph(graph); //creating graph

        //DFS traversal even if graph is discret (all nodes are not connected)
        System.out.println("Printing all vertices in DFS fashion");
        boolean vis[] = new boolean[V]; 
        for(int i=0;i<V;i++){
            if(vis[i] == false){
                dfs(graph, vis, i); //dfs traversal
            }
        }

        vis = new boolean[V]; 
        System.out.println("\nPrinting all paths from 0 to 5");
        printAllPaths(graph, vis,"", 0, 5);
    }
}
