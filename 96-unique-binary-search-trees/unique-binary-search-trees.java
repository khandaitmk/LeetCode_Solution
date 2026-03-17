class Solution {
    public int numTrees(int n) {
        int [] dp = new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i] = -1;
        }
        return helper(n , dp);
    }
    public static int helper(int n, int[] dp){
        if(n == 0 || n == 1){
            return 1;
        }
        if(dp[n] != -1) return dp[n];
        int temp = 0;
        for(int i=0;i<n;i++){
            temp += helper(i,dp) * helper(n-i-1,dp);
        }
        dp[n] = temp;
        return dp[n];
    }
}