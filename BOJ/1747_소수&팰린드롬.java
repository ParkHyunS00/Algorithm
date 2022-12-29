import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int[] max = new int[10000001];
        max[0] = 0; max[1] = 0;

        for(int i=2; i<max.length; i++){
            max[i] = i;
        }
        for(int i=2; i<max.length; i++){
            if(max[i] == 0) continue;

            for(int j=i+i; j<max.length; j+=i){
                max[j] = 0;
            }
        }

        for(int i=start; i<max.length;i++){
            if(max[i] != 0){
                if(find_palindrome(max[i])){
                    System.out.println(max[i]);
                    break;
                }
            }
        }
    }

    public static boolean find_palindrome(int n){
        char[] str = String.valueOf(n).toCharArray();
        int end_idx = str.length - 1;

        for(int i=0; i<str.length/2; i++){
            if(str[i] != str[end_idx])
                return false;
            end_idx--;
        }

        return true;
    }
}
