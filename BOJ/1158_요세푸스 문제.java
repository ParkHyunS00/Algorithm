import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++){
            deque.add(i+1);
        }

        sb.append("<");
        for (int i=0; i<n; i++){
            for(int j=0; j<k-1; j++){
                deque.addLast(deque.removeFirst());
            }
            if (i == n-1)
                sb.append(deque.removeFirst()).append(">");
            else
                sb.append(deque.removeFirst()).append(", ");
        }

        System.out.println(sb);
    }
}
