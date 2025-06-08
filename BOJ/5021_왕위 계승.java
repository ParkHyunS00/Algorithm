import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static Map<String, List<String>> graph = new HashMap<>();
    static Map<String, Integer> indegree = new HashMap<>();
    static Map<String, Double> blood = new HashMap<>();
    static String king;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        king = br.readLine();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent1 = st.nextToken();
            String parent2 = st.nextToken();

            graph.putIfAbsent(child, new ArrayList<>());
            graph.putIfAbsent(parent1, new ArrayList<>());
            graph.putIfAbsent(parent2, new ArrayList<>());
            indegree.putIfAbsent(child, 0);
            indegree.putIfAbsent(parent1, 0);
            indegree.putIfAbsent(parent2, 0);

            graph.get(parent1).add(child);
            graph.get(parent2).add(child);
            indegree.put(child, indegree.get(child) + 2);
        }

        sort();

        String res = "";
        double max = 0.0;
        for (int i = 0; i < M; i++) {
            String candidate = br.readLine();
            double val = blood.getOrDefault(candidate, 0.0);

            if (val > max) {
                max = val;
                res = candidate;
            }
        }

        System.out.print(res);
    }

    static void sort() {
        Queue<String> queue = new LinkedList<>();
        for (String person : indegree.keySet()) {
            blood.put(person, person.equals(king) ? 1.0 : 0.0);

            if (indegree.get(person) == 0) queue.offer(person);
        }

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            for (String child : graph.get(cur)) {
                blood.put(child, blood.get(cur) / 2 + blood.get(child)); // 부모 혈통 절반
                indegree.put(child, indegree.get(child) - 1);

                if (indegree.get(child) == 0) queue.offer(child);
            }
        }
    }
}