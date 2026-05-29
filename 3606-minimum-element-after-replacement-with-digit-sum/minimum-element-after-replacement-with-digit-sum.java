class Solution {
    public int minElement(int[] nums) {
        int sum = Integer.MAX_VALUE;
        for(int num : nums){
            int temp = 0;
            while (num > 0){
                temp += num % 10;
                num /=10;
            }
            sum = Math.min(temp , sum);
        }
        return sum;
    }
    
}