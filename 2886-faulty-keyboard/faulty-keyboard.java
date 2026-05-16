class Solution {
    public String finalString(String s) {
        char[] arr = s.toCharArray();
        StringBuilder str = new StringBuilder();
        int n = arr.length;;
        for(int i=0 ; i<n ; i++){
            if(arr[i] == 'i'){
                str.reverse();
            }else{
                str.append(arr[i]);
            }
        }
        return str.toString();
    }
    // as stringbuilder provides inbuil reverse ew don't need this function to reverse 
    // public static void reverseString(StringBuilder str){
    //     char[] arr = str.toString().toCharArray();
    //     int start = 0;
    //     int end = arr.length - 1;
    //     while(start < end){
    //         char temp = arr[start];
    //         arr[start] = arr[end];
    //         arr[end] = temp;
    //         start++;
    //         end--;
    //     }
    // }
}