class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]", "");
        str = str.toLowerCase();
        int start = 0;
        int end = str.length()-1;
        while(start<end){
            if(str.charAt(start++) != str.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}