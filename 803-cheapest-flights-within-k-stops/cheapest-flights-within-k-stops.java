class Solution {
    static class Info{
        int v ;
        int stops;
        int cost;
        public Info(int v , int cost , int stops){
            this.v = v;
            this.stops = stops ;
            this.cost = cost;
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
        int n = graph.length;
        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src , 0 , 0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops > k){
                continue;
            }
            for(int i=0;i<graph[curr.v].size();i++){
                Edge e =  graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(dist[u] != Integer.MAX_VALUE  && curr.cost + wt < dist[v] && curr.stops <= k){
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v , dist[v] , curr.stops+1));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}