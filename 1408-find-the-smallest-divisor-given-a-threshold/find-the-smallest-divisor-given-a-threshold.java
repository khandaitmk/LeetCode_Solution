class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 0;
        for(int num : nums){
            end = Math.max(end , num);
        }
        int res = end;
        while(start <= end){
            int mid = start + (end - start )/ 2 ;
            int temp = 0;
            for(int num : nums){
                temp += (int)Math.ceil((double)num / mid);
            }
            if(temp <= threshold){
                res = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }
}