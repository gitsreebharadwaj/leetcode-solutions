class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adjLs=new ArrayList<>();
        for(int i=0; i<graph.length; i++) {
            adjLs.add(new ArrayList<>());
            for(int j=0; j<graph[i].length; j++) {
                adjLs.get(i).add(graph[i][j]);
            }
        }
        int V=adjLs.size();
        int[] color=new int[V];
        Arrays.fill(color, -1);
        for(int i=0; i<V; i++) {
            if(color[i]==-1) {
                if(!dfs(adjLs, color, 0, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> adjLs, int[] color, int col, int start) {
        color[start]=col;
        for(int nbrs : adjLs.get(start)) {
            if(color[nbrs]==-1) {
                if(!dfs(adjLs, color, 1-col, nbrs)) {
                    return false;
                }
            }
            else if(color[start]==color[nbrs]) {
                return false;
            }
        }
        return true;
    }
}
