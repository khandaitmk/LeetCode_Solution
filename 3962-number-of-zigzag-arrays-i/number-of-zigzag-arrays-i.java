class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int MOD = 1_000_000_007;
        int m = r - l; // shift range to [0, m]
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 1); // base: 1 way to place each value at i=0

        for (int i = 1; i < n; i++) {
            int pre = 0, pre2;
            if ((i & 1) == 1) {
                // odd index: must be > previous → sum all dp[v'] where v' < v
                for (int v = 0; v <= m; v++) {
                    pre2 = (pre + dp[v]) % MOD;
                    dp[v] = pre;          // ways where prev < v
                    pre = pre2;
                }
            } else {
                // even index: must be < previous → sum all dp[v'] where v' > v
                for (int v = m; v >= 0; v--) {
                    pre2 = (pre + dp[v]) % MOD;
                    dp[v] = pre;          // ways where prev > v
                    pre = pre2;
                }
            }
        }

        int res = 0;
        for (int v : dp) res = (res + v) % MOD;

        // multiply by 2: zigzag can start going up OR down
        return (int)((res * 2L) % MOD);
    }
}