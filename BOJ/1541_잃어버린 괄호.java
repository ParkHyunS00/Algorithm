import java.io.*;
import java.util.*;

public class Main {
    public static int solve(String str){
        int result = 0;
        String[] tmp = str.split("[+]");
        
        for(int i = 0;i<tmp.length;i++){
            result += Integer.parseInt(tmp[i]);
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] str = input.split("-");
        int ans = 0;
        
        for(int i =0; i<str.length; i++){
            int tmp = solve(str[i]);

            if(i == 0)
                ans += tmp;
            else
                ans -= tmp;
        }

        System.out.println(ans);
    }
}