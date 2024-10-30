/*
 * https://www.youtube.com/watch?v=59fUtYYz7ZU&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&t=2h13m
 */
package javaDSA;

import java.util.*;;

public class CycleDetectionDirected {

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

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    //function to check if a cycle exists in the directed graph
    //Time Complexity: O(V+E), where V = no. of vertics and E = No. of Edges
    static boolean isCycleDirected(ArrayList<Edge> graph[], int curr, boolean vis[], boolean recStack[]){
        vis[curr] = true;
        recStack[curr] = true; 

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            //if neighbor is already in stack then it is a cycle
            if(recStack[e.dst]){
                return true;
            }
            //if neighbor is not visited then visit it
            else if(!vis[e.dst]){
                if(isCycleDirected(graph, e.dst, vis, recStack)){
                    return true;
                }
            }
        }
        recStack[curr] = false;

        return false;
    }

    static boolean isCyclic(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length]; 
        boolean recStack[] = new boolean[graph.length]; //recursion stack array which store parent node

        //if all nodes of graph are not connected
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(isCycleDirected(graph, i, vis, recStack)){
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
