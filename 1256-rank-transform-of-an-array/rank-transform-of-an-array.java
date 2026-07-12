class Solution {
    static class Info implements Comparable<Info>{
        int val;
        int index;
        public Info(int val , int index){
            this.val = val;
            this.index = index;
        }
        public int compareTo(Info i1){
            return this.val - i1.val;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        PriorityQueue<Info> pq = new PriorityQueue<Info>();
        for(int i =0 ;i<n;i++){
            pq.add(new Info(arr[i] , i));
        }
        int[] res = new int[n];
        int rank = 1;
        Info prev = null;
        while(!pq.isEmpty()){
            Info temp = pq.remove();
            int val = temp.val;
            int index = temp.index;
            if(prev != null && prev.val == val){
                rank--;
            }
            res[index] = rank++;
            prev = temp;
        }
        return res;
    }
}