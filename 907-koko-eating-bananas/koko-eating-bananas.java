class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int n = piles.length;

        int start = 1;
        int end = 0;
        for(int num : piles){
            end = Math.max(end , num);
        }
        int res = end;

        while(start <= end){
            int mid = start + (end - start)/2;
            long tempCount = 0;
            for(int pile : piles){
                if(pile <= mid){
                    tempCount++;
                }else{
                    tempCount += (pile + mid - 1) / mid;
                }
            }
            if(tempCount <= h){
                res = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }

        }
        return res ;

    }
}