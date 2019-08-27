package threads;

/**
 * Created by mm on 17/10/15.
 */
public class SleepVsWait {
    public synchronized void  doSomethingSleep(){

        System.out.println(Thread.currentThread().getName() + "doing something");
    }
}
