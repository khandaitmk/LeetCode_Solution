class Solution {
        static class Rank implements Comparable<Rank>{
        int val ;
        int pos ;

        Rank(int val , int pos){
            this.val = val;
            this.pos = pos;
        }
        public int compareTo(Rank r){
            return r.val - this.val;
        }
    }

    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Rank> pq = new PriorityQueue<>();
        int n = score.length;
        for(int i=0;i<n;i++){
            pq.add(new Rank(score[i] , i));
        }
        String[] res = new String[n];
        int i=0;
        int rank = 1;
        while(!pq.isEmpty()){
            Rank obj = pq.remove();
            if(rank == 1){
                res[obj.pos] = "Gold Medal";
            }else if( rank == 2){
                res[obj.pos] = "Silver Medal";
            }else if(rank == 3){
                res[obj.pos] = "Bronze Medal";
            }else{
                res[obj.pos] = String.valueOf(rank);
            }
            rank++;
        }
        return res;
    
    }
}