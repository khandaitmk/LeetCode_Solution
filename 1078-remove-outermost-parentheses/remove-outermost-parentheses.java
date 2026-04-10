class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        int start = 0;
        StringBuilder str = new StringBuilder();
        st.push(arr[0]);
        for(int i = 1 ;i<n;i++){
            if(arr[i] == ')'){
                st.remove(st.size()-1);
                if(st.isEmpty()){
                    str.append(s.substring(start+1 , i));
                    start = i+1;
                }
            }else{
                st.push(arr[i]);
            }
        }
        return str.toString();
    }
}