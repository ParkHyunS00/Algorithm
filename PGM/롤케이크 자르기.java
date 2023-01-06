import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 모든 토핑 개수를 맵에 추가
        // 맵은 비교를 하기 위한 기준이 될 것, 철수와 동생 중 철수에 해당한다고 가정
        HashMap<Integer, Integer> me = new HashMap<>();
        for(int take : topping){
            me.put(take, me.getOrDefault(take, 0) + 1);
        }

        // Set 사용 -> 중복된 값을 삽입할 수 없기에
        // 일단 형이 모든 토핑을 다 가져갔다고 가정했고, 동생한테 하나씩 나눠주며
        // 형의 토핑과 동생의 토핑 개수 비교
        Set<Integer> brother = new HashSet<>();
        for(int take : topping){
            brother.add(take);
            me.put(take, me.get(take) - 1);

            if (me.get(take) == 0)
                me.remove(take);

            if (me.size() == brother.size())
                ++answer;
        }
        
        return answer;
    }
}