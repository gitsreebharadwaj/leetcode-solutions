class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> adjLs=new ArrayList<>();
        List<List<Integer>> adjRev=new ArrayList<>();
        int V=graph.length;
        int[] indegree=new int[V];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<V; i++) {
            adjLs.add(new ArrayList<>());
            adjRev.add(new ArrayList<>());
        }
        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].length; j++) {
                int element=graph[i][j];
                adjLs.get(i).add(element);
            }
        }
        for(int i=0; i<adjLs.size(); i++) {
            for(int nbrs : adjLs.get(i)) {
                adjRev.get(nbrs).add(i);
                indegree[i]++;
            }
        }
        for(int i=0; i<V; i++) {
            if(indegree[i]==0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int curr=q.poll();
            ans.add(curr);
            for(int nbrs : adjRev.get(curr)) {
                indegree[nbrs]--;
                if(indegree[nbrs]==0) {
                    q.offer(nbrs);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
