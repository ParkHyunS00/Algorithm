import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int result = 0;
        for(int i=n-1; i>=0; i--){
            if(arr[i] <= k){
                result += (k/arr[i]);
                k = k%arr[i];
            }
        }
        System.out.println(result);
    }
}