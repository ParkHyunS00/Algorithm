import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int n : tangerine){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((num1, num2) -> num2.getValue().compareTo(num1.getValue()));

        for(Map.Entry<Integer, Integer> n : list){
            if(k <= 0) break;
            answer++;
            k -= n.getValue();
        }
        
        return answer;
    }
}