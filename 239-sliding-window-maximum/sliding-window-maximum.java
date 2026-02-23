class Solution {
        static class Info implements Comparable<Info>{
        int value ;
        int pos;
        Info(int value , int pos){
            this.value = value;
            this.pos = pos;
        }
        public int compareTo(Info i){
           return  i.value - this.value;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int [] res = new int[n - k + 1];
        int temp = 0;
        for(int i=0;i<k;i++){
            pq.add(new Info(nums[i],i));
        }
        res[temp++] = pq.peek().value;
        for(int i=k;i<n;i++){
            
            while(pq.size() > 0 && pq.peek().pos <= i-k){
                pq.remove();
            }
            pq.add(new Info(nums[i],i));
            res[temp++] = pq.peek().value;
        }
        return res;
    }
}