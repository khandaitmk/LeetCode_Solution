class Solution {
    public int maxProduct(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(n > 0){
            pq.add(n%10);
            n /=10;
        }
        int res = pq.remove();
        if(pq.size() >= 1){
            res *= pq.remove();
        }
        return res;
    }
}