class Solution {
    // public int[] rearrangeArray(int[] nums) {
    //     int n = nums.length;
    //     Queue<Integer> positive = new LinkedList<>();
    //     Queue<Integer> negative = new LinkedList<>();
    //     for(int i=0;i<n;i++){
    //         if(nums[i] > 0){
    //             positive.add(nums[i]);
    //         }else{
    //             negative.add(nums[i]);
    //         }
    //     }
    //     for(int i=0;i<n;i++){
    //         if(i % 2 == 0){
    //             nums[i] = positive.remove();
    //         }else{
    //             nums[i] = negative.remove();
    //         }
    //     }
    //     return nums;
    // }
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int posIndex = 0;
        int negIndex = 1;
        for(int num : nums){
            if(num > 0){
                res[posIndex] = num;
                posIndex += 2;
            }else{
                res[negIndex] = num;
                negIndex += 2;
            }
        }
        return res;
    }
}