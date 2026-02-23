class Solution {
    static class Info implements Comparable<Info>{
        int value;
        int count;
        Info(int value , int count){
            this.value = value;
            this.count = count;
        }
        public int compareTo(Info i){
            return i.count - this.count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
       Arrays.sort(nums);
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int [] res = new int[k];
        int count = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                count++;
            }else {
                pq.add(new Info(nums[i],count));
                count = 1;
            }
        }
        pq.add(new Info(nums[nums.length-1],count));
        for(int i=0;i<k;i++){
            res[i] = pq.remove().value;
        }
        return res; 
    }
}