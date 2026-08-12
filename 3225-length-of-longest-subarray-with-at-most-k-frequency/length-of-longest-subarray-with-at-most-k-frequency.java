class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        int n = nums.length;
        int res = 0;
        int start = 0;
        for(int i=0;i<n;i++){
            hm.put(nums[i] , hm.getOrDefault(nums[i] , 0) + 1);

            while (hm.get(nums[i]) > k) {

                hm.put(nums[start], hm.get(nums[start]) - 1);

                if (hm.get(nums[start]) == 0) {
                    hm.remove(nums[start]);
                }

                start++;
            }
            res = Math.max(res, i - start + 1);

        }
        return res;
    }
}