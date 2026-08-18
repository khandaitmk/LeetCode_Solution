class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer , Integer> freq = new HashMap<>();
        HashMap<Integer , Integer> count = new HashMap<>();

        int l = 0;
        int r = 0;
        for(r = 0;r <k;r++){
            freq.put(nums[r] , freq.getOrDefault(nums[r] , 0) + 1);
        }
        for (int num : freq.keySet()) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        l++;
        while(l+k <= nums.length){
            // Remove outgoing element
            int out = nums[l - 1];
            freq.put(out, freq.get(out) - 1);
            if (freq.get(out) == 0) {
                freq.remove(out);
            }
            // Add incoming element
            int in = nums[l + k - 1];
            freq.put(in, freq.getOrDefault(in, 0) + 1);
            // Count numbers present in this new window
            for (int num : freq.keySet()) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }

            l++;
        }

        int res = -1;
        for(int num : count.keySet()){
            if (count.get(num) == 1) {
                res = Math.max(res, num);
            }
        }
        return res;
    }
}