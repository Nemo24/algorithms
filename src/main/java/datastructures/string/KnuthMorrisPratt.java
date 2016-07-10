package datastructures.string;

public class KnuthMorrisPratt {
    int pattLength;
    int dfa[][] ;

    public KnuthMorrisPratt(String pattern) {
        pattLength = pattern.length();
        this.dfa = new int[pattLength][pattLength];
    }
    public int search(String text){
        int N = text.length();
        for (int i = 0,j=0; i < N && j< pattLength; i++) {
            j = dfa[text.charAt(i)][j];
            if (j == pattLength) return i - pattLength;
        }
            return N;

    }

}
