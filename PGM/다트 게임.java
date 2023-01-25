import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    static int[] sum = new int[3];
    public int solution(String dartResult) {
        int answer = 0;
        // 다트 한 차례에서 얻은 점수에 대한 정규식
        // 0에서 9의 숫자, S or D or T 문자, * or # 존재할 수도 있고 없을 수도 있음
        Pattern pattern = Pattern.compile("(\\d{1,2})([S|D|T])([*|#]?)");
        Matcher matcher = pattern.matcher(dartResult); // 문자열 비교후 검사한 결과값 담은 매처 객체 반환
        int idx = 0;
        while(matcher.find()){
            sum[idx] = (int)Math.pow(Integer.parseInt(matcher.group(1)), calcArea(matcher.group(2)));
            calcOption(idx, matcher.group(3));
            idx++;
        }

        for(int val : sum) answer += val;
        return answer;
    }

     public static void calcOption(int index, String msg){
        if(msg.equals("*")) {
            sum[index] *= 2;
            if (index >= 1) sum[index-1] *= 2;
        }
        else if(msg.equals("#")) sum[index] *= -1;
    }

    public static int calcArea(String msg){
        int index = 0;
        if(msg.equals("S")) index = 1;
        else if(msg.equals("D")) index = 2;
        else if(msg.equals("T")) index = 3;
        return index;
    }
}