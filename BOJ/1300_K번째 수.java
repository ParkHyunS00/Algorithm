import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int min = 1;
        int max = k;
        int ans = 0;

        while(min <= max){
            int mid = (min + max)/2;
            int cnt = 0;

            for(int i = 1; i<=n; i++){
                cnt += Math.min(mid/i, n);
            }
            if(cnt < k){
                min = mid + 1;
            }
            else{
                ans = mid;
                max = mid - 1;
            }
        }
        
        System.out.println(ans);
    }
}