import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] list = new int[1000000];
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int tmp = sc.nextInt();
            list[i] = tmp;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                if(list[i] < list[j]){
                    int tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                }
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(list[i]);
        }
    }
}