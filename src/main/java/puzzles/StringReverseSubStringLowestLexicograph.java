package puzzles;

/**
 * Created by mm on 5/3/16.
 */
public class StringReverseSubStringLowestLexicograph {
    public  static  void print(String str){
        int firstOccurenceofB = -1;
        int maxnumberOfA = 0;
        int currnumberOfA = 0;
        int maxIndexofA = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='b'){
                firstOccurenceofB=i;
                break;
            }
        }
        if (firstOccurenceofB == -1) {
            System.out.println("0,0");
            return;
        }
        boolean prevA = false;
        for (int i = firstOccurenceofB; i < str.length(); i++) {
                 if (str.charAt(i)=='a' ){
                     if (prevA) currnumberOfA++;
                     else {
                         currnumberOfA = 1;
                         prevA = true;
                     }
                     if (currnumberOfA > maxnumberOfA) {
                         maxIndexofA=i;
                         maxnumberOfA=currnumberOfA;
                     }
                 } else {

                     prevA=false;
                 }
         }
        System.out.println(""+firstOccurenceofB+","+maxIndexofA);
    }
    public static void main(String[] args) {
        String s1 = "abab";
        String s2 = "abba";
        String s3 = "bbaa";
        String s4 = "aaaa";
        String s5 = "babaabba";
        print(s1);
        print(s2);
        print(s3);
        print(s4);
        print(s5);


    }
}
