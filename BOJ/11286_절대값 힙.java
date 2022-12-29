import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2)->{
           int first = Math.abs(o1);
           int second = Math.abs(o2);

           if(first == second)
               return (o1 > o2 ? 1 : -1);
           else
               return (first - second);
        });

        for(int i=0; i<n; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(myQueue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(myQueue.poll());
            }
            else{
                myQueue.add(input);
            }
        }
    }
}