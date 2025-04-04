import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int W;
    static double M;
    static List<Node>[] graph;
    static final double INF = Double.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        M = Double.parseDouble(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] x = new int[N + 1];
        int[] y = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, 0));
            graph[v].add(new Node(u, 0));
        }

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                long dx = x[i] - x[j];
                long dy = y[i] - y[j];
                double dist = Math.sqrt(dx * dx + dy * dy);

                if (dist <= M) {
                    graph[i].add(new Node(j, dist));
                    graph[j].add(new Node(i, dist));
                }
            }
        }

        double[] res = dijkstra();
        System.out.print((int)(res[N] * 1000.0));
    }

    static double[] dijkstra() {
        double[] cost = new double[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(n -> n.cost));
        Arrays.fill(cost, INF);
        cost[1] = 0.0;
        pq.offer(new Node(1, 0.0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost != cost[cur.v]) continue;

            for (Node next : graph[cur.v]) {
                if (cost[cur.v] + next.cost < cost[next.v]) {
                    cost[next.v] = cost[cur.v] + next.cost;
                    pq.offer(new Node(next.v, cost[next.v]));
                }
            }
        }

        return cost;
    }

    static class Node {
        int v;
        double cost;

        public Node(int v, double cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}