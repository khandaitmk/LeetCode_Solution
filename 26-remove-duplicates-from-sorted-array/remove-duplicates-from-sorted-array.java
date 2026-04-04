class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<2)return n;
            int i = 0;
            int j = 1;
            while(j < n){
                if(nums[i] == nums[j]){
                    j++;
                }else{
                    i++;
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
            }
            return i+1;
    }
}