/**
 * Created by mm on 29/6/15.
 */
public class Lock {
    boolean isLocked = false;
    Thread lockingThread = null;
    public synchronized void lock() throws InterruptedException{
        while (isLocked) wait();
        isLocked = true;
        lockingThread = Thread.currentThread();
    }

    public synchronized void unlock() throws InterruptedException {
        if(this.lockingThread != Thread.currentThread()){
            throw new IllegalMonitorStateException(
                    "Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        notify();
    }

}
