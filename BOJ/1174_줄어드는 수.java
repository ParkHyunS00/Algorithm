import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Long> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N >= 1024) {
            System.out.print(-1);
            return;
        }

        res.add(0L);

        for (int i = 1; i <= 9; i++) {
            dfs(i, i);
        }

        Collections.sort(res);
        System.out.print(res.get(N - 1));
    }

    static void dfs(long number, int last) {
        res.add(number);

        for (int i = 0; i < last; i++) {
            long next = number * 10 + i;
            dfs(next, i);
        }
    }
}