import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        Arrays.fill(parent, -1);
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            edges.add(new Edge(i, N, Integer.parseInt(br.readLine())));
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i == j || i < j) continue;

                edges.add(new Edge(i, j, cost));
            }
        }

        Collections.sort(edges);

        int count = 0;
        int sum = 0;
        for (Edge e : edges) {
            if (isSameSet(e.u, e.v)) continue;

            union(e.u, e.v);
            count++;
            sum += e.weight;
            if (count == N) break;
        }

        System.out.print(sum);
    }

    static int find(int x) {
        if (parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        if (parent[a] > parent[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        parent[a] += parent[b];
        parent[b] = a;
    }

    static boolean isSameSet(int a, int b) {
        return find(a) == find(b);
    }

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}