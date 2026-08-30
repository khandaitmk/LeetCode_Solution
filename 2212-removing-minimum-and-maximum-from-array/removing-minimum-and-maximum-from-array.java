class Solution {
    public int minimumDeletions(int[] nums) {
int n = nums.length;
        int minPos = -1;
        int maxPos = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = nums.length - 1;
        for(int i = 0;i< nums.length;i++){
            if(nums[i] < min){
                min = nums[i];
                minPos = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxPos = i;
            }
        }

        int left = Math.min(minPos , maxPos);
        int right = Math.max(minPos , maxPos);

        int bothLeft = right +1;
        int bothRight = n - left;
        int split = (left + 1) + (n - right);

        return Math.min(bothLeft, Math.min(bothRight, split));

    }
}