class Solution {
    static class Edge{
        int src;
        int dest;
        public Edge(int s , int d){
            this.src = s;
            this.dest = d;
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        int V = n;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i< edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            graph[src].add(new Edge(src , dest));
            graph[dest].add(new Edge(dest , src));

        }

        int components = 0;
        int res = 0;
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            int []componentNodeEdge = new int[2];
            if(!visited[i]){
                components++;
                 componentNodeEdge= bfs(graph , visited , i);
                int nodes = componentNodeEdge[0];
                int edgesForComponant = componentNodeEdge[1];
                if((nodes * (nodes - 1) /2) == edgesForComponant/2){
                    res++;
                }
            }

        }
        return res;
    }
    public static int[] bfs(ArrayList<Edge>[] graph , boolean[] visited , int i){
        int count = 0;
        int edges = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                count++;
                visited[curr] = true;
                for(int j = 0 ; j < graph[curr].size();j++){
                    Edge e = graph[curr].get(j);
                    edges++;
                    if(!visited[e.dest]){
                        q.add(e.dest);
                    }
                }
            }
        }
        return new int[]{count , edges};
    }
}