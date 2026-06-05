class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][2];
        for(int i=0;i<n+1;i++){
            dp[i][0] = -1;
        }
        for(int i=0;i<n+1;i++){
            dp[i][1] = -1;
        }
        return helper(nums , n , dp , 0);
    }
    public static int helper(int[] nums , int n , int[][] dp , int taken){
        if(n <= 0){
            return 0;
        }
        if(n == 1 && taken == 1 ){
            return 0;
        }
        if(dp[n][taken] != -1) return dp[n][taken];
        int include = 0;
        if(taken == 0 && n == nums.length){
             include = nums[n-1] + helper(nums  , n-2 , dp , 1);
        }else{
             include = nums[n-1]  + helper(nums  , n-2 , dp , taken);
        }
        int exclude =  helper(nums , n-1 , dp , taken);
        dp[n][taken] = Math.max(include , exclude);
        return dp[n][taken];
    }
}