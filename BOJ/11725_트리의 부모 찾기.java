import java.io.*;
import java.util.*;

public class Main {
    static int[] ans;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 개수
        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        ans = new int[n+1];

        for(int i=0; i<n+1; i++){
            tree[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<n; i++){
            int input1 = sc.nextInt();
            int input2 = sc.nextInt();
            tree[input1].add(input2);
            tree[input2].add(input1);
        }

        DFS(1);
        for(int i=2; i<=n; i++)
            System.out.println(ans[i]);
    }

    public static void DFS(int idx){
        visited[idx] = true;
        for(int i : tree[idx]){
            if(visited[i] != true){
                ans[i] = idx;
                DFS(i);
            }
        }
    }
}
