/**
 * Created by mm on 12/6/15.
 */
public class UF {
    int id[];
    public UF(int N){
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] =i;

        }
    }
    public boolean isConnected(int p , int q){
        return id[p] == id[q];
    }
    public void union(int p ,int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pid) id[i] = q;

        }
    }
}
