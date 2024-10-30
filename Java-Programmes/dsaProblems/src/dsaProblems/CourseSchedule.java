/*
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return true if you can finish all courses. Otherwise, return false.
    
    Example 1:
    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take. 
    To take course 1 you should have finished course 0. So it is possible.
    
    Example 2:
    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take. 
    To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

    Constraints:
    1 <= numCourses <= 2000
    0 <= prerequisites.length <= 5000
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    All the pairs prerequisites[i] are unique.
 */
package dsaProblems;

import java.util.ArrayList;

public class CourseSchedule {
    
    //creating graph using adjancy list on prerequisite
    @SuppressWarnings("unchecked")
    static ArrayList<Integer>[] createGraph(int[][] pre, int num){
        ArrayList<Integer> graph[] = new ArrayList[num];

        for(int i=0;i<num;i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<pre.length;i++){
            graph[pre[i][0]].add(pre[i][1]);
        }

        return graph;
    }

    //function to check if cycle exists in directed graph
    public static boolean isCycle(ArrayList<Integer> graph[], int curr, boolean[] vis, boolean[] st){
        vis[curr] = true;
        st[curr] = true;

        for(int dst: graph[curr]){
            //if any ancestor node is curr neighbour then it's cycle
            if(st[dst]){
                return true;
            }
            else if(!vis[dst]){
                if(isCycle(graph, dst, vis, st))
                    return true;
            }
        }
        st[curr] = false;

        return false;
    }

    //function to check if all courses can be finish using directed graph
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = createGraph(prerequisites, numCourses);

        boolean vis[] = new boolean[numCourses];
        boolean stack[] = new boolean[numCourses]; //to store ancestors

        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                // if a cycle exists then all courses can not be finished
                if(isCycle(graph, i, vis, stack)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        
        System.out.println(canFinish(numCourses, prerequisites));
    }
}

/*
 * Approach: 
 *  If a cycle exists in a directed graph,  no topological ordering exists and therefore it will be impossible to take all courses.
 */