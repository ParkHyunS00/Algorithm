import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine(), searchWord = sc.nextLine();
        String removeWord = word.replace(searchWord, "");
        int wordLength = word.length();
        int removeWordLength = removeWord.length();

        System.out.print((wordLength - removeWordLength) / searchWord.length());
    }
}