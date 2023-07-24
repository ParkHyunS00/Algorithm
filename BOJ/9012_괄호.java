import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.println(isValid(st.nextToken()));
        }
    }

    public static String isValid(String str){
        char[] strArr = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<strArr.length; i++){
            switch (strArr[i]){
                case '(':
                    stack.push(strArr[i]);
                    break;
                case ')':
                    if (stack.isEmpty()) return "NO";
                    stack.pop();
                    break;
            }
        }

        if (stack.isEmpty()) return "YES";
        else return "NO";
    }
}
