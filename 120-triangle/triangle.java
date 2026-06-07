class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return helper(0,0,triangle , dp);
    }
    public static int helper(int i , int j ,List<List<Integer>> triangle , Integer[][] dp){
        if( i == triangle.size() - 1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != null) return dp[i][j];
        int below = triangle.get(i).get(j) + helper(i+1,j,triangle , dp);
        int sideBelow = triangle.get(i).get(j) + helper(i+1,j+1,triangle , dp);
        dp[i][j] = Math.min(below , sideBelow);
        return dp[i][j];
    }
}