package threads;

import java.util.Random;

/**
 * Created by mm on 25/12/15.
 */
public class CounterExample {
    public static void main(String[] args) {
       final Counter counter = new Counter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.doSomeThing();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.doSomeThing();
            }
        });

        t1.start();
        t2.start();
    }

}

class Counter {
    Random random = new Random();
    int count = 0;
    public  void doSomeThing() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(random.nextInt(20));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(count++);
            }
        }
    }
}