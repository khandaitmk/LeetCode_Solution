class Solution {
    public String gcdOfStrings(String str1, String str2) {
        return gcd(str1 , str2);
    }
    public static String gcd(String str1 , String str2){
        if(!str1.startsWith(str2) && !str2.startsWith(str1)) return "";
        if(str1.isEmpty()) return str2;
        if(str2.isEmpty()) return str1;
        return gcd(str2.replaceFirst(str1, "") , str1);
    }
}