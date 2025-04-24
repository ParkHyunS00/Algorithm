import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Node>[] graph;
    static int start;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int max = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            max = Math.max(max, C);
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int lo = 1;
        int hi = max;
        int res = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (bfs(mid)) {
                lo = mid + 1;
                res = mid;
            } else {
                hi = mid - 1;
            }
        }

        System.out.print(res);
    }

    static boolean bfs(int limit) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.v == end) {
                return true;
            }

            for (Node next : graph[cur.v]) {
                if (!visited[next.v] && next.weight >= limit) {
                    visited[next.v] = true;
                    queue.offer(new Node(next.v, next.weight));
                }
            }
        }

        return false;
    }

    static class Node {
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }
}