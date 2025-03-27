import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int H;
    static boolean[][] arr;
    static int res = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = true;
        }

        if (check()) {
            System.out.print(0);
            return;
        }

        dfs(0);

        System.out.print(res > 3 ? -1 : res);
    }

    static void dfs(int count) {
        if (check()) {
            res = Math.min(res, count);
            return;
        }

        if (count >= 3 || count >= res) return;

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (canPlace(i, j)) {
                    arr[i][j] = true;
                    dfs(count + 1);
                    arr[i][j] = false;
                }
            }
        }
    }

    static boolean canPlace(int a, int b) {
        if (b >= N) return false;
        if (arr[a][b]) return false;
        if (b > 1 && arr[a][b-1]) return false;
        if (b < N-1 && arr[a][b+1]) return false;

        return true;
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int cur = i;

            for (int height = 1; height <= H; height++) {
                if (cur < N && arr[height][cur]){
                    cur++;
                } else if (cur > 1 && arr[height][cur-1]){
                    cur--;
                }
            }

            if (cur != i) return false;
        }

        return true;
    }
}