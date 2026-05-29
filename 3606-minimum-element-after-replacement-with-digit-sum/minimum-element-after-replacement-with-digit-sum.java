class Solution {
    public int minElement(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            int sum = getDigitSum(num);
            pq.add(sum);
        }
        return pq.remove().intValue();
    }
    public static int getDigitSum(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /=10;
        }
        return sum;
    }
}