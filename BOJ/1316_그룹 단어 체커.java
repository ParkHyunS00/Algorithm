import java.util.Scanner;

public class Main {
    public static boolean solve(String word) {
        int[] alphaCount = new int[26];

        for (int i=0; i<word.length(); i++) {
            if (alphaCount[word.charAt(i) - 'a'] == 0 || word.charAt(i-1) == word.charAt(i))
                alphaCount[word.charAt(i) - 'a']++;
            else return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i=0; i<n; i++) {
            if (solve(sc.next())) count++;
        }

        System.out.print(count);
    }
}