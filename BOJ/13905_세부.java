import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int s;
    static int e;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            edges.add(new Edge(h1, h2, k));
        }

        Collections.sort(edges);

        int res = 0;
        for (Edge edge : edges) {
            if (isSameSet(edge.u, edge.v)) continue;

            union(edge.u, edge.v);
            if (isSameSet(s, e)) {
                res = edge.weight;
                break;
            }
        }

        System.out.print(res);
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
            int tmp = a;
            a = b;
            b = tmp;
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
            return o.weight - weight;
        }
    }
}