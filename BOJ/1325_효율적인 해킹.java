import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] ans;
    static boolean[] visited;
    static ArrayList<Integer> arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList[n+1];
        ans = new int[n+1];

        for(int i = 1; i<=n; i++){
            arr[i] = new ArrayList<Integer>();
        }

        for(int i =0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());
            arr[input1].add(input2);
        }

        for(int i =1; i<=n; i++){
            visited = new boolean[n+1];
            BFS(i);
        }

        int max = ans[1];
        for(int i =2;i<=n;i++){
            max = Math.max(max, ans[i]);
        }
        
        for(int i = 1;i<=n; i++){
            if(max == ans[i])
                System.out.printf("%d ", i);
        }
    }

    public static void BFS(int idx){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(idx);
        visited[idx] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i : arr[now]){
                if(visited[i] == false){
                    visited[i] = true;
                    ans[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
