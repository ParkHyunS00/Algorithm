import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int m = sc.nextInt();

        for(int i=0; i<m; i++){
            boolean find = false;
            int target = sc.nextInt();
            int start = 0;
            int end = n-1;

            while(start <= end){
                int midIdx = (start + end)/2;
                int midVal = arr[midIdx];
                if(target > midVal){
                    start = midIdx + 1;
                }
                else if(target < midVal){
                    end = midIdx - 1;
                }
                else{
                    find = true;
                    break;
                }
            }

            if(find)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}