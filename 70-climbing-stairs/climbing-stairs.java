class Solution {
    public static int[] memo = new int[46];

    public int climbStairs(int n) {
        if(n == 0){
            return 1;
        }
        if(memo[n] != 0) return memo[n];
        int t1 =climbStairs(n-1);
        int t2 = 0;
        if(n-2 >= 0){
            t2 = climbStairs(n-2);
        }
        memo[n] = t1 + t2;
        return memo[n];
    }
}