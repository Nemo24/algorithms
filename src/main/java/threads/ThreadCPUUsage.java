package threads;

/**
 * Created by mm on 25/12/15.
 */
public class ThreadCPUUsage {
    public static void main(String[] args) {
        for (int i = 0; i <100000000; i++) {
            Thread t = new Thread(new Infinite());
            t.start();

        }
    }
}
class Infinite implements Runnable{
    int count;
    @Override
    public void run() {

        while(true){
            count++;
        }
    }
}