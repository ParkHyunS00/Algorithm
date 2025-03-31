import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Top> stack = new LinkedList<>();
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek().height <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek().index + 1;
            }

            stack.push(new Top(arr[i], i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(res[i]).append(" ");
        }

        System.out.print(sb);
    }

    static class Top {
        int height;
        int index;

        public Top(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
}