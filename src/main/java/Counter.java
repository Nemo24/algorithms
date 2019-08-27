/**
 * Created by mm on 25/6/15.
 */
public class Counter {
    int count = 0;
    public synchronized void add(){
        count+=1;
    }
    public int getCount() {return count;};

    public static void main(String[] args) {
        Counter c = new Counter();
        CounterThread t1 = new CounterThread(c);
        CounterThread t2 = new CounterThread(c);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf(c.getCount()+"");
    }
}

class CounterThread extends Thread{

    protected Counter counter = null;

    public CounterThread(Counter counter){
        this.counter = counter;
    }

    public void run() {
        for(int i=0; i<1000; i++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter.add();
        }
    }
}
