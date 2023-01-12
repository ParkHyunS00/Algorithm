class Solution1 {
    public int solution(String t, String p) {
        int answer = 0;
        char[] t_arr = t.toCharArray();
        long pNum = Long.parseLong(p);

        for(int i=0; i<t.length() - p.length() + 1; i++){
            String buff = "";
            for(int j=i; j<i + p.length(); j++){
                buff += t_arr[j];
            }

            long compareNum = Long.parseLong(buff);
            if(compareNum <= pNum) ++answer;
        }
        return answer;
    }
}

class Solution2 {
    public int solution(String t, String p) {
        int answer = 0;
        long pNum = Long.parseLong(p);

        for(int i=0; i<t.length() - p.length() + 1; i++){
            String buff = t.substring(i, i + p.length());
            long compareNum = Long.parseLong(buff);

            if (compareNum <= pNum) ++answer;
        }
        return answer;
    }
}