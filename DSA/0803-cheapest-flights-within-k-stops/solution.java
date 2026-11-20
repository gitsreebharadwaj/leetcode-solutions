class Triplet {
    int stops;
    int node;
    int cost;
    Triplet(int stops, int node, int cost) {
        this.stops=stops;
        this.node=node;
        this.cost=cost;
    }
}
class Pair {
    int node;
    int weight;
    Pair(int node, int weight) {
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int findCheapestPrice(int V, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adjLs=new ArrayList<>();
        for(int i=0; i<V; i++) {
            adjLs.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++) {
            int u=flights[i][0];
            int v=flights[i][1];
            int w=flights[i][2];
            adjLs.get(u).add(new Pair(v, w));
        }
        int[] dist=new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        Queue<Triplet> q=new LinkedList<>();
        q.offer(new Triplet(0, src, dist[src]));
        while(!q.isEmpty()) {
            Triplet curr=q.poll();
            int stops=curr.stops;
            int node=curr.node;
            int cost=curr.cost;
            if(stops>k) {
                continue;
            }
            for(Pair nbrs : adjLs.get(node)) {
                int nbrsNode=nbrs.node;
                int nbrsWeight=nbrs.weight;
                if(cost+nbrsWeight<dist[nbrsNode] && stops<=k) {
                    dist[nbrsNode]=cost+nbrsWeight;
                    q.offer(new Triplet(stops+1, nbrsNode, dist[nbrsNode]));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE) {
            return -1;
        }
        return dist[dst];
    }
}
