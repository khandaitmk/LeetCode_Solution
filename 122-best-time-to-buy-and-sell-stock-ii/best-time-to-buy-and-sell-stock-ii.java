class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return helper(prices , 0 , 1 , dp);
    }
    public static int helper(int[] prices , int i , int canbuy ,Integer[][] dp){
        if(i == prices.length) return 0;
        if(dp[i][canbuy] != null) return dp[i][canbuy];
        if(canbuy == 1){
            int buy = -prices[i] + helper(prices , i+1 , 0,dp);
            int skip = helper(prices , i+1 , 1,dp);
            return dp[i][canbuy]  = Math.max(buy , skip);
        }else {
            int sell = prices[i] + helper(prices , i+1 , 1,dp);
            int hold = helper(prices , i+1 , 0,dp);
            return dp[i][canbuy]  = Math.max(sell , hold);
        }
    }
}