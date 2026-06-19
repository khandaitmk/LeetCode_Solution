class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        substring(s , 0 , new ArrayList<>() , res);
        return res;
    }
    public static void substring(String s , int start , List<String> temp , List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        StringBuilder str = new StringBuilder();
        for(int end = start ; end < s.length();end++){
            str.append(s.charAt(end));
            if(isPalindrome(str)){
                temp.add(str.toString());
                substring(s, end+1 , temp , res);
                temp.removeLast();
            }
        }
    }
    public static boolean isPalindrome(StringBuilder str ){
        int start = 0;
        int end = str.length()-1;
        char[] arr = str.toString().toCharArray();
        while(start < end){
            if(arr[start] != arr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}