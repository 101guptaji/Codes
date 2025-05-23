package dsaProblems;

import java.util.*;

public class Test1{

	static class Edge {
        int src, dst;

        public Edge(int s, int d){
            src = s;
            dst = d;
        }
    }

    static void createGraph(ArrayList<Edge> graph[], int[][] edges, int notType){
        //Initialization
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edges){
            int type = e[0];
            int src = e[1];
            int dst = e[2];
			if(type != notType)
	            graph[src].add(new Edge(src, dst));
        }
    }

	public static Set<Edge> primsAlgo(ArrayList<Edge> graph[], int src){
        //priority to store nodes with distance in sorted order
        Queue<Edge> pq = new LinkedList<Edge>();

        boolean vis[] = new boolean[graph.length+1];
        Set<Edge> mstEdges = new HashSet<>();

        pq.add(new Edge(-1, src));

        while(!pq.isEmpty()){
            Edge curr = pq.remove();

            if(!vis[curr.dst]){
                vis[curr.dst] = true;
                mstEdges.add(curr);

                for(int i=0;i<graph[curr.dst].size();i++){
                    Edge e = graph[curr.dst].get(i);

                    if(!vis[e.dst]){ 
                        pq.add(new Edge(curr.dst, e.dst));
                    }
                    
                }
            }
        }

        return mstEdges;

    }

	@SuppressWarnings("unchecked")
	public static int maxNumEdgesToRemove(int n, int[][] edges){
		ArrayList<Edge> graphA[] = new ArrayList[n+1];
		createGraph(graphA, edges, 2);

		/* for(int  i=0;i<graphA.length;i++){
			for(Edge e : graphA[i]){
				System.out.println(e.src+"=>"+e.dst);
			}
		} */

		ArrayList<Edge> graphB[] = new ArrayList[n+1];
		createGraph(graphB, edges, 1);

		Set<Edge> AliceEdges = primsAlgo(graphA, 1);
		Set<Edge> BobEdges = primsAlgo(graphB, 1);

		for(Edge e : AliceEdges){
			System.out.println(e.src+"=>"+e.dst);
		}

		for(Edge e : BobEdges){
			System.out.println(e.src+"=>"+e.dst);
		}

		return -1;

	}

	public static void main(String[] args) {
		int n = 4; 
		int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};

		maxNumEdgesToRemove(n, edges);
	}
}

