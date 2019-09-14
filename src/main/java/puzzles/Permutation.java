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
       // mm.permutation("hello");
        perm("hello",new StringBuilder());
    }

    public static void perm(String s , StringBuilder builder) {
        if (s.length()==0) {
            System.out.println(builder.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            int length = builder.length();
            perm(s.substring(0,i)+ s.substring(i+1),builder);
            builder.deleteCharAt(length-1);
        }
    }
}
