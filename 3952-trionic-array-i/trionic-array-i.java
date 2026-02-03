class Solution {
    public boolean isTrionic(int[] nums) {
        if(nums.length < 4) return false;
        int peak = -1;
        int vally = -1;
        if(nums[0] >= nums[1]){
            return false;
        }
        for(int i = 1; i < nums.length-1 ; i++){
            if (nums[i] == nums[i - 1]) {
                return false;
            }

            if(peak != -1 && vally != -1){
                if(nums[i-1] > nums[i] && nums[i+1] > nums[i] || nums[i-1] < nums[i] && nums[i+1] < nums[i]){
                    return false;
                }
            }
            if(peak == -1){
                if( nums[i-1] < nums[i] && nums[i+1] < nums[i]){
                    peak = i;
                }
                
            } else {
                if(nums[i-1] > nums[i] && nums[i+1] > nums[i]){
                    vally = i;
                }
            }
        }
        if (nums[nums.length - 1] == nums[nums.length - 2]) {
            return false;
        }
        if(peak == -1 || vally == -1){
            return false;
        }
        return true;
    }
}