import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> myQueue = new LinkedList<>();

        for(int i=1; i<=n; i++){
            myQueue.add(i);
        }
        
        while(myQueue.size() > 1){
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }
        System.out.println(myQueue.poll());
    }
}