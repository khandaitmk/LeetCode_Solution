class Solution {
    static final long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        long count = power(5,even)*power(4,odd) % MOD;
        return  (int)count;
    }
    static long power(long num,long n){
        if(n==0){
            return 1;
        }
        long halfPower = power(num,n/2)% 1000000007;
        long halfPowerSq = (halfPower * halfPower) % 1000000007;
        // halfPowerSq = halfPowerSq;
        if(n%2 ==0){
            return halfPowerSq;
        }
        return (num*halfPowerSq)% 1000000007;
    }
}