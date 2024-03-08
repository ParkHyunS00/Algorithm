import java.util.Scanner;

public class Main {
    public static int solve(String str) {
        if (str.equals(" ")) return 0;
        String[] strArr = str.trim().split(" ");
        return strArr.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(solve(s));
    }
}