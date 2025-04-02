import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            rotate(map, N, M);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void rotate(int[][] map, int N, int M) {
        int repeat = Math.min(N, M) / 2;

        for (int i = 0; i < repeat; i++) {
            int top = i;
            int left = i;
            int bottom = N - i - 1;
            int right = M - i - 1;
            int temp = map[top][left];

            for (int j = left; j < right; j++) {
                map[top][j] = map[top][j + 1];
            }

            for (int j = top; j < bottom; j++) {
                map[j][right] = map[j + 1][right];
            }

            for (int j = right; j > left; j--) {
                map[bottom][j] = map[bottom][j - 1];
            }

            for (int j = bottom; j > top + 1; j--) {
                map[j][left] = map[j - 1][left];
            }

            map[top + 1][left] = temp;
        }
    }
}