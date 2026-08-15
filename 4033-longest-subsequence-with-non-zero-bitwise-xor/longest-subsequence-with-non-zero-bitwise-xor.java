class Solution {
    public static int longestSubsequence(int[] nums) {
    int n = nums.length;
    int totalXOR = 0;

    for (int num : nums) {
        totalXOR ^= num;
    }

    // total XOR is non-zero → take all elements
    if (totalXOR != 0) {
        return n;
    }

    // total XOR is 0
    // remove any one non-zero element to make XOR != 0
    for (int num : nums) {
        if (num != 0) {
            return n - 1;
        }
    }

    // all elements are 0 → no valid subsequence
    return 0;
}
}