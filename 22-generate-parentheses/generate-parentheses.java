class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(0,0,n,res,new StringBuilder());
        return res;
    }
    public static void helper(int open , int close ,int n , List<String> res ,StringBuilder str){
        if(str.length() == 2*n){
            res.add(str.toString());
            return;
        }
        if(open < n){
            str.append("(");
            helper(open+1,close,n,res,str);
            str.deleteCharAt(str.length()-1);
        }
        if(close < open){
            str.append(")");
            helper(open,close+1,n,res,str);
            str.deleteCharAt(str.length()-1);
        }
    }
}