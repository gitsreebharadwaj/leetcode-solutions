class Pair {
    int node;
    long weight;
    Pair(int node, long weight) {
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int countPaths(int V, int[][] roads) {
        int mod=1_000_000_007;
        List<List<Pair>> adjLs=new ArrayList<>();
        for(int i=0; i<V; i++) {
            adjLs.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++) {
            int u=roads[i][0];
            int v=roads[i][1];
            long w=roads[i][2];
            adjLs.get(u).add(new Pair(v, w));
            adjLs.get(v).add(new Pair(u, w));
        }
        long[] dist=new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways=new int[V];
        Arrays.fill(ways, 0);
        dist[0]=0;
        ways[0]=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->Long.compare(a.weight, b.weight));
        pq.offer(new Pair(0, dist[0]));
        while(!pq.isEmpty()) {
            Pair curr=pq.poll();
            int currNode=curr.node;
            long currWeight=curr.weight;
            if(currWeight>dist[currNode]) {
                continue;
            }
            for(Pair nbrs : adjLs.get(currNode)) {
                int nbrsNode=nbrs.node;
                long nbrsWeight=nbrs.weight;
                if(nbrsWeight+currWeight<dist[nbrsNode]) {
                    dist[nbrsNode]=nbrsWeight+currWeight;
                    pq.offer(new Pair(nbrsNode, dist[nbrsNode]));
                    ways[nbrsNode]=ways[currNode];
                }
                else if(nbrsWeight+currWeight==dist[nbrsNode]) {
                    ways[nbrsNode]=(ways[nbrsNode]+ways[currNode])%mod;
                }
            }
        }
        return ways[V-1]%mod;
    }
}
