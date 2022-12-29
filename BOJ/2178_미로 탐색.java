import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean visited[][];
    static int[][] A;
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        visited = new boolean[n][m];
        for(int i =0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0;j<m;j++){
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }
        BFS(0, 0);
        System.out.println(A[n-1][m-1]);
    }

    public static void BFS(int i, int j){
        Queue<int[]> myQueue = new LinkedList<>();
        myQueue.offer(new int[]{i, j});

        while(!myQueue.isEmpty()){
            int now[] = myQueue.poll();
            visited[i][j] = true;

            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                
                if(x >= 0 && y >= 0 && x<n && y<m){
                    if(A[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        myQueue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}