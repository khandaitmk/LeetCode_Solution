class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<n+10;i++){
            int product = digitProduct(i);
            if(product % t == 0){
                return i;
            }
        }
        return n;
    }
    public static int digitProduct(int n){
        int res = 1;
        while(n > 0){
            res *= n%10;
            n /= 10;
        }
        return res;
    }
}