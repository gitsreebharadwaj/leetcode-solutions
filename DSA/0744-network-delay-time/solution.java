class Pair {
    int node;
    int weight;
    Pair(int node, int weight) {
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int V, int k) {
        List<List<Pair>> adjLs=new ArrayList<>();
        for(int i=0; i<V+1; i++) {
            adjLs.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++) {
            int u=times[i][0];
            int v=times[i][1];
            int w=times[i][2];
            adjLs.get(u).add(new Pair(v, w));
        }
        int[] dist=new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->a.weight-b.weight);
        pq.offer(new Pair(k, dist[k]));
        while(!pq.isEmpty()) {
            Pair curr=pq.poll();
            int node=curr.node;
            int weight=curr.weight;
            if(weight>dist[node]) {
                continue;
            }
            for(Pair nbrs : adjLs.get(node)) {
                int nbrsNode=nbrs.node;
                int nbrsWeight=nbrs.weight;
                if(weight+nbrsWeight<dist[nbrsNode]) {
                    dist[nbrsNode]=weight+nbrsWeight;
                    pq.offer(new Pair(nbrsNode, dist[nbrsNode]));
                }
            }
        }
        int maxDelay=0;
        for(int i=1; i<=V; i++) {
            if(dist[i]==Integer.MAX_VALUE) {
                return -1;
            }
            maxDelay=Math.max(maxDelay, dist[i]);
        }
        return maxDelay;
    }
}
