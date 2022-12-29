import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 0;
        char[] ori = new char[s];
        int[] check = new int[4];
        int[] my = new int[4];
        ori = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());

        int checkSec = 0;
        for(int i=0; i<4; i++){
            check[i] = Integer.parseInt(st.nextToken());
            if(check[i] == 0) checkSec++;
        }

        for(int i =0;i<p;i++){
            switch (ori[i]){
                case 'A':
                    my[0]++;
                    if(my[0] == check[0]) checkSec++;
                    break;
                case 'C':
                    my[1]++;
                    if(my[1] == check[1]) checkSec++;
                    break;
                case 'G':
                    my[2]++;
                    if(my[2] == check[2]) checkSec++;
                    break;
                case 'T':
                    my[3]++;
                    if(my[3] == check[3]) checkSec++;
                    break;
            }
        }

        if(checkSec == 4) result++;

        for(int i =p; i<s;i++){
            int j = i-p;
            switch (ori[i]){
                case 'A':
                    my[0]++;
                    if(my[0] == check[0]) checkSec++;
                    break;
                case 'C':
                    my[1]++;
                    if(my[1] == check[1]) checkSec++;
                    break;
                case 'G':
                    my[2]++;
                    if(my[2] == check[2]) checkSec++;
                    break;
                case 'T':
                    my[3]++;
                    if(my[3] == check[3]) checkSec++;
                    break;
            }

            switch (ori[j]){
                case 'A':
                    if(my[0] == check[0]) checkSec--;
                    my[0]--;
                    break;
                case 'C':
                    if(my[1] == check[1]) checkSec--;
                    my[1]--;
                    break;
                case 'G':
                    if(my[2] == check[2]) checkSec--;
                    my[2]--;
                    break;
                case 'T':
                    if(my[3] == check[3]) checkSec--;
                    my[3]--;
                    break;
            }

            if(checkSec == 4) result++;
        }
        
        System.out.println(result);
    }
}