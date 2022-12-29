import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int [n+1];
        arr[0] = 0; arr[1] = 0;

        for(int i=2; i <= n; i++){
            arr[i] = i;
        }

        for(int i=2; i<=Math.sqrt(n); i++){
            if(arr[i] == 0)
                continue;

            for(int j = 2*i; j<=n; j+=i){
                arr[j] = 0;
            }
        }

        for(int i = m;i<=n;i++){
            if(arr[i] != 0)
                System.out.println(arr[i]);
        }
    }
}