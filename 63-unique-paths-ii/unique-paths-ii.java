class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j] = -1;
            }
        }
        return helper(obstacleGrid , 0,0,n,m,dp);
    }
    public static int helper(int[][] obstacleGrid , int i , int j, int n, int m , int[][] dp){
        if(obstacleGrid[i][j] == 1){
            return 0;
        }
        if(i == n-1 && j == m-1){
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];

        int right = 0;
        int down = 0;
        if(i+1 < n && j+1 < m){
             right = helper(obstacleGrid , i , j+1 , n , m, dp);
             down = helper(obstacleGrid , i+1 , j , n , m , dp);
        }else if(j+1 < m){
             right = helper(obstacleGrid , i , j+1 , n , m, dp);
        }else{
             down = helper(obstacleGrid , i+1 , j , n , m , dp);
        }
        dp[i][j] = right + down;
        return dp[i][j];
    }
}