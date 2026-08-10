class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int temp = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(nums[right] == 1){
                right++;
                temp++;
                max = Math.max(temp,max);
            }else if(nums[right] == 0 && k > 0){
                right++;
                temp++;
                max = Math.max(temp,max);
                k--;
            }else{
                if(nums[left] == 0 && nums[right] == 0){
                    left++;
                    right++;
                } else if (nums[left] == 1 && nums[right] == 0) {
                    while(nums[left] != 0){
                        left++;
                        temp--;
                    }
                    left++;
                    right++;
                }
            }
        }
        return max;
    }
}