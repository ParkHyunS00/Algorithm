class Solution {
    public String solution(int[] numbers, String hand) {
        String finger = hand.equals("right") ? "R" : "L";
        String answer = "";

        int leftX = 0, leftY = 3, rightX = 2, rightY = 3;

        // 1은 좌표 0,0 *은 3,0 #은 3,2
        for(int num : numbers){
            // 키패드 숫자 위치를 좌표로 변환
            int padY = (num - 1) / 3;
            int padX = (num - 1) % 3;
            if (num == 0){
                padY = 3;
                padX = 1;
            }

            // 1, 4, 7인 경우 왼손
            if (padX == 0){
                finger = "L";
                leftX = padX;
                leftY = padY;
            }
            // 3, 6, 9인 경우 오른손
            else if (padX == 2){
                finger = "R";
                rightX = padX;
                rightY = padY;
            }
            // 2, 5, 8인 경우 거리에 따라 판단
            else{
                int leftLength = getDist(padX, padY, leftX, leftY);
                int rightLength = getDist(padX, padY, rightX, rightY);

                if (leftLength > rightLength){
                    finger = "R";
                    rightX = padX;
                    rightY = padY;
                }
                else if (leftLength < rightLength){
                    finger = "L";
                    leftX = padX;
                    leftY = padY;
                }
                // 거리가 같은 경우 주 손에 따라 판단
                else if (leftLength == rightLength){
                    if(hand.equals("right")){
                        finger = "R";
                        rightX = padX;
                        rightY = padY;
                    }
                    else{
                        finger = "L";
                        leftX = padX;
                        leftY = padY;
                    }
                }
            }
            answer += finger;
        }
        
        return answer;
    }
        public static int getDist(int padX, int padY, int x, int y){
        return Math.abs(padX - x) + Math.abs(padY - y);
    }
}