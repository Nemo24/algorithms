package basicjava.equals;

/**
 * Created by mm on 29/8/15.
 */
public class MyObject {
    int a;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyObject myObject = (MyObject) o;

        if (a != myObject.a) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return a;
    }

    public MyObject(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        MyObject o1 = new MyObject(1);
        MyObject o2 = new MyObject(1);
        MyObject o3 = new MyObject(3);
        if (o1 == o2 ){
            System.out.printf("equal");
        } else{
            System.out.println("not qeual");
        }


    }
}
