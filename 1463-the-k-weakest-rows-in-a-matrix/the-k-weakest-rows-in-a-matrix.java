class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int [] res = new int[k];
        for(int i=0;i< mat.length;i++){
            pq.add(new Info(i,mat[i]));
        }
        for(int i=0;i<k;i++){
            res[i] = pq.remove().row;
        }
        return res;
    }
    static class Info implements Comparable<Info>{
        int soldier ;
        int civilians;
        int row;

        Info(int row,int [] arr){
            this.row = row;
            for(int i=0;i<arr.length;i++){
                if(arr[i] == 1){
                    this.soldier++;
                }else {
                    this.civilians++;
                }
            }
        }
        public int compareTo(Info i){
            if(this.soldier == i.soldier){
                return this.row - i.row;
            }else {
                return this.soldier-i.soldier;
            }
        }
    }
    
}