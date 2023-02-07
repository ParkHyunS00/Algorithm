import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        int changeCnt = 0;

        for(String str : record){
            String[] cmd = str.split(" ");

            if (cmd[0].equals("Enter") || cmd[0].equals("Change")){
                if (cmd[0].equals("Change")) ++changeCnt;
                String id = cmd[1];
                String name = cmd[2];
                map.put(id, name);
            }
        }

        String[] answer = new String[record.length - changeCnt];
        int idx = 0;
        for(String str : record){
            String[] cmd = str.split(" ");

            if (cmd[0].equals("Enter"))
                answer[idx++] = map.get(cmd[1]) + "님이 들어왔습니다.";
            else if(cmd[0].equals("Leave"))
                answer[idx++] = map.get(cmd[1]) + "님이 나갔습니다.";
        }
        return answer;
    }
}