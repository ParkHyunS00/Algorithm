import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> myDeque = new LinkedList<>();

        for(int i=0; i<n; i++){
            int input = Integer.parseInt(st.nextToken());

            while(!myDeque.isEmpty() && myDeque.getLast().val > input){
                myDeque.removeLast();
            }

            myDeque.addLast(new Node(input, i));

            if(myDeque.getFirst().idx <= i-l){
                myDeque.removeFirst();
            }

            bw.write(myDeque.getFirst().val + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node{
        public int idx, val;
        Node(int val, int idx){
            this.idx = idx;
            this.val = val;
        }
    }
}