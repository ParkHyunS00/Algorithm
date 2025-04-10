import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Double.parseDouble(st.nextToken()));
        }

        while (pq.size() > 1) {
            double a = pq.poll();
            double b = pq.poll();

            pq.offer(a + (b / 2.0));
        }

        System.out.print(pq.poll());
    }
}