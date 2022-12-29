import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] sum = new int[n];
        int tmp = 0;
        int result = 0;

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=1; i<n; i++){
            int val = arr[i];
            for(int j=i-1; j>=0; j--){
                if(val < arr[j]){
                    arr[j+1] = arr[j];
                    arr[j] = val;
                }
                else
                    break;
            }
        }

        for(int i=0; i<n; i++){
            tmp += arr[i];
            sum[i] = tmp;
        }

        for(int i=0; i<n; i++){
            result += sum[i];
        }
        System.out.println(result);
    }
}