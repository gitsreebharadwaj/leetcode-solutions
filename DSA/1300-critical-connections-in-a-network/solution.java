class Solution {
    int timer=1;
    public void dfs(List<List<Integer>> adjLs, int parent, int node, boolean[] vis, int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node]=true;
        tin[node]=timer;
        low[node]=timer;
        timer++;
        for(int nbrs : adjLs.get(node)) {
            if(nbrs==parent) {
                continue;
            }
            if(!vis[nbrs]) {
                dfs(adjLs, node, nbrs, vis, tin, low, bridges);
                low[node]=Math.min(low[node], low[nbrs]);
                if(low[nbrs]>tin[node]) {
                    bridges.add(Arrays.asList(nbrs, node));
                }
            }
            else {
                low[node]=Math.min(low[node], tin[nbrs]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjLs=new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjLs.add(new ArrayList<>());
        }
        for(int i=0; i<connections.size(); i++) {
            int u=connections.get(i).get(0);
            int v=connections.get(i).get(1);
            adjLs.get(u).add(v);
            adjLs.get(v).add(u);
        }
        boolean[] vis=new boolean[n];
        int[] tin=new int[n];
        int[] low=new int[n];
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(adjLs, -1, 0, vis, tin, low, bridges);
        return bridges;
    }
}
