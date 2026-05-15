class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < min) {
                min = nums[mid];
            }
            if (nums[mid] >= nums[start]) { // that equal to sign is for the if left contain only one element then for
                                            // that equal to sign else it give error
                // left half is sorted
                min = Math.min(nums[start], min);
                start = mid + 1;
            } else {// right half is sorted
                min = Math.min(nums[mid], min);
                end = mid - 1;
            }

        }
        return min;
    }
}