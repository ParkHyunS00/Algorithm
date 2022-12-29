import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] obj1, int[] obj2){
                if(obj1[1] == obj2[1]){
                    return (obj1[0] - obj2[0]);
                }
                return (obj1[1] - obj2[1]);
            }
        });

        int cnt = 0;
        int end = 0;
        for(int i =0;i<n;i++){
            if(arr[i][0] >= end){
                end = arr[i][1];
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}