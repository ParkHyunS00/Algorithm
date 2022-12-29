import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;
        
        for(long i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                result = result - result/i;
                while(n%i==0){
                    n /= i;
                }
            }
        }

        if(n>1)
            result = result - result/n;
        System.out.println(result);
    }
}