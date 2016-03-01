package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mm on 1/9/15.
 */
public class ExecutorExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new MyRunnable(i),"Thread" + i);
            executorService.execute(t);

        }
        executorService.shutdown();
        while (!executorService.isTerminated()){

        }
        System.out.println("done");
    }
}

class MyRunnable implements Runnable{
    int num;
    public MyRunnable(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(num +" running");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
