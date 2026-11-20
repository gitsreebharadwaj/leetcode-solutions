class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjLs=new ArrayList<>();
        int[] indegree=new int[numCourses];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            adjLs.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++) {
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adjLs.get(v).add(u);
            indegree[u]++;
        }
        for(int i=0; i<numCourses; i++) {
            if(indegree[i]==0) {
                q.offer(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()) {
            int curr=q.poll();
            cnt++;
            for(int nbrs : adjLs.get(curr)) {
                indegree[nbrs]--;
                if(indegree[nbrs]==0) {
                    q.offer(nbrs);
                }
            }
        }
        if(cnt==numCourses) {
            return true;
        }
        return false;
    }
}
