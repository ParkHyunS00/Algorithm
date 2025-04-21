import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[S];
        long sum = 0L;

        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        long lo = 1;
        long hi = arr[S - 1];
        long res = 0;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;

            if (isPossible(arr, mid, C)) {
                lo = mid + 1;
                res = mid;
            } else {
                hi = mid - 1;
            }
        }

        System.out.print(sum - res * C);
    }

    static boolean isPossible(int[] arr, long target, int C) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += (arr[i] / target);
        }

        return count >= C;
    }
}