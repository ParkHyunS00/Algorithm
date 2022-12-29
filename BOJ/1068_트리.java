import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static int cnt = 0;
    static int delete;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree= new ArrayList[n];
        visited = new boolean[n];
        int root = 0;

        for(int i =0;i<n;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i =0;i<n;i++){
            int input = sc.nextInt();
            if(input != -1){
                tree[i].add(input);
                tree[input].add(i);
            }
            else
                root = i;
        }
        
        delete = sc.nextInt();
        if(delete == root){
            System.out.println(0);
        }
        else{
            DFS(root);
            System.out.println(cnt);
        }
    }

    public static void DFS(int root){
        visited[root] = true;
        int check = 0;
        for(int i : tree[root]){
            if(visited[i] == false && i != delete){
                check++;
                DFS(i);
            }
        }
        if(check == 0)
            cnt++;
    }
}
