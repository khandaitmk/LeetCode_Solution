class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        int n = cost.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num :cost){
            pq.add(num);
        }
        while(!pq.isEmpty()){
            int max = pq.remove();
            int secondMax = 0;
            if(!pq.isEmpty()){
                secondMax = pq.remove();
            }
            sum += (max + secondMax);
            if(!pq.isEmpty()){
                 pq.remove();
            }
        }
        return sum;
    }
}