class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjLs=new ArrayList<>();
        for(int i=0; i<isConnected.length; i++) {
            adjLs.add(new ArrayList<>());
        }
        for(int i=0; i<isConnected.length; i++) {
            for(int j=0; j<isConnected.length; j++) {
                if(isConnected[i][j]==1 && i!=j) {
                    adjLs.get(i).add(j);
                }
            }
        }
        boolean[] vis=new boolean[adjLs.size()];
        int cnt=0;
        for(int i=0; i<adjLs.size(); i++) {
            if(!vis[i]) {
                cnt++;
                dfs(i, adjLs, vis);
            }
        }
        return cnt;
    }
    public void dfs(int node, List<List<Integer>> adjLs, boolean[] vis) {
        vis[node]=true;
        for(int nbrs : adjLs.get(node)) {
            if(!vis[nbrs]) {
                dfs(nbrs, adjLs, vis);
            }
        }
    }
}
