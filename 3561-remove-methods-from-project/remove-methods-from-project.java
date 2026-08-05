class Solution {
    static class Edge{
        int src;
        int dest;
        public Edge(int s , int d){
            this.src = s;
            this.dest = d;
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
       ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<invocations.length;i++){
            int src = invocations[i][0];
            int dest = invocations[i][1];
            graph[src].add(new Edge(src , dest));
        }
        boolean[] visited = new boolean[n];
        dfs(k , visited , graph);

        for(int i=0;i<n;i++){
            if(!visited[i]){
                for(Edge e : graph[i]){
                    if (visited[e.dest]) {

                        List<Integer> res = new ArrayList<>();

                        for (int j = 0; j < n; j++) {
                            res.add(j);
                        }

                        return res;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res.add(i);
            }
        }
        return res;
    }
    public static void dfs(int curr , boolean[] visited ,ArrayList<Edge>[] graph){
        visited[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(e.dest , visited  , graph);
            }
        }
    }
}