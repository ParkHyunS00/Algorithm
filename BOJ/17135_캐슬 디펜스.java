import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int D;
    static int[][] map;
    static boolean[] selected;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        selected = new boolean[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.print(res);
    }

    static void dfs(int start, int count) {
        if (count == 3) {
            res = Math.max(res, attack());
            return;
        }

        for (int i = start; i < M; i++) {
            if (!selected[i]) {
                selected[i] = true;
                dfs(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }

    static int attack() {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = Arrays.copyOf(map[i], M);
        }

        List<Integer> attackers = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            if (selected[i]) {
                attackers.add(i);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            Set<Point> remove = new HashSet<>();

            for (int attacker : attackers) {
                Point enemy = findEnemy(copyMap, attacker);
                if (enemy != null) {
                    remove.add(enemy);
                }
            }

            for (Point enemy : remove) {
                if (copyMap[enemy.x][enemy.y] == 1) {
                    copyMap[enemy.x][enemy.y] = 0;
                    count++;
                }
            }

            move(copyMap);
        }

        return count;
    }

    static void move(int[][] map) {
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < M; j++) {
                map[i][j] = map[i - 1][j];
            }
        }
        Arrays.fill(map[0], 0);
    }

    static Point findEnemy(int[][] map, int pos) {
        int[][] visited = new int[N][M];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(N - 1, pos));
        visited[N - 1][pos] = 1;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (map[cur.x][cur.y] == 1) {
                return cur;
            }

            if (visited[cur.x][cur.y] >= D) continue;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        return null;
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
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