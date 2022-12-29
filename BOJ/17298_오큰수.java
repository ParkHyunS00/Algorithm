import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];
        String[] buff = bf.readLine().split(" ");
        Stack<Integer> myStack = new Stack<>();

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(buff[i]);
        }

        myStack.push(0);
        for(int i=1; i<n; i++){
            while(!myStack.empty() && arr[myStack.peek()] < arr[i]){
                result[myStack.pop()] = arr[i];
            }
            myStack.push(i);
        }

        while(!myStack.empty()){
            result[myStack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<n; i++){
            bw.write(result[i]+" ");
        }
        
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}