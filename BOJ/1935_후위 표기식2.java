import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        double[] onlyOperand = new double[n];
        char[] formula = br.readLine().toCharArray();

        for(int i=0; i<n; i++){
            onlyOperand[i] = Double.parseDouble(br.readLine());
        }

        for (int i=0; i<formula.length; i++){
            if (Character.isAlphabetic(formula[i])){
                stack.push(onlyOperand[formula[i] - 'A']); // 핵심
            }
            else{
                double op2 = stack.pop();
                double op1 = stack.pop();
                double result;

                switch (formula[i]){
                    case '+':
                        result = op1 + op2;
                        stack.push(result);
                        break;
                    case '-':
                        result = op1 - op2;
                        stack.push(result);
                        break;
                    case '*':
                        result = op1 * op2;
                        stack.push(result);
                        break;
                    case '/':
                        result = op1 / op2;
                        stack.push(result);
                        break;
                }
            }
        }
        System.out.printf("%.2f%n", stack.pop());
    }
}