import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for(int i =0;i<n;i++){
            int input = sc.nextInt();
            if(input>1)
                plusPq.add(input);
            else if(input == 1)
                one++;
            else if(input == 0)
                zero++;
            else
                minusPq.add(input);
        }

        int sum = 0;
        while(plusPq.size() > 1){
            int data1 = plusPq.remove();
            int data2 = plusPq.remove();
            sum += data1*data2;
        }

        if(!plusPq.isEmpty())
            sum += plusPq.remove();

        while(minusPq.size() > 1){
            int data1 = minusPq.remove();
            int data2 = minusPq.remove();
            sum += data1 * data2;
        }

        if(!minusPq.isEmpty()){
            if(zero == 0)
                sum += minusPq.remove();
        }
        
        sum += one;
        System.out.println(sum);
    }
}