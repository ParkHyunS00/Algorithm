import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> myStack = new Stack<>();
        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++){
            int input = Integer.parseInt(br.readLine());
            if(input != 0){
                myStack.push(input);
            }
            else{
                myStack.pop();
            }
        }

        int result = 0;
        while(!myStack.isEmpty()){
            result += myStack.pop();
        }
        
        bw.write(result+" ");
        bw.flush();
        bw.close();
    }
}