package threads;

public class Race {
    public int x = 0;
    public int y = 0;
    public int i = 10;
    public int j = 10;

    public  static void test () throws InterruptedException {
        final Race r = new Race();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                r.x = 1;
                r.j = r.y;
              //  System.out.println("j = "+r.j);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                r.y = 1;
                r.i = r.x;
               // System.out.println("i = "+r.i);

            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        if (r.i == r.j) {
            System.out.println("i = j "+ r.i + " "+ r.j);
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 20000; i++) {
            try {
                test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
