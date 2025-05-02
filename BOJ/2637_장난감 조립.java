import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] indegree;
    static List<Node>[] graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        indegree = new int[N + 1];
        graph = new List[N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            graph[Y].add(new Node(X, K));
            indegree[X]++;
        }

        sort();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dp[N][i] > 0) {
                sb.append(i).append(" ").append(dp[N][i]).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void sort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                dp[i][i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Node next : graph[cur]) {
                for (int i = 1; i <= N; i++) {
                    dp[next.u][i] += (dp[cur][i] * next.weight);
                }

                indegree[next.u]--;
                if (indegree[next.u] == 0) {
                    queue.offer(next.u);
                }
            }
        }
    }

    static class Node {
        int u;
        int weight;

        public Node(int u, int weight) {
            this.u = u;
            this.weight = weight;
        }
    }
}