class Solution {
    static class Info implements Comparable<Info>{
        int num;
        int count;
        Info(int num){
            this.num = num;
            this.count = Integer.bitCount(num);
        }
        public int compareTo(Info i){
            if(this.count == i.count){
                return this.num - i.num;
            }
            return this.count - i.count;
        }
    }
    public int[] sortByBits(int[] arr) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            pq.add(new Info(arr[i]));
        }
        int i=0;
        while(!pq.isEmpty()){
            res[i++] = pq.remove().num;
        }
        return res;
    }
}