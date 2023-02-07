class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){
            int checkBit = 1;
            String result = "";
            int bi = arr1[i] | arr2[i];

            for(int j=0; j<n; j++){
                result = ((bi & checkBit) > 0 ? "#" : " ") + result;
                checkBit = checkBit << 1;
            }
            answer[i] = result;
        }
        return answer;
    }
}