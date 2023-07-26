import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());


        for (int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(solve(x, y)).append("\n");
        }

        System.out.print(sb);
    }

    public static int solve(int x, int y){
        int dist = y - x;
        int squareDist = (int)Math.sqrt(dist);

        if (dist == squareDist * squareDist){
            return (2 * squareDist - 1);
        }
        else if (dist > squareDist * squareDist + squareDist)
            return (2 * squareDist + 1);
        else
            return (2 * squareDist);
    }
}
