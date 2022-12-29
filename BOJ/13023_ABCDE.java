import java.util.*;

public class Main {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    static boolean arrived = false;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        A = new ArrayList[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            A[start].add(end);
            A[end].add(start);
        }

        for (int i=0; i<n; i++){
            DFS(i, 1);
            if(arrived)
                break;
        }

        if(arrived)
            System.out.println("1");
        else System.out.println("0");
    }
    
    public static void DFS(int now, int depth){
        if(depth == 5 || arrived){
            arrived =  true;
            return;
        }
        visited[now] = true;
        for(int i : A[now]){
            if(!visited[i]){
                DFS(i, depth + 1);
            }
        }
        visited[now] = false;
    }
}