class Solution {
        public char findKthBit(int n, int k) {
            String res = helper(n);
            return res.charAt(k-1);
        }
        public static String helper(int n){
            if(n == 1){
                return "0";
            }
            String res = helper(n-1);
            String temp = res;
            char[] arr = temp.toCharArray();

            for(int i=0;i<arr.length;i++){
                if(arr[i] == '0'){
                    arr[i] = '1';
                }else {
                    arr[i] = '0';
                }
            }
            String inverted = new StringBuilder(new String(arr)).reverse().toString();;
            res = res + "1" + inverted;
            return res;
    }
}