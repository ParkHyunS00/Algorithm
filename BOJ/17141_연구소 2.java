import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static List<Point> virus = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) virus.add(new Point(i, j));
            }
        }

        selectVirus(new ArrayList<>(), 0);

        System.out.print(res == Integer.MAX_VALUE ? -1 : res);
    }

    static void selectVirus(List<Point> select, int idx) {
        if (select.size() == M) {
            res = Math.min(res, bfs(select));
            return;
        }

        for (int i = idx; i < virus.size(); i++) {
            select.add(virus.get(i));
            selectVirus(select, i + 1);
            select.remove(select.size() - 1);
        }
    }

    static int bfs(List<Point> select) {
        Queue<Point> queue = new LinkedList<>();
        int[][] visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }
        for (Point p : select) {
            visited[p.x][p.y] = 0;
            queue.offer(p);
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (map[nx][ny] == 1) continue;
                if (visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == -1 && map[i][j] != 1) return Integer.MAX_VALUE;
                max = Math.max(max, visited[i][j]);
            }
        }
        return max;
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
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