import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (u == -1 && v == -1) break;

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] res = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int[] ret = bfs(i);
            res[i] = Arrays.stream(ret).max().getAsInt();
        }

        int min = Arrays.stream(res).skip(1).min().getAsInt();
        int minCount = 0;
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (res[i] == min) {
                minCount++;
                candidates.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(minCount).append("\n");
        for (int n : candidates) {
            sb.append(n).append(" ");
        }

        System.out.print(sb);
    }

    static int[] bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        return dist;
    }
}