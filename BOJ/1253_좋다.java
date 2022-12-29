import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int cnt = 0;

        for(int i =0;i<n;i++){
            int start = 0; int end = n-1;

            while(start < end){
                if(arr[start] + arr[end] == arr[i]){
                    if(start != i && end != i){
                        cnt++;
                        break;
                    }
                    else if(start == i){
                        start++;
                    }
                    else{
                        end--;
                    }
                }
                else if(arr[start] + arr[end] < arr[i]){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        
        System.out.println(cnt);
    }
}