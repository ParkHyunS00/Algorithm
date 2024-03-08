import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int count = 0;

        for (int i=0; i<croatia.length; i++) {
            if (word.contains(croatia[i])) {
                word = word.replace(croatia[i], " ");
            }
        }

        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) == ' ') {
                count++;
            }
        }
        word = word.replace(" ", "");
        System.out.print(word.length() + count);
    }
}