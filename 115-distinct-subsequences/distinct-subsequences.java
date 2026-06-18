class Solution {
    public int numDistinct(String s, String t) {
        int n = t.length();
        Integer[][] dp = new Integer[s.length()+1][n+1];
        return helper(s , t ,0,0, n , new StringBuilder() , dp);
    }
    public static int helper(String s, String t , int i ,int j, int n  , StringBuilder str , Integer[][] dp){
        if(str.length() == n){
            if(str.toString().equals(t)) return 1;
            else return 0;
        }
        if(i >= s.length()) return 0;
        if(dp[i][j] != null) return dp[i][j];

        int include = 0;
        int exclude = 0;
        int ans = 0;
        if(s.charAt(i) == t.charAt(j)){
            str.append(s.charAt(i));
             include = helper(s , t , i+1 , j+1 , n ,str, dp);
            str.deleteCharAt(str.length()-1);
             exclude = helper(s , t , i+1 , j , n ,str , dp);

        }else{
            exclude = helper(s , t , i+1 ,j , n ,str , dp);
        }

         ans =  include + exclude;
        dp[i][j] = ans;
        return dp[i][j];
    }
}