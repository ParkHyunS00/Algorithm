class Solution {
    static int MAX = 5000001;
    static int max_num[] = new int[MAX];
    static int div_num[] = new int[MAX];
    public int[] solution(int e, int[] starts) {
        int answer[] = new int[starts.length];
        div_count(e);
        findMax(e);
        for(int i=0; i<starts.length; i++){
            answer[i] = max_num[starts[i]];
        }
        
        return answer;
    }
    public static void div_count(int e){
        for(int i=1; i<=e; i++) div_num[i] = 1;
        for(int i=2; i<=e; i++){
            for(int j=i; j<=e; j+=i) div_num[j]++;
        }
    }

    public static void findMax(int e){
        int div_cnt = div_num[e];
        int max = e;
        for(int i=e; i>=1; i--){
            if(div_cnt <= div_num[i]){
                div_cnt = div_num[i];
                max = i;
            }
            max_num[i] = max;
        }
    }
}