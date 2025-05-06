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

        long min = Long.MAX_VALUE;
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < N - 1; i++) {
            long[] ret = find(arr, i + 1, N, arr[i]);
            if (ret[0] < min) {
                min = ret[0];
                res1 = arr[i];
                res2 = arr[(int)ret[1]];
            }
        }

        System.out.print(res1 + " " + res2);
    }

    static long[] find(int[] arr, int start, int end, int target) {
        int lo = start;
        int hi = end - 1;
        long min = Long.MAX_VALUE;
        int idx = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            long sum = arr[mid] + target;
            long abs = Math.abs(sum);

            if (abs < min) {
                min = abs;
                idx = mid;
            }

            if (sum > 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return new long[]{min, idx};
    }
}