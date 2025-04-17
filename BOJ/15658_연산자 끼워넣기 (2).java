import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.print(min);
    }

    static void dfs(int idx, int res) {
        if (idx == N) {
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        dfs(idx + 1, res + arr[idx]);
                        break;
                    case 1:
                        dfs(idx + 1, res - arr[idx]);
                        break;
                    case 2:
                        dfs(idx + 1, res * arr[idx]);
                        break;
                    case 3:
                        dfs(idx + 1, res / arr[idx]);
                        break;
                }
                operator[i]++;
            }
        }
    }
}