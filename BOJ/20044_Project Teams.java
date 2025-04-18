import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n * 2];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = arr[i] + arr[n * 2 - i - 1];
            min = Math.min(min, sum);
        }

        System.out.print(min);
    }
}