import java.util.*;
class Solution {
    public int[] solution(String s) {
        char[] s_arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        // 최근에 발견된 위치(인덱스) 를 저장해보자
        int[] answer = new int[s.length()];
        int idx = 0;

        for(int i=0; i<s_arr.length; i++){
            int checkIdx = 0;
            int len = 0;

            if(!map.containsKey(s_arr[i])){
                map.put(s_arr[i], i);
                answer[idx++] = -1;
            }
            else{
                checkIdx = map.get(s_arr[i]);
                map.replace(s_arr[i], i);
                len = map.get(s_arr[i]) - checkIdx;
                
                answer[idx++] = len;
            }
        }
        return answer;
    }
}