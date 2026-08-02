class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int start = 0;
        int end = n - 1;
        return helper(piles , start , end , new Integer[n][n]) > 0;
    }
    public static int helper(int[] piles , int s , int e , Integer[][] dp){
        if( (s == e)){
            return (piles[s]);
        }
        if (dp[s][e] != null) {
            return dp[s][e];
        }

        int takeLeft =
                piles[s] - helper(piles, s + 1, e, dp);

        int takeRight =
                piles[e] - helper(piles, s, e - 1, dp);

        dp[s][e] = Math.max(takeLeft, takeRight);

        return dp[s][e];

    }
}