import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[1000001];
        int[] sum = new int[1000001];
        int tmp = 0;
        
        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
            tmp += arr[i];
            sum[i] = tmp;
        }

        for(int i =1; i<=m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(sum[end] - sum[start - 1]);
        }
    }
}