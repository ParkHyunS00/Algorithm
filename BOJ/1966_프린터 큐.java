import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int docCount = Integer.parseInt(st.nextToken());
            int order = Integer.parseInt(st.nextToken());
            Queue<MyDocument> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j=0; j<docCount; j++){
                queue.add(new MyDocument(j, Integer.parseInt(st.nextToken())));
            }


            int result = 0;
            while (true){
                MyDocument now = queue.remove();
                boolean flag = false;

                for (MyDocument d : queue){
                    if (d.importance > now.importance) {
                        flag = true;
                        break;
                    }
                }

                if (flag){
                    queue.add(now);
                }
                else {
                    result++;
                    if (order == now.idx){
                        sb.append(result).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }

    static class MyDocument{
        int idx;
        int importance;

        MyDocument(int idx, int importance){
            this.idx = idx;
            this.importance = importance;
        }
    }
}