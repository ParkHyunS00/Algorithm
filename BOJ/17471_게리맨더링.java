import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] people;
    static int[] group;
    static List<Integer>[] graph;
    static final int RED = 1;
    static final int BLUE = 2;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new int[N + 1];
        group = new int[N + 1];
        graph = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= count; j++) {
                graph[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dfs(0, 0, 0);

        System.out.print(res == Integer.MAX_VALUE ? -1 : res);
    }

    static void dfs(int idx, int redCount, int blueCount) {
        if (idx > N) {
            if (redCount == 0 || blueCount == N) return;

            if (check()) {
                int redSum = 0;
                int blueSum = 0;
                for (int i = 1; i <= N; i++) {
                    if (group[i] == RED) redSum += people[i];
                    else if (group[i] == BLUE) blueSum += people[i];
                }

                int diff = Math.abs(redSum - blueSum);
                res = Math.min(res, diff);
            }
            return;
        }

        group[idx] = RED;
        dfs(idx + 1, redCount + 1, blueCount);

        group[idx] = BLUE;
        dfs(idx + 1, redCount, blueCount + 1);
    }

    static boolean check() {
        int redStart = 0;
        for (int i = 1; i <= N; i++) {
            if (group[i] == RED) {
                redStart = i;
                break;
            }
        }

        int blueStart = 0;
        for (int i = 1; i <= N; i++) {
            if (group[i] == BLUE) {
                blueStart = i;
                break;
            }
        }

        boolean[] visitedRed = new boolean[N + 1];
        bfs(visitedRed, redStart, RED);

        boolean[] visitedBlue = new boolean[N + 1];
        bfs(visitedBlue, blueStart, BLUE);

        for (int i = 1; i <= N; i++) {
            if (group[i] == RED && !visitedRed[i]) return false;
        }

        for (int i = 1; i <= N; i++) {
            if (group[i] == BLUE && !visitedBlue[i]) return false;
        }

        return true;
    }

    static void bfs(boolean[] visited, int start, int area) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (!visited[next] && group[next] == area) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}