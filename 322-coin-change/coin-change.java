class Solution {
    public int coinChange(int[] coins, int amount) {
       int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 1;i < amount+1;i++){
            dp[0][i] = amount+1;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1] <= j){
                    int include = 1 + dp[i][j-coins[i-1]];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.min(include , exclude  );
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[n][amount] > amount) return -1;
        return dp[n][amount];
     
    }
}