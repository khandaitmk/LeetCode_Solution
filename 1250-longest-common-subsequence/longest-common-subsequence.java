class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
//        return helperRecur(text1,text2,n,m);
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                dp[i][j] = -1;
            }
        }
        return helperMemo(text1,text2,n,m,dp);
    }
    public static int helperMemo(String str1 , String str2 , int n , int m,int[][] dp){
        if(n == 0 || m == 0 ) return 0;
        if(dp[n][m] != -1 ) return dp[n][m];
        if(str1.charAt(n-1) == str2.charAt(m-1)){  //if last digit matches
            dp[n][m] = 1 + helperMemo(str1,str2,n-1,m-1,dp);
            return dp[n][m];
        }else {                                    // if the last digits does not match.
            int temp1 = helperMemo(str1,str2,n-1,m,dp);
            int temp2 = helperMemo(str1,str2,n,m-1,dp);
            dp[n][m] = Math.max(temp1 , temp2);
            return dp[n][m];
        }
    }
}