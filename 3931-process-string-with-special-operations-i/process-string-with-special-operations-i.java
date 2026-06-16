class Solution {
    public String processStr(String s) {
        StringBuilder res  = new StringBuilder();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '*'){
                if(!res.isEmpty()){
                    res.deleteCharAt(res.length()-1);
                }
            } else if(arr[i] == '#'){
                if(!res.isEmpty()){
                    String temp = res.toString();
                    res.append(temp);
                }
            } else if(arr[i] == '%'){
                if(!res.isEmpty()){
                    res = reverse(res);
                }
            }else {
                res.append(arr[i]);
            }
        }
        return res.toString();
    }
    public static StringBuilder reverse(StringBuilder str){
        char[] arr = str.toString().toCharArray();
        int start = 0;
        int end = str.length()-1;
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new StringBuilder(new String(arr));
    }
}