class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int maxCount = 0;
        for(int i = 1 ; i < n ; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i] == max) maxCount++;
        }
        Arrays.sort(nums);
        int tempCount = 1;
        int num = nums[0];
        for(int i=0;i<n-1;i++){
            if(nums[i] == nums[i+1]){
                tempCount++;
                num = nums[i];
            }
            if(tempCount >= 2 && num != max) return false;
        }
        if(tempCount > 2 && num != max) return false;
        if(n-1 == max && maxCount == 2) return true;
        return false;
    }
}