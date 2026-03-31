class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        int i=0;
        while(i<=n){
            arr[i] = count1(i);
            i++;
        }
        return arr;
    }
    public static int count1(int n){
        int count = 0;
        while(n > 0){
            if( (n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}