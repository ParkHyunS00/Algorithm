import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long a = sc.nextLong();
        long b = sc.nextLong();
        long gcd = gcd(a, b);

        while(gcd > 0){
            bw.write("1");
            gcd--;
        }

        bw.flush();
        bw.close();
    }
    
    public static long gcd(long a, long b){
        if(b == 0)
            return a;
        else
          return gcd(b, a%b);
    }
}