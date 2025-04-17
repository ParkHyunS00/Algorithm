import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int D;
    static int E;
    static int[] height;
    static List<Node>[] graph;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        height = new int[N + 1];
        graph = new List[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, n));
            graph[b].add(new Node(a, n));
        }

        long[] up = dijkstra(1);
        long[] down = dijkstra(N);
        long res = Long.MIN_VALUE;

        for (int i = 2; i < N; i++) {
            if (up[i] != INF && down[i] != INF) {
                long value = ((long)E * height[i]) - ((long)D * (up[i] + down[i]));
                res = Math.max(res, value);
            }
        }

        System.out.print(res == Long.MIN_VALUE ? "Impossible" : res);
    }

    static long[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(n -> n.weight));
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight != dist[cur.v]) continue;

            for (Node next : graph[cur.v]) {
                if (height[cur.v] >= height[next.v]) continue;
                if (dist[cur.v] + next.weight < dist[next.v]) {
                    dist[next.v] = dist[cur.v] + next.weight;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }

    static class Node {
        int v;
        long weight;

        public Node(int v, long weight) {
            this.v = v;
            this.weight = weight;
        }
    }
}