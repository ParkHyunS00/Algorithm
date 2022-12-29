import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i<n;i++){
            int input = sc.nextInt();
            pq.add(input);
        }

        int sum = 0;
        while(pq.size() != 1){
            int data1 = pq.remove();
            int data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1 + data2);
        }
        
        System.out.println(sum);
    }
}