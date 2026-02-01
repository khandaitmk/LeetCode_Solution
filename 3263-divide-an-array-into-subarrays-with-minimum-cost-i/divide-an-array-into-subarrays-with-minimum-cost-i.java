class Solution {
    public int minimumCost(int[] nums) {
        int sum = nums[0];
        int [] arr = Arrays.copyOfRange(nums, 1, nums.length);
        Arrays.sort(arr);
        sum += arr[0];
        sum += arr[1];
        return  sum;
    }
}