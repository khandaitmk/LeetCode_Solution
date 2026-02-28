class Solution {
    public int concatenatedBinary(int n) {
     long res = 0;
        int MOD = 1000000007;

        for(int i=1;i<=n;i++){
            int bitLength = 32 - Integer.numberOfLeadingZeros(i);
            res = ((res << bitLength) + i) % MOD;
        }
        return (int)res;   
    }
}