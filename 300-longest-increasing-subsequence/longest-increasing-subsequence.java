class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0 ; i<n+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j] = -1;
            }
        }
        return helper(nums,n-1,n, dp);
    }
    public static int helper(int[] nums ,int currIndex , int prevIndex , int[][] dp){
        if(currIndex < 0) return 0;
        if(dp[currIndex][prevIndex] != -1) return dp[currIndex][prevIndex];
        int include = 0;
        if(prevIndex == nums.length || nums[currIndex] < nums[prevIndex]){
            include = 1 + helper(nums,currIndex-1,currIndex,dp);
        }
        int exclude = helper(nums,currIndex-1,prevIndex,dp);
        dp[currIndex][prevIndex] = Math.max(include , exclude);
        return dp[currIndex][prevIndex];
    }
}