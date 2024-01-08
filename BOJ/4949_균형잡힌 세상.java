import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            String result = isMatch(str) ? "yes" : "no";
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static boolean isMatch(String input) {
        char[] charArr = input.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<charArr.length; i++) {
            if (charArr[i] == '[' || charArr[i] == '(') {
                stack.push(charArr[i]);
            } else if (charArr[i] == ']') {
                if (stack.isEmpty() || stack.peek() != '[')
                    return false;
                else
                    stack.pop();
            } else if (charArr[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return false;
                else
                    stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
