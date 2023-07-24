import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (deque.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(deque.removeFirst()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "front":
                    if (deque.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(deque.peekFirst()).append("\n");
                    break;
                case "back":
                    if (deque.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
