import java.io.*;
import java.util.*;

public class Main {
    static int W;
    static int H;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int totalDirty;
    static int sx;
    static int sy;
    static List<Point> dirtyPoints;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) break;

            map = new char[H][W];
            dirtyPoints = new ArrayList<>();
            totalDirty = 0;

            for (int i = 0; i < H; i++) {
                String row = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = row.charAt(j);

                    if (map[i][j] == 'o') {
                        sx = i;
                        sy = j;
                    } else if (map[i][j] == '*') {
                        dirtyPoints.add(new Point(i, j, totalDirty));
                        totalDirty++;
                    }
                }
            }

            visited = new boolean[H][W][1 << totalDirty];

            sb.append(bfs()).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs() {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(sx, sy, 0, 0));
        visited[sx][sy][0] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.dirty == (1 << totalDirty) - 1) {
                return cur.move;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx, ny)) continue;
                if (map[nx][ny] == 'x') continue;

                int nextDirty = cur.dirty;
                if (map[nx][ny] == '*') {
                    for (Point p : dirtyPoints) {
                        if (p.x == nx && p.y == ny) {
                            nextDirty |= (1 << p.index);
                            break;
                        }
                    }
                }

                if (!visited[nx][ny][nextDirty]) {
                    visited[nx][ny][nextDirty] = true;
                    queue.offer(new State(nx, ny, cur.move + 1, nextDirty));
                }
            }
        }

        return -1;
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= H || y < 0 || y >= W;
    }

    static class State {
        int x;
        int y;
        int move;
        int dirty;

        public State(int x, int y, int move, int dirty) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.dirty = dirty;
        }
    }

    static class Point {
        int x;
        int y;
        int index;

        public Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }
}