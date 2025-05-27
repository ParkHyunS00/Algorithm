import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Node>[] graph;
    static int[] cost;
    static int[] path;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int idx = 1;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new List[M];
            cost = new int[M];
            path = new int[M];

            for (int i = 0; i < M; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                graph[x].add(new Node(y, z));
                graph[y].add(new Node(x, z));
            }

            dijkstra();

            if (path[M - 1] == -1) sb.append(String.format("Case #%d: -1", idx++));
            else {
                List<Integer> pathList = new ArrayList<>();
                for (int at = M - 1; at != -1; at = path[at]) {
                    pathList.add(at);
                }
                Collections.reverse(pathList);

                StringBuilder tmp = new StringBuilder();
                for (int node : pathList) tmp.append(node).append(" ");

                sb.append(String.format("Case #%d: %s", idx++, tmp));
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        Arrays.fill(cost, INF);
        Arrays.fill(path, -1);
        pq.offer(new Node(0, 0));
        cost[0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight != cost[cur.v]) continue;

            for (Node next : graph[cur.v]) {
                if (cost[cur.v] + next.weight < cost[next.v]) {
                    cost[next.v] = cost[cur.v] + next.weight;
                    path[next.v] = cur.v;
                    pq.offer(new Node(next.v, cost[next.v]));
                }
            }
        }
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