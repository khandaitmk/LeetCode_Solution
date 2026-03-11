class Solution {
    public int bitwiseComplement(int n) {
       String str = Integer.toBinaryString(n);
        char[] arr = str.toCharArray();
        StringBuilder st = new StringBuilder();
        for(char s : arr){
            if(s == '0'){
                st.append('1');
            }else {
                st.append('0');
            }
        }
        return Integer.parseInt(st.toString(),2); 
    }
}