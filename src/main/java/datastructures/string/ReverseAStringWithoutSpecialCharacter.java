package datastructures.string;

public class ReverseAStringWithoutSpecialCharacter {
    private char[] arr ;

    public ReverseAStringWithoutSpecialCharacter(String s) {
        this.arr = s.toCharArray();
    }

    public static void main(String[] args) {
        String s = "ab$cd";
        ReverseAStringWithoutSpecialCharacter mm = new ReverseAStringWithoutSpecialCharacter(s);
        System.out.println(mm.reverse());
    }
    public  String  reverse(){
        int start = 0 ;
        int end = arr.length-1;
        while(start < end){
            while (!isalphabet(start)){
                start++;
            }
            while (!isalphabet(end)) {
                end--;
            }
            swap (start,end);
            start++;
            end--;
        }
        return new String(arr);
    }

    private void swap(int i,int j){
        char temp =arr[i];
         arr[i] = arr[j];
        arr[j] = temp;
    }
    private boolean isalphabet(int i){
        return ( ( arr[i] >= 'A') &&  (arr[i] <= 'Z')) || ( ( arr[i] >= 'a') &&  (arr[i] <= 'z')) ;
    }
}
