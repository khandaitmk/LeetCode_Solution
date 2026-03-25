class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            for (int j=0;j<numRows;j++){
                dp[i][j] = -1;
            }
        }
        for(int i=0;i<numRows;i++){
            dp[i][i] = 1;
            dp[i][0] = 1;
        }
        for(int i=0;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0;j<=i;j++){
                if(dp[i][j] != -1){
                    temp.add(dp[i][j]);
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                temp.add(dp[i][j]);
            }
            res.add(temp);
        }
        return res;
    }
}