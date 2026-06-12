import java.util.*;

class Solution {
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        LOG++;

        int[] depth = new int[n + 1];
        int[][] up = new int[n + 1][LOG];

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        up[1][0] = -1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[cur] + 1;
                    up[next][0] = cur;
                    q.add(next);
                }
            }
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = (up[i][j-1] == -1) ? -1 : up[up[i][j-1]][j-1];
            }
        }

        long MOD = 1_000_000_007L;
        int[] waysArr = new int[n + 1];
        waysArr[0] = 0;
        long pow = 1; // 2^0
        for (int e = 1; e <= n; e++) {
            waysArr[e] = (int) pow;
            pow = (pow * 2) % MOD;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            int l = lca(u, v, up, depth, LOG);
            int edge = depth[u] + depth[v] - 2 * depth[l];
            res[i] = waysArr[edge];
        }
        return res;
    }

    private int lca(int u, int v, int[][] up, int[] depth, int LOG) {
        if (depth[u] < depth[v]) { int t = u; u = v; v = t; }
        int diff = depth[u] - depth[v];
        for (int j = 0; j < LOG; j++) {
            if (((diff >> j) & 1) == 1) u = up[u][j];
        }
        if (u == v) return u;
        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != -1 && up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }
        return up[u][0];
    }
}