import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] sticks = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        char prev = ' ';

        for (char c : sticks){
            if (c == '(') stack.push(c);
            else if (c == ')'){
                stack.pop();
                if (prev == '(')
                    result += stack.size();
                else if (prev == ')')
                    result++;
            }
            prev = c;
        }

        System.out.println(result);
    }
}
