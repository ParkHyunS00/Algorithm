import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<Point> borders = new ArrayList<>();
    static int[] parent;
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        area = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j, idx);
                    idx++;
                }
            }
        }

        parent = new int[idx];
        Arrays.fill(parent, -1);

        makeBridge();

        Collections.sort(edges);
        int sum = 0;
        int count = 0;

        for (Edge e : edges) {
            if (isSameSet(e.u, e.v)) continue;

            union(e.u, e.v);
            sum += e.weight;
            count++;

            if (count == idx - 2) break;
        }

        System.out.print((count == idx - 2) ? sum : -1);
    }

    static void makeBridge() {
        for (Point p : borders) {
            for (int i = 0; i < 4; i++) {
                int length = 0;
                int nx = p.x;
                int ny = p.y;

                while (true) {
                    nx += dx[i];
                    ny += dy[i];

                    if (outOfRange(nx, ny)) break;
                    if (area[nx][ny] == area[p.x][p.y]) break;

                    if (area[nx][ny] != 0 && area[nx][ny] != area[p.x][p.y]) {
                        if (length >= 2) {
                            edges.add(new Edge(area[p.x][p.y], area[nx][ny], length));
                        }
                        break;
                    }

                    length++;
                }
            }
        }
    }

    static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        if (parent[a] > parent[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        parent[a] += parent[b];
        parent[b] = a;
    }

    static boolean isSameSet(int a, int b) {
        return find(a) == find(b);
    }

    static void bfs(int x, int y, int idx) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        area[x][y] = idx;
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (visited[nx][ny]) continue;

                if (map[nx][ny] == 0) borders.add(new Point(cur.x, cur.y));
                if (map[nx][ny] == 1) {
                    area[nx][ny] = idx;
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny));
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

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}