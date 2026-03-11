class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for(int num : nums){
            totalSum +=num;
        }
        if(totalSum % 2 != 0) return false;
        Boolean[][] dp = new Boolean[n+1][(totalSum/2)+1];
        return helper(nums , totalSum/2 , nums.length,dp);
    }
    public static boolean helper(int[] nums ,int target , int n,Boolean [][] dp){
        if(target == 0) return true;
        if(n == 0) return false;
        if(dp[n][target] != null){
            return dp[n][target];
        }
        if(nums[n-1] <= target){
            boolean include = helper(nums , target-nums[n-1],n-1,dp);
            boolean exclude = helper(nums , target,n-1,dp);
            dp[n][target] = include || exclude;
            return dp[n][target];
        }else {
            dp[n][target] =  helper(nums , target,n-1,dp);
            return dp[n][target];
        }
    }
}