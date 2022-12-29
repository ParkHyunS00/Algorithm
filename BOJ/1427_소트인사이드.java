import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] tmp = str.toCharArray();
        int[] num = new int[str.length()];

        for(int i =0;i<str.length();i++){
            num[i] = tmp[i] - '0';
        }

        for(int i = 0;i<str.length();i++){
            int maxIdx = i;

            for(int j = i+1; j<str.length();j++){
                if(num[j] > num[maxIdx]){
                    maxIdx = j;
                }

                if(num[i]<num[maxIdx]){
                    int temp = num[i];
                    num[i] = num[maxIdx];
                    num[maxIdx] = temp;
                }
            }
        }
        
        for(int i =0;i<str.length();i++){
            System.out.printf("%d", num[i]);
        }
    }
}