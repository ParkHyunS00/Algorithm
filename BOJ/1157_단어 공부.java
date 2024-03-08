import java.util.Scanner;

public class Main {
    public static int solve(String word) {
        int[] alphabetCnt = new int[26];

        for (int i=0; i<word.length(); i++) {
            alphabetCnt[word.charAt(i) - 65]++;
        }

        int maxAscii = alphabetCnt[0], maxIdx = 0;
        for (int i =1; i<26; i++) {
            if (maxAscii < alphabetCnt[i]) {
                maxIdx = i;
                maxAscii = alphabetCnt[i];
            }
        }

        for (int i=0; i<26; i++) {
            if (maxAscii == alphabetCnt[i] && maxIdx != i) return -1;
        }

        return maxIdx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toUpperCase();
        int result;

        if ((result = solve(word)) != -1) System.out.print((char)(result + 65));
        else System.out.print("?");
    }
}