package javaDSA;

import java.util.*;

public class CycleDetectionUndirected {

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

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        //graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
    }

    //function to check if a cycle exists in the undirected graph
    //Time Complexity: O(V+E), where V = no. of vertics and E = No. of Edges
    static boolean isCycleUndirected(ArrayList<Edge> graph[], int curr, boolean vis[], int parent){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            //if neighbor is already in stack then it is a cycle
            if(vis[e.dst] && e.dst != parent){
                return true;
            }
            //if neighbor is not visited then visit it
            else if(!vis[e.dst]){
                if(isCycleUndirected(graph, e.dst, vis, curr)){
                    return true;
                }
            }
        }

        return false;
    }

    static boolean isCyclic(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length]; 
        //if all nodes of graph are not connected
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleUndirected(graph, 0, vis, -1)){
                    return true;
                }
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println("Is a cycle exist in the graph? "+isCyclic(graph));
        
    }
}
