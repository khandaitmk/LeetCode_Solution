class Solution {
    public int minimumSum(int num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(num > 0){
            int temp = num % 10;
            pq.add(temp);
            num /=10;
        }
        Deque<Integer> dq = new LinkedList<>();
        while(!pq.isEmpty()){
            dq.add(pq.remove());
        }
        int sum = 0;
        while(!dq.isEmpty()){
            int t1 = dq.removeFirst();
            int t2 = dq.removeLast();
            sum += t1*10+t2;
        }
        return sum;
    }
}