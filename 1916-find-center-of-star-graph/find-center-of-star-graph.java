class Solution {
    public int findCenter(int[][] edges) {
        int noEdges = edges.length;
        int n = noEdges + 1;
        int [][] nodes = new int[n][2];

        for(int i=0;i<noEdges;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            nodes[src-1][0]++;
            nodes[dest-1][1]++;
        }
        int res = -1;
        int max = 0;
        for(int i=0;i<n;i++){
            if(nodes[i][0] + nodes[i][1]  > max){
                max = nodes[i][0] + nodes[i][1];
                res = i;
            }
        }
        return res+1;
    }
}