import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static Queue<Point> trees = new LinkedList<>();
    static Point start;
    static Point dest;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);

                if (map[i][j] == '+') {
                    dist[i][j] = 0;
                    trees.offer(new Point(i, j, 0));
                }
                else if (map[i][j] == 'V') start = new Point(i, j, 0);
                else if (map[i][j] == 'J') dest = new Point(i, j, 0);
            }
        }

        setDist();
        System.out.print(findPath());
    }

    static int findPath() {
        int[][] cost = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cost[i], -1);
        }
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> p2.cost - p1.cost);
        pq.offer(new Point(start.x, start.y, dist[start.x][start.y]));
        cost[start.x][start.y] = dist[start.x][start.y];

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            if (cost[cur.x][cur.y] != cur.cost) continue;

            if (cur.x == dest.x && cur.y == dest.y) {
                return cur.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx, ny)) continue;

                int next = Math.min(cur.cost, dist[nx][ny]);
                if (next > cost[nx][ny]) {
                    cost[nx][ny] = next;
                    pq.offer(new Point(nx, ny, next));
                }
            }
        }

        return 0;
    }

    static void setDist() {
        while (!trees.isEmpty()) {
            Point cur = trees.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    trees.offer(new Point(nx, ny, 0));
                }
            }
        }
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }

    static class Point {
        int x;
        int y;
        int cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}