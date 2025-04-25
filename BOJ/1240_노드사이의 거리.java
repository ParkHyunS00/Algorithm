import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, dist));
            graph[v].add(new Node(u, dist));
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(bfs(start, end)).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(new Node(start, 0));
        visited[start] = true;

        int ret = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.v == end) {
                ret = cur.dist;
                break;
            }

            for (Node next : graph[cur.v]) {
                if (!visited[next.v]) {
                    visited[next.v] = true;
                    queue.offer(new Node(next.v, cur.dist + next.dist));
                }
            }
        }

        return ret;
    }

    static class Node {
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }
}