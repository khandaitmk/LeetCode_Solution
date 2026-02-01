class Solution {
    public int minimumCost(int[] nums) {
        // int sum = nums[0];
        // int [] arr = Arrays.copyOfRange(nums, 1, nums.length);
        // Arrays.sort(arr);
        // sum += arr[0];
        // sum += arr[1];
        // return  sum;

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int i = 1 ; i<nums.length ;i++){
            if(nums[i] < firstMin){
                secondMin = firstMin;
                firstMin = nums[i];
            } else if(nums[i] < secondMin){
                    secondMin = nums[i];
            }
        }
        return nums[0] + firstMin +secondMin;
    }
}