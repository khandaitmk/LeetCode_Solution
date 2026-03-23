class Solution {
    public int maxProductPath(int[][] grid) {
         int n = grid.length;
        int m = grid[0].length;
        long[][] dp = new long[n][m];
        long[][] dpMin = new long[n][m];

        dp[0][0] = grid[0][0];
        dpMin[0][0] = grid[0][0];

        for(int i=1;i<m;i++){
            dp[0][i] = dp[0][i-1] * grid[0][i];
            dpMin[0][i] = dp[0][i-1] * grid[0][i];
        }
        for(int i=1;i<n;i++){
            dp[i][0] = dp[i-1][0] * grid[i][0];
            dpMin[i][0] = dp[i-1][0] * grid[i][0];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                int val = grid[i][j];

                long a = val * dp[i-1][j];
                long b = val * dpMin[i-1][j];
                long c = val * dp[i][j-1];
                long d = val * dpMin[i][j-1];
                dp[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                dpMin[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }
        if(dp[n-1][m-1] < 0) return -1;
        return  (int)( dp[n-1][m-1] % 1000000007);
    }
}