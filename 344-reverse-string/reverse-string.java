class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int last = s.length-1;
        while(start< last){
            swap(s,start++,last--);
        }
        
    }
    static void swap(char[] s,int i,int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}