import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken( ));
        long max = Long.parseLong(st.nextToken( ));
        boolean[] check = new boolean[(int)(max - min + 1)];
        int answer = (int)(max - min + 1);
        long i = 2;

        while(i*i <= max){
            long startIdx = min / (i*i);
            if(min % (i*i) != 0)
                startIdx++;

            while(startIdx * (i*i) <= max){
                if(check[(int)(startIdx * (i*i) - min)] == false){
                    check[(int)(startIdx * (i*i) - min)] = true;
                    answer--;
                }
                startIdx++;
            }
            i++;
        }
        System.out.println(answer);
    }
}