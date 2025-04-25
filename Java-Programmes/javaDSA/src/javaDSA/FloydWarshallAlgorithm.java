/*
 * Given a matrix dist[][] of size n x n, where dist[i][j] represents the weight of the edge from node i to node j. If there is no direct edge, dist[i][j] is set to a large value (e.g., 10⁸) to represent infinity. The diagonal entries dist[i][i] are 0, since the distance from a node to itself is zero. The graph may contain negative edge weights, but it does not contain any negative weight cycles.

Your task is to determine the shortest path distance between all pair of nodes i and j in the graph.

The Floyd–Warshall algorithm offers a different method for solving the shortest path problem. Unlike other algorithms Dijkstra and Bellman-Ford , it calculates the shortest paths between all pairs of nodes in a single run. It works by maintaining a two-dimensional array that represents the distances between nodes. Initially, this array is filled using only the direct edges between nodes. Then, the algorithm gradually updates these distances by checking if shorter paths exist through intermediate nodes.

This algorithm works for both the directed and undirected weighted graphs and can handle graphs with both positive and negative weight edges.

Note: It does not work for the graphs with negative cycles (where the sum of the edges in a cycle is negative).
 */

package javaDSA;

public class FloydWarshallAlgorithm {

    static void floydWarshall(int[][] dist) {
        int V = dist.length;

        // Add all vertices one by one to
        // the set of intermediate vertices.
        for (int k = 0; k < V; k++) {

            // Pick all vertices as source one by one
            for (int i = 0; i < V; i++) {

                // Pick all vertices as destination
                // for the above picked source
                for (int j = 0; j < V; j++) {

                    // shortest path from
                    // i to j
                    if(dist[i][k] < 1e8 && dist[k][j] < 1e8)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int INF = 100000000;

        int[][] dist = { { 0, 4, INF, 5, INF },
                { INF, 0, 1, INF, 6 },
                { 2, INF, 0, 3, INF },
                { INF, INF, 1, 0, 2 },
                { 1, INF, INF, 4, 0 } };

        floydWarshall(dist);
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
 * Approach:
 * Suppose we have a graph dist[][] with V vertices from 0 to V-1. Now we have
 * to evaluate a dist[][] where dist[i][j] represents the shortest path between
 * vertex i to j.
 * 
 * Let us assume that vertices i to j have intermediate nodes. The idea behind
 * Floyd Warshall algorithm is to treat each and every vertex k from 0 to V-1 as
 * an intermediate node one by one. When we consider the vertex k, we must have
 * considered vertices from 0 to k-1 already. So we use the shortest paths built
 * by previous vertices to build shorter paths with vertex k included.
 * 
 * No matter how many edges are there in the graph the Floyd Warshall Algorithm
 * runs for O(V3) times therefore it is best suited for Dense graphs. In the
 * case of sparse graphs, Johnson’s Algorithm is more suitable.
 * 
 */