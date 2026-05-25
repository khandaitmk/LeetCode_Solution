class Solution {
    public char kthCharacter(int k) {
        StringBuilder str = new StringBuilder();
        str.append('a');
        String res = getString(str , k);
        return res.charAt(k-1);
    }
    public static String getString(StringBuilder str , int k){
        if(k <= str.length()){
            return str.toString();
        }

        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            temp.append((char)(ch+1));
        }
        str.append(temp);
        return getString(str , k).toString();
    }
}