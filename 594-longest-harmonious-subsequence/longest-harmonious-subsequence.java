class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int res = 0;
        while(start < nums.length && end >= 0){
            if(nums[end] - nums[start] == 1){
                res = Math.max(end - start + 1 , res);
                start++;
                end = nums.length - 1;
            }else if(nums[end] - nums[start] > 1){
                end--;
            }else{
                start++;
                end = nums.length - 1;
            }
        }
        return res;
    }
}