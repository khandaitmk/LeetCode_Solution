class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int count = 0;
        int i = 0;
        int j = 0;
        int sum = 0;

        while (i != n && j < n){
//            if(i == j){
//                sum += nums[i];
//            }
            sum += nums[j];
            if(sum >= target){
                if(count == 0){
                    count = j - i + 1;
                }
                count = Math.min(count,j - i + 1);
                i++;
                j=i;
                sum = 0;
            }else{
                j++;
            }
        }
        return count;
    }
}