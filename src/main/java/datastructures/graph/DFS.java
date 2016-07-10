package datastructures.graph;

/**
 * Created by mm on 3/3/16.
 */
public class DFS {
    boolean[] visited;
    int[] edgeTo;
    int count;
    Graph graph;

    public DFS(Graph g,int s){
        visited = new boolean[g.V()];
        dfs(g,s);
    }

    private void dfs(Graph g,int v){
        count++;
        visited[v]=true;
        for(int neighbour:g.adj(v)){
            if (!visited[neighbour]){
                visited[neighbour]=true;
                edgeTo[neighbour]=v;
                dfs(g,neighbour);
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
