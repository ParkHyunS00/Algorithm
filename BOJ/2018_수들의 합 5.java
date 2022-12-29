import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int start = 1;
        int end = 1;
        int cnt = 1;
        int sum = 1;

        while(end != n){
            if (sum > n){
                sum -= start;
                start++;
            }
            else if (sum == n){
                cnt++;
                end++;
                sum += end;
            }
            else{
                end++;
                sum += end;
            }
        }
        
        System.out.println(cnt);
    }
}