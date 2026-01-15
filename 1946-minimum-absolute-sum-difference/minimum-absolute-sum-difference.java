class Solution {
    static final int MOD = 1_000_000_007;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int n = nums1.length;

        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long totalSum = 0;
        int maxGain = 0;

        for (int i = 0; i < n; i++) {
            int a = nums1[i];
            int b = nums2[i];

            int originalDiff = Math.abs(a - b);
            totalSum = (totalSum + originalDiff) % MOD;

            int idx = Arrays.binarySearch(sorted, b);

            if (idx < 0) idx = -idx - 1;

            if (idx < n) {
                int newDiff = Math.abs(sorted[idx] - b);
                maxGain = Math.max(maxGain, originalDiff - newDiff);
            }

            if (idx > 0) {
                int newDiff = Math.abs(sorted[idx - 1] - b);
                maxGain = Math.max(maxGain, originalDiff - newDiff);
            }
        }

        return (int) ((totalSum - maxGain + MOD) %MOD );
    }
}