import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int max = stack.pop();
        int res = 1;
        while (!stack.isEmpty()) {
            int number = stack.pop();

            if (number > max) {
                res++;
                max = number;
            }
        }

        System.out.print(res);
    }
}