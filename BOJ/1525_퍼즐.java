import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[3][3];
    static int[][] goal = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
    };
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(bfs());
    }

    static int bfs() {
        if (isDone(map)) return 0;

        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(toString(map));

        int sx = 0;
        int sy = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 0) {
                    sx = i;
                    sy = j;
                }
            }
        }
        queue.offer(new State(map, 0, sx, sy));

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (outOfRange(nx, ny)) continue;

                int[][] nextArr = deepCopy(cur.map);
                int tmp = nextArr[nx][ny];
                nextArr[nx][ny] = nextArr[cur.x][cur.y];
                nextArr[cur.x][cur.y] = tmp;

                String next = toString(nextArr);
                if (!visited.contains(next)) {
                    visited.add(next);

                    if (next.equals("123456780")) {
                        return cur.count + 1;
                    }
                    queue.offer(new State(nextArr, cur.count + 1, nx, ny));
                }
            }
        }

        return -1;
    }

    static int[][] deepCopy(int[][] arr) {
        int[][] ret = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ret[i][j] = arr[i][j];
            }
        }
        return ret;
    }

    static boolean outOfRange(int x, int y) {
        return x < 0 || x >= 3 || y < 0 || y >= 3;
    }

    static String toString(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(arr[i][j]);
            }
        }
        return sb.toString();
    }

    static boolean isDone(int[][] arr) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] != goal[i][j]) return false;
            }
        }
        return true;
    }

    static class State {
        int[][] map;
        int count;
        int x;
        int y;

        public State(int[][] map, int count, int x, int y) {
            this.map = map;
            this.count = count;
            this.x = x;
            this.y = y;
        }
    }
}