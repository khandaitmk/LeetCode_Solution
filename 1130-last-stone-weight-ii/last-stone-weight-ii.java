class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int totalSum = 0;
        for(int num : stones){
            totalSum += num;
        }
        int target = totalSum/2;
        int [][] dp = new int[n+1][target+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < target+1; j++){
                dp[i][j] = -1;
            }
        }
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<target+1;i++){
            dp[0][i] = 0;
        }
        int temp =  helper(stones,target,n,dp);
        int subSet2 = totalSum - temp;
        return Math.abs(temp - subSet2);
    }
    public static int helper(int[] stones , int target , int n,int[][] dp){
        if(target == 0) return 0;
        if(n == 0 ) return 0;
        if(dp[n][target] != -1){
            return dp[n][target];
        }
        if(stones[n-1] <= target) {
            int include = stones[n-1] + helper(stones,target-stones[n-1],n-1,dp) ;
            int exclude = helper(stones,target,n-1,dp);
            dp[n][target] = Math.max( include , exclude);
            return dp[n][target];

        }else{
            dp[n][target]  = helper(stones,target,n-1,dp);
            return dp[n][target] ;
        }

    }
}