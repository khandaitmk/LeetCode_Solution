class Solution {
    public int missingInteger(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        int temp = nums[0];
        for(int i=1; i<n;i++){
            if(nums[i] == nums[i-1] + 1){
                temp += nums[i];
            }else{
                break;
            }
            max = Math.max(max , temp);
        }
        while(contains(nums, max)){
            max++;
        }
        return max;
    }
    public static boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}