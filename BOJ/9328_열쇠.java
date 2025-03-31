import java.io.*;
import java.util.*;

public class Main {
    static int H;
    static int W;
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int updateKey;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H + 2][W + 2];

            for (int i = 0; i < H + 2; i++) {
                Arrays.fill(map[i], '.');
            }

            for (int i = 1; i <= H; i++) {
                String row = br.readLine();
                for (int j = 1; j <= W; j++) {
                    map[i][j] = row.charAt(j - 1);
                }
            }

            int keys = 0;
            String key = br.readLine();
            if (!key.equals("0")) {
                for (int i = 0; i < key.length(); i++) {
                    int idx = key.charAt(i) - 'a';
                    keys |= (1 << idx);
                }
            }

            int docCount = 0;
            while (true) {
                visited = new boolean[H + 2][W + 2];
                int newKey = keys;

                docCount += bfs(newKey);
                newKey = updateKey;
                if (newKey != keys) {
                    keys = newKey;
                } else {
                    break;
                }
            }

            sb.append(docCount).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(int keys) {
        int docCount = 0;
        updateKey = keys;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (map[nx][ny] == '*') continue;
                if (visited[nx][ny]) continue;

                if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
                    int idx = map[nx][ny] - 'A';

                    if ((updateKey & (1 << idx)) == 0) continue;
                } else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
                    int idx = map[nx][ny] - 'a';
                    updateKey |= (1 << idx);
                    map[nx][ny] = '.';
                } else if (map[nx][ny] == '$') {
                    docCount++;
                    map[nx][ny] = '.';
                }
                visited[nx][ny] = true;
                queue.offer(new Point(nx, ny));
            }
        }

        return docCount;
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= H + 2 || y < 0 || y >= W + 2;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}