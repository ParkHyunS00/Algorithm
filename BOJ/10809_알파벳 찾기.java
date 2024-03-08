import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] alphabet = new int[26];
        boolean[] visited = new boolean[26];

        for (int i=0; i<26; i++) {
            alphabet[i] = -1;
        }

        for (int i=0; i<s.length(); i++) {
            if (!visited[s.charAt(i) - 97]){
                alphabet[s.charAt(i) - 97] = i;
                visited[s.charAt(i) - 97] = true;
            }
        }

        for (int i=0; i<26; i++) {
            System.out.print(alphabet[i] + " ");
        }

    }
}