import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        StringBuffer bf = new StringBuffer();
        Stack<Integer> myStack = new Stack<>();
        int num = 1;
        boolean result = true;

        for(int i =0; i < n; i++){
            int now = arr[i]; // 입력받은 수
            if(now >= num){
                while(now >= num){
                    myStack.push(num);
                    num++;
                    bf.append("+\n");
                }
                myStack.pop();
                bf.append("-\n");
            }
            else{
                int tmp = myStack.pop();
                if(tmp > now){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else{
                    bf.append("-\n");
                }
            }
        }
        
        if(result) System.out.println(bf.toString());
    }
}