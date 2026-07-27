class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            pq.add(num);
        }
        int res = 1;
        int first = pq.remove();
        int second = pq.remove();
        res = (first-1) * (second - 1);
        return res;
    }
}