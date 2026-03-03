class Solution {
        public char findKthBit(int n, int k) {
            return helperOptimized(n,k);
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
    public static char helperOptimized(int n, int k) {
        // base case
        if(n == 1) return '0';

        int mid = (int) Math.pow(2, n-1); // middle index

        if(k == mid){
            return '1'; // middle is always 1
        }
        else if(k < mid){
            // k is in LEFT half → same as Sn-1
            return helperOptimized(n-1, k);
        }
        else {
            // k is in RIGHT half → mirror of left half inverted
            // mirror index in left half
            int mirrorK = mid - (k - mid);
            char c = helperOptimized(n-1, mirrorK);
            // invert the character
            return c == '0' ? '1' : '0';
        }
    }
}