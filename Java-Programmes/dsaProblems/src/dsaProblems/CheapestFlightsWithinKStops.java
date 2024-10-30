/*
 * 787. Cheapest Flights Within K Stops:
    There are n cities connected by some number of flights. 
    You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

    You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

    Example 1:
    Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
    Output: 700
    Explanation:
    The graph is shown above.
    The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
    Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
    
    Example 2:
    Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
    Output: 200
    Explanation:
    The graph is shown above.
    The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
    
    Example 3:
    Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
    Output: 500
    Explanation:
    The graph is shown above.
    The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
    

    Constraints:
        1 <= n <= 100
        0 <= flights.length <= (n * (n - 1) / 2)
        flights[i].length == 3
        0 <= fromi, toi < n
        fromi != toi
        1 <= pricei <= 104
        There will not be any multiple flights between two cities.
        0 <= src, dst, k < n
        src != dst
 */
package dsaProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    //class to store flight details from fromi city to to-i city with cost
    static class Edge{
        int fromi, toi, pricei;

        public Edge(int s, int d, int w){
            fromi = s;
            toi = d;
            pricei = w;
        }
    }

    //creating graph based on input 
    static void createGraph(ArrayList<Edge> graph[], int[][] flights){
        //Initialization
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
    
        for(int i=0;i<flights.length;i++){
            graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
        }
    }

    //pair class to store city, cost to reach city from source, and flights taken
    static class Pair{
        int city, costs, steps;

        Pair(int n, int d, int s){
            city =n;
            costs = d;
            steps = s;
        }
    }

    //function to find path with minimum cost using Dijkstras Algorithm with BFS
    @SuppressWarnings("unchecked")
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n]; //graph using Adjancy list
        createGraph(graph, flights); //creating graph

        //costs array which store minimum cost to reach each city, ith index represents ith city
        int[] costs = new int[n];
        //assume initially cost for each city except src is infinite
        for(int i=0;i<n;i++){
            if(i != src){
                costs[i] = Integer.MAX_VALUE;
            }
        }

        //queue to store city with costs and no of flights taken to reach the city
        Queue<Pair> pq = new LinkedList<>();

        //for source, zero cost and no flight needed
        pq.add(new Pair(src, 0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            for(int i=0;i<graph[curr.city].size();i++){
                Edge e = graph[curr.city].get(i);

                //update minimum costs (Relaxation)
                if(curr.costs+e.pricei < costs[e.toi]){
                    if(curr.steps <= k) {
                        costs[e.toi] = curr.costs + e.pricei;
                        pq.add(new Pair(e.toi, costs[e.toi], curr.steps+1));
                    }
                }
            }    
            
        }
        if(costs[dst] != Integer.MAX_VALUE){
            return costs[dst];
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int src = 0, dst = 2, k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }
}
