package puzzles;

/**
 * Created by mm on 31/8/15.
 */
public class Permutation {
    public void permutation(String s)
    {
        permutation("",s);
    }
    private void permutation(String acc, String str){
        int length = str.length();
        if (length ==0) System.out.println(acc);
        else {
            for (int i = 0; i < length; i++) {
                 permutation(acc+ str.charAt(i),str.substring(0,i)  + str.substring(i+1) );

            }
        }
    }

    public static void main(String[] args) {
        Permutation mm = new Permutation();
        mm.permutation("hello");
    }
}
