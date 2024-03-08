import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine(), word2 = sc.nextLine();
        int[] word1AlphabetCnt = new int[26], word2AlphabetCnt = new int[26];

        for (int i=0; i<word1.length(); i++) {
            word1AlphabetCnt[word1.charAt(i) - 97]++;
        }

        for (int i=0; i<word2.length(); i++) {
            word2AlphabetCnt[word2.charAt(i) - 97]++;
        }

        int removeCnt = 0;
        for (int i=0; i<26; i++) {
            removeCnt += Math.abs(word1AlphabetCnt[i] - word2AlphabetCnt[i]);
        }
        System.out.println(removeCnt);
    }
}