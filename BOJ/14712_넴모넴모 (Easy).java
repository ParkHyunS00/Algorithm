import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static boolean[][] map;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        dfs(0, 0);

        System.out.print(res);
    }

    static void dfs(int x, int y) {
        if (x == N) {
            res++;
            return;
        }

        int nx = (y == M - 1) ? x + 1 : x;
        int ny = (y == M - 1) ? 0 : y + 1;

        dfs(nx, ny);

        if (!check(x, y)) {
            map[x][y] = true;
            dfs(nx, ny);
            map[x][y] = false;
        }
    }

    static boolean check(int x, int y) {
        return x > 0 && y > 0 && map[x - 1][y - 1] && map[x - 1][y] && map[x][y - 1];
    }
}