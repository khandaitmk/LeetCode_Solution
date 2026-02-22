class Solution {
    static class Info implements Comparable<Info>{
        int xDist ;
        int yDist;
        int dist;
        Info(int xDist , int yDist){
            this.xDist = xDist;
            this.yDist = yDist;
            this.dist = (int)(Math.abs(xDist) * Math.abs(xDist) + Math.abs(yDist) * Math.abs(yDist));

        }
        public int compareTo(Info i1){
            return this.dist - i1.dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int [][] res = new int[k][2];
        int n = points.length;
        for(int i=0;i<n;i++){
            pq.add(new Info(points[i][0],points[i][1]));
        }
        for(int i=0;i<k;i++){
            Info temp = pq.remove();
            res[i][0] = temp.xDist;
            res[i][1] = temp.yDist;
        }
        return res;
    }
}