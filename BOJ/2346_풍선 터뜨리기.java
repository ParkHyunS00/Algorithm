import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Node> deque = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            deque.add(new Node(i+1, sc.nextInt()));
        }
d
        int[] result = new int[n];
        int readPaper = 0, idx = 0;

        while (deque.size() > 1){
            Node now = (readPaper >= 0) ? deque.pollFirst() : deque.pollLast();
            for (int i=0; i<Math.abs(now.paper) - 1; i++){
                if (now.paper < 0) deque.addFirst(deque.pollLast());
                else deque.addLast(deque.pollFirst());
            }

            readPaper = now.paper;
            result[idx++] = now.idx;
        }

        result[idx] = deque.pollLast().idx;

        for (int r : result){
            System.out.print(r + " ");
        }
    }

    static class Node{
        int idx, paper;
        Node(int idx, int paper){
            this.idx = idx;
            this.paper = paper;
        }
    }
}
