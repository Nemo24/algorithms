import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mm on 29/6/15.
 */
public class ProducerConsumer {
    Queue<Integer> q = new LinkedList<Integer>();
    int limit = 5;
    public synchronized void produce(int i) throws InterruptedException {
        //Thread.sleep(10);
        while (q.size() ==5 ) {

            wait();
        }
        q.add(i);
        notify();
    }
    public synchronized void consume() throws InterruptedException{
        while (q.isEmpty()) {wait();}
        int a = q.remove();
        notify();
        System.out.println("consumed :" + a);
    }

    public static void main(String[] args) throws InterruptedException {
       final ProducerConsumer mm = new ProducerConsumer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                while (i< 100) {try {
                    mm.produce(i++);
                } catch (Exception e) {}
                }}
            });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                while (true) {try {
                    mm.consume();
                } catch (Exception e) {}
                }}
            });

        t2.start();
        Thread.sleep(10);
        t1.start();
    }

}
