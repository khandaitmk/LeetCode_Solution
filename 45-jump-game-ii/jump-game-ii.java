class Solution {
    public int jump(int[] nums) {
         int n = nums.length;
        int curr = 0;
        int jumps = 0;
        int distance = n-1;
        while(curr < distance){
            int temp = nums[curr];
            int maxIndex = curr;
            for(int i=1;i<=nums[curr];i++){
                if(curr + i >= distance){ 
                    return jumps + 1;
                }
                if(curr + i +nums[curr + i] > maxIndex+nums[maxIndex]){
                    maxIndex = curr + i;
                }

            }
            if(maxIndex == curr){
                curr = n-1;
            }else {
                curr = maxIndex;
            }
            jumps++;
        }
        return jumps;
    }
}