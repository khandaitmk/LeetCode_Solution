class Solution {
    static final int MOD = 1000000007;
    public int subsequencePairCount(int[] nums) {
        Long[][][] dp = new Long[nums.length][201][201];
        return (int)helper(nums , 0 , 0 , 0 , dp) % MOD;

    }
    public static long helper(int[] nums , int i  , int gcd1 , int gcd2, Long[][][] dp){
        if(i == nums.length){
            if(gcd1 ==  gcd2 && gcd1 != 0){
                return 1;
            }
            return 0;
        }
        if(dp[i][gcd1][gcd2]!= null) return dp[i][gcd1][gcd2];
        long ans = 0;
//        ignore
        ans += helper(nums , i+1 , gcd1 , gcd2 , dp) % MOD;

//        put in seq 1
        ans += helper(nums , i+1 , gcd(gcd1 , nums[i]) , gcd2 , dp) % MOD;
//        put in seq2
        ans += helper(nums , i+1 , gcd1 , gcd(gcd2 , nums[i]) , dp) % MOD;
        dp[i][gcd1][gcd2] = ans % MOD;
        return ans % MOD;
    }
    public static int gcd(int a , int b){
        if(a==0){
            return b;
        }
        if (b==0){
            return a;
        }
         int big = Math.max(a , b);
        int small = Math.min(a , b);
        return gcd(big % small , small);
    }
}