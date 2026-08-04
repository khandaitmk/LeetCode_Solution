class Solution {
    public boolean winnerSquareGame(int n) {

        return helper(n , new Boolean[n]);
    }
    public static boolean helper(int n  , Boolean[] dp){
        if(n == 0) return false;
        if(n == 1) return true;
        if(dp[n-1] != null){
            return dp[n-1];
        }
        for(int i=1;i*i<=n;i++){
            if(!helper(n-i*i , dp)){
                return dp[n-1] = true;
            }
        }
        return dp[n-1] = false;
    }
}