import java.io.*;
import java.util.Scanner;

public class Main {
    public static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    public static boolean isPrime(int num){
        for(int i=2; i<num; i++){
            if((num % i) == 0){
                return false;
            }
        }
        return true;
    }

    public static void DFS(int num, int idx){
        if(idx == n){
            if(isPrime(num)){
                System.out.println(num);
                //return;
            }
        }

        for(int i=1; i<10; i++){
            if(i % 2 == 0){
                continue;
            }

            if(isPrime((num * 10) + i)){
                DFS((num * 10) + i, idx+1);
            }
        }
    }
}