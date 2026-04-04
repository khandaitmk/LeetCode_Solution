class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        Queue<Integer> positive = new LinkedList<>();
        Queue<Integer> negative = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                positive.add(nums[i]);
            }else{
                negative.add(nums[i]);
            }
        }
        for(int i=0;i<n;i++){
            if(i % 2 == 0){
                nums[i] = positive.remove();
            }else{
                nums[i] = negative.remove();
            }
        }
        return nums;
    }
}