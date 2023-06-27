import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String brackets = sc.next();

        if (!isValid(brackets)){
            System.out.println(0);
        }
        else{
            System.out.println(solve(brackets));
        }
    }

    // 올바른 괄호인지 검사
    public static boolean isValid(String brackets){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<brackets.length(); i++){
            switch (brackets.charAt(i)) {
                case ')':
                    if (stack.isEmpty()) return false;
                    if (stack.peek() == '(') stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty()) return false;
                    if (stack.peek() == '[') stack.pop();
                    break;
                default:
                    stack.push(brackets.charAt(i));
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static int solve(String brackets){
        Stack<Character> stack = new Stack<>();
        int calc = 1, result = 0;

        for (int i=0; i<brackets.length(); i++){
            switch (brackets.charAt(i)){
                case '(':
                    stack.push(brackets.charAt(i));
                    calc *= 2;
                    break;
                case '[':
                    stack.push(brackets.charAt(i));
                    calc *= 3;
                    break;
                case ')':
                    if (brackets.charAt(i-1) == '(') result += calc;
                    stack.pop();
                    calc /= 2;
                    break;
                case ']':
                    if (brackets.charAt(i-1) == '[') result += calc;
                    stack.pop();
                    calc /= 3;
                    break;
            }
        }
        return result;
    }
}
