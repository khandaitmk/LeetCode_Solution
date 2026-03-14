class Solution {
    public int rob(int[] nums) {
         int n = nums.length;
        int sum = 0;
        int[] dp = new int[n+1];
        for(int i=1;i<n+1;i++){
            dp[i] = -1;
        }
        return helper(nums , sum , n , dp);
    }
    public static int helper(int[] nums ,int sum , int n, int[] dp){
        if(n<=0) return 0;
        if(dp[n] != -1) return dp[n];
        if(n-2 >= 0){
            int include = nums[n-1] + sum + helper(nums , sum , n-2 , dp);
            int exclude = sum + helper(nums , sum , n-1, dp);
            dp[n] =  Math.max(include , exclude);
            return dp[n];
        }else if (n-1 >= 0){
             dp[n] = nums[n-1] + sum + helper(nums , sum , n-1 , dp);
            return dp[n];
        }
        return sum;
    }
}