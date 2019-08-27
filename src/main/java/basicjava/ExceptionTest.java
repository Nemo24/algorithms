package basicjava;

public class ExceptionTest {
    public static boolean  isNull(int i ){
        try {
            if (i > 0) return true;
            else {
                int d = 3 / i;
            }
            return false;
        }
         finally {
            System.out.println("hello");
                return true;
            }

        }

    public static void main(String[] args) throws Exception {
        System.out.println(isNull(0));
        System.out.println("hello world");

    }
}
