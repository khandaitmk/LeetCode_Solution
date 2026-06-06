class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }
        return helper(grid , 0 , 0 , dp);
    }
    public static int helper(int[][] grid ,int i , int j , int[][] dp){
        int n = grid.length;
        int m = grid[0].length;
        if(i == n-1 && j == m-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1) return dp[i][j];
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if(i+1 < n && j+1 < m){
            right = grid[i][j] + helper(grid , i , j+1 , dp);
            down = grid[i][j] + helper(grid , i+1 , j , dp);
        }else if( i+1 < n){
            down = grid[i][j] + helper(grid , i+1 ,j ,dp);
        }else {
            right = grid[i][j] + helper(grid , i , j+1 , dp);
        }
        dp[i][j] = Math.min(right , down);
        return dp[i][j];
    }
}