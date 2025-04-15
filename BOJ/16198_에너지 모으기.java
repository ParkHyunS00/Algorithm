import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int res = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr, 0);

        System.out.print(res);
    }

    static void dfs(int[] arr, int sum) {
        if (arr.length == 2) {
            res = Math.max(res, sum);
            return;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            int tmp = arr[i - 1] * arr[i + 1];
            int[] next = new int[arr.length - 1];

            for (int j = 0; j < i; j++) {
                next[j] = arr[j];
            }
            for (int j = i + 1; j < arr.length; j++) {
                next[j - 1] = arr[j];
            }

            dfs(next, sum + tmp);
        }
    }
}