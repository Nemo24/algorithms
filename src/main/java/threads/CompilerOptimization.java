package threads;

import java.util.Date;

public class CompilerOptimization {
    boolean stop = false;
    public boolean stop(){
        try {
            Thread.sleep(10000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stop;
    }
    public void dos (){
        while (!stop()){
            System.out.println("running "+new Date());
        }
    }

    public static void main(String[] args) {
        CompilerOptimization mm  = new CompilerOptimization();
        mm.dos();
    }
}
