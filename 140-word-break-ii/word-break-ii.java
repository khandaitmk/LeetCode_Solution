class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<String>[] dp = new List[n];
        return helper(s,wordDict,0,n,dp);
    }
    public static List<String> helper(String s , List<String> wordDict , int start , int n,List<String>[] dp){
        List<String> res = new ArrayList<>();

        if(start == n){
            res.add("");
            return res;
        }
        if(dp[start] != null){
            return dp[start];
        }
        StringBuilder str = new StringBuilder();
        for(int i=start+1;i<=n;i++){
            String prifix = s.substring(start,i);
            if(wordDict.contains(prifix)){
                List<String> temp = helper(s,wordDict,i,n,dp);
                for(String t : temp){
                    if(t.equals("")){
                        res.add(prifix);
                    }else {
                        res.add(prifix+" "+t);
                    }
                }
            }
        }
        dp[start] = res;
        return dp[start];
    }
}