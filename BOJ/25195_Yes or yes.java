import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int S;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] outdegree;
    static Set<Integer> fanClubs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        visited = new boolean[N + 1];
        outdegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            outdegree[u]++;
        }

        S = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            fanClubs.add(Integer.parseInt(st.nextToken()));
        }

        dfs(1);

        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (visited[i] && outdegree[i] == 0) {
                flag = true;
                break;
            }
        }

        System.out.print(flag ? "yes" : "Yes");
    }

    static void dfs(int node) {
        if (fanClubs.contains(node)) return;
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}