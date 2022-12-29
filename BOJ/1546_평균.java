import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] grade = new int[1000];

        for(int i =0;i<size;i++){
            grade[i] = sc.nextInt();
        }

        int max = grade[0];
        int sum = 0;
        for(int i =0;i<size;i++){
            if(max < grade[i]) max = grade[i];
            sum += grade[i];
        }
        
        System.out.println(sum*100.0/max/size);
    }
}