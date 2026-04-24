class Solution {
    public int maxDepth(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> ss = new Stack<>();
        int res = 0;
        int temp = 0;
        for(char c : ch){
            if(c == '('){
                ss.push(c);
                temp++;
                res = Math.max(temp , res);
            }else if(c == ')'){
                ss.pop();
                temp--;
            }
        }
        return res;
    
    }
}