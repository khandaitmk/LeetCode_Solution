class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }
        
        int count = 0;
        for (int num : freq.keySet()) {
            if (num != 1) {
                count = Math.max(count, helper(num, freq));
            } else {
                int c = freq.get(1);
                if (c % 2 == 0) c--;
                count = Math.max(count, c);
            }
        }
        return count;
    }

    public static int helper(int num, Map<Integer, Integer> freq) {
        int n = num;
        int res = 0;
        while (true) {
            long t = (long) n * n;
            if (t > Integer.MAX_VALUE) break;
            // need at least 1 of n, and 1 of t, and 1 more of n (for mirror)
            if (freq.getOrDefault((int) t, 0) >= 1 && freq.getOrDefault(n, 0) >= 2) {
                res++;
                n = (int) t;
            } else {
                break;
            }
        }
        return res * 2 + 1;
    }
}