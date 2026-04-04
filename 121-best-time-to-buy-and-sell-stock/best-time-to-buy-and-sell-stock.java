class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][]dp = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int res = helper(prices,0,1,n,dp);
        if(res < 0) return 0;
        return res;
    }
    public static int helper(int[] prices , int start , int buy , int n,int[][] dp){
        if(start == n) return 0;
        if(dp[start][buy] != -1) return dp[start][buy];
        if(buy == 1){
            int temp1 = -prices[start] + helper(prices,start+1,0,n,dp);
            int temp2 = helper(prices,start+1, 1,n,dp);
            dp[start][buy] =  Math.max(temp1,temp2);
            return dp[start][buy];
        }else{
            int temp1 = prices[start];
            int temp2 = helper(prices,start+1, 0,n,dp);
            dp[start][buy] = Math.max(temp1,temp2);
            return dp[start][buy];
        }
    }
}