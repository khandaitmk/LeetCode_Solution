class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int start = 1;
        int end = 0;
        for(int num : bloomDay){
            end = Math.max(end , num);
        }
        int res = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int count = 0;
            int flowerCount = 0;
            for(int i = 0 ; i < n ;i++){
                int temp = bloomDay[i];
                if(temp <= mid ){
                    flowerCount++;
                    if(flowerCount == k){
                        count++;
                        flowerCount = 0;
                    }
                }else{
                    flowerCount = 0;
                }
            }
            if(count >= m){
                res = mid;
                end = mid - 1;
            }else{
               start = mid + 1;
            }
        }
        return  res;
    }
}