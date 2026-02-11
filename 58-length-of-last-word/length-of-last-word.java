class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        int n = str.length();
        int i = n-1;
        while(i >= 0){
            if(str.charAt(i) == ' '){
                return str.substring(i+1).length();
            }else{
                i--;
            }
        }
        return str.length();
    }
}