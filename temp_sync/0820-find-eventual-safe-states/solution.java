class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        int V=graph.length;
        int[] vis=new int[V];
        int[] pathvis=new int[V];
        int[] check=new int[V];
        for(int i=0; i<V; i++) {
            if(vis[i]==0) {
                dfs(graph, vis, pathvis, check, i);
            }
        }
        for(int i=0; i<V; i++) {
            if(check[i]==1) {
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean dfs(int[][] graph, int[] vis, int[] pathvis, int[] check, int node) {
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        for(int nbrs : graph[node]) {
            if(vis[nbrs]==0) {
                if(dfs(graph, vis, pathvis, check, nbrs)) {
                    return true;
                }
            }
            else if(pathvis[nbrs]==1) {
                return true;
            }
            else if(check[nbrs]==0) {
                return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
}
