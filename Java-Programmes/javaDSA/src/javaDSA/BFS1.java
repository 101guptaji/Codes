/*
 * Traversing the Graphs:
    1. Breadth First Search(BFS): 
        - Since there is no start or root in Graphs.
        - So, start from any node and go to immediate neighbors first.
        - print the neighbors then go next neighbors.
        - it is similar to indirect level order traversal.
        - Implementation:
            - Create a boolean array names visited of size V.
            - Create a  queue to add neighbors.
            - if Not Visited, print and add its neighbors to queue.
            - remove that node from queue.
        - Sudo Code:
            create queue q, and array vis[V]
            q.add(0);
            while(!q.empty()){
                int curr = q.remove();
                if(!vis[curr]){
                    print(curr);
                    vis[curr] = true;
                    for(int i=0 to graph[curr].size){
                        Edge e = graph[curr].get(i);
                        q.add(e.dest) 
                    }
                }
            }
        
 */
package javaDSA;

import java.util.*;

public class BFS1 {

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
        //graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        //graph[2].add(new Edge(2, 4, 1));
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
    static void bfs(ArrayList<Edge> graph[], boolean vis[], int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.add(start);
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            //if not visited, then print
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;

                //adding neighbours to queue
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    queue.add(e.dst);
                }
            }
        }
        System.out.println();
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

        //BFS traversal even if graph is discret (all nodes are not connected)
        boolean vis[] = new boolean[V]; 
        for(int i=0;i<V;i++){
            if(vis[i] == false){
                bfs(graph, vis, i); //bsf traversal
            }
        }
        
    }
}
