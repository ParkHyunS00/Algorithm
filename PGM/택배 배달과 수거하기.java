class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dLastSpot = n-1, pLastSpot = n-1;
        while (pLastSpot >= 0 || dLastSpot >= 0){
            // 마지막 지점에서부터 배달 또는 수거할 곳이 0인 곳을 먼저 찾아냄
            while (dLastSpot >= 0 && deliveries[dLastSpot] == 0 ) dLastSpot -= 1;
            while (pLastSpot >= 0 && pickups[pLastSpot] == 0) pLastSpot -= 1;

            answer += (Math.max(pLastSpot, dLastSpot) + 1) * 2;

            // 배달 ..
            int curr = 0;
            while(dLastSpot >= 0 && curr < cap){
                curr += deliveries[dLastSpot];
                deliveries[dLastSpot--] = 0;
            }
            if (curr > cap) deliveries[++dLastSpot] = curr - cap;

            // 수거 ..
            curr = 0;
            while(pLastSpot >= 0 && curr < cap){
                curr += pickups[pLastSpot];
                pickups[pLastSpot--] = 0;
            }
            if (curr > cap) pickups[++pLastSpot] = curr - cap;
            

        }
        return answer;
    }
}