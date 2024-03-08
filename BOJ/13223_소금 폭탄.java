import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] now = sc.nextLine().split(":"), dropTime = sc.nextLine().split(":");

        int nowSecAmount = Integer.parseInt(now[0]) * 3600 + Integer.parseInt(now[1]) * 60 + Integer.parseInt(now[2]);
        int dropSecAmount = Integer.parseInt(dropTime[0]) * 3600 + Integer.parseInt(dropTime[1]) * 60 + Integer.parseInt(dropTime[2]);
        int needSecAmount = dropSecAmount - nowSecAmount;

        if (needSecAmount <= 0) needSecAmount += (24 * 3600);

        int[] result = new int[3];
        result[0] = needSecAmount / 3600;
        needSecAmount %= 3600;

        result[1] = needSecAmount / 60;
        needSecAmount %= 60;

        result[2] = needSecAmount;

        System.out.printf("%02d:%02d:%02d", result[0], result[1], result[2]);
    }
}