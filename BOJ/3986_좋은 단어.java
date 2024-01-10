import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int i=0; i<n; i++) {
            result += solve(br.readLine());
        }

        System.out.println(result);
    }

    static int solve(String word) {
        char[] wordArr = word.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<wordArr.length; i++) {
            if (!stack.isEmpty() && stack.peek() == wordArr[i]) {
                stack.pop();
            } else {
                stack.push(wordArr[i]);
            }
        }

        if (stack.isEmpty()) return 1;
        else return 0;
    }
}