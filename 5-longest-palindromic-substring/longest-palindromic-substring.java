class Solution {
    public static String longestPalindrome(String s) {
        // code here
        // s = s.toLowerCase();
        String pal = new String();

//        int start = 0;

        for(int start= 0;start<s.length();start++){
            int end = s.length()-1;
            while(start < end){
                if(s.charAt(start) == s.charAt(end)){
                    if(isPallindrome(s.substring(start,end+1))){
                        if(pal.length() < s.substring(start,end+1).length()){
                            pal =  s.substring(start,end+1);
                        }else {
                            end--;
                        }
                    }
                }
                end--;
            }
        }
        if(pal.length() == 0){
            return s.substring(0,1);
        }
        return pal;
    
    }
    public static boolean isPallindrome(String str){
        
        int start = 0;
        int end = str.length()-1;
        while(start<end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            else {
                start++;
                end--;
            }
        }
        return true;
    }
}