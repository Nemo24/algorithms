package basicjava.comparable;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by mm on 29/8/15.
 */
class HDTV implements Comparable<HDTV> {
    private int size;
    private String brand;

    public HDTV(int size, String brand) {
        this.size = size;
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public int compareTo(HDTV tv) {

        if (this.getSize() > tv.getSize())
            return 1;
        else if (this.getSize() < tv.getSize())
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        HDTV[] mm = new HDTV[5];
        mm[0] = new HDTV(55, "Samsung");
        mm[1] = new HDTV(60, "Sony");
        mm[2] = new HDTV(43, "Onida");
        mm[3] = new HDTV(36, "Akai");
        mm[4] = new HDTV(80, "VideoCon");

        if (mm[4].compareTo(mm[3]) > 0) {
            System.out.println(mm[4].getBrand() + " is better.");
        } else {
            System.out.println(mm[3].getBrand() + " is better.");
        }
        for (int i = 0; i < mm.length; i++) {
            System.out.println( mm[i].getSize() + ":" + mm[i].getBrand());

        }
        Arrays.sort(mm, new SizeComparator());
        System.out.println("=====");
        for (int i = 0; i < mm.length; i++) {
            System.out.println( mm[i].getSize() + ":" + mm[i].getBrand());

        }

    }
}
class SizeComparator implements Comparator<HDTV> {
    @Override
    public int compare(HDTV tv1, HDTV tv2) {
        int tv1Size = tv1.getSize();
        int tv2Size = tv2.getSize();

        if (tv1Size > tv2Size) {
            return 1;
        } else if (tv1Size < tv2Size) {
            return -1;
        } else {
            return 0;
        }
    }
}
