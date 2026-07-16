class Solution {
    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        int stops =0;
        public Pair(int n , int path , int stop){
            this.n = n;
            this.path = path;
            this.stops = stop;
        }
        public int compareTo(Pair p){
            return this.path - p.path;
        }
    }
    static class Edge{
        int src ;
        int dest;
        int wt ;
        public Edge(int s , int dest , int w){
            this.src = s;
            this.dest = dest;
            this.wt = w;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int s = flights[i][0];
            int d =flights[i][1];
            int wt = flights[i][2];
            graph[s].add(new Edge(s , d , wt));
        }
        return helper(graph , src , dst , k);
    }
    public static int helper(ArrayList<Edge>[] graph  , int src , int dst , int k){
        int[][] dist = new int[graph.length][k + 2];
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[src][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src , 0 , 0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(curr.stops == k + 1){
                continue;
            }
            for(int i=0;i<graph[curr.n].size();i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int w = e.wt;
                    if(curr.stops + 1 <= k + 1 &&
                            curr.path + w < dist[v][curr.stops + 1]){

                        dist[v][curr.stops + 1] = curr.path + w;

                        pq.add(new Pair(v,
                                dist[v][curr.stops + 1],
                                curr.stops + 1));
                    }
            }
        }
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i <= k + 1; i++){
            ans = Math.min(ans, dist[dst][i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}