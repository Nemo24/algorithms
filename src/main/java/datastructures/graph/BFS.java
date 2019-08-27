package datastructures.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mm on 5/3/16.
 */
public class BFS {
    boolean[] visited;
    int[] edgeTo;
    int count;
    Graph graph;

    public BFS(Graph g,int s){
        visited = new boolean[g.V()];
        bfs(g,s);
    }

    private void bfs(Graph g,int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v]=true;
        while (!queue.isEmpty()){
            int temp = queue.remove();
            for (int neighbour:g.adj(temp)){
                visited[neighbour]=true;
                edgeTo[neighbour]=temp;
                queue.add(neighbour);
            }
        }
    }

    public boolean visited(int v) {
        return visited[v];
    }

    /**
     * Returns the number of vertices connected to the source vertex <tt>s</tt>.
     * @return the number of vertices connected to the source vertex <tt>s</tt>
     */
    public int count() {
        return count;
    }
}
