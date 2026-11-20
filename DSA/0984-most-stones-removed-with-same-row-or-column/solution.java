class DisjointSet {
    int[] rank;
    int[] size;
    int[] parent;
    DisjointSet(int n) {
        rank=new int[n];
        size=new int[n];
        parent=new int[n];
        for(int i=0; i<n; i++) {
            rank[i]=0;
            size[i]=1;
            parent[i]=i;
        }
    }
    int findUParent(int node) {
        if(node==parent[node]) {
            return node;
        }
        return parent[node]=findUParent(parent[node]);
    }
    void unionDirect(int u, int v) {
        int upu=findUParent(u);
        int upv=findUParent(v);
        if(upu!=upv) {
            parent[upu]=upv;
        }
    }
    void unionByRank(int u, int v) {
        int upu=findUParent(u);
        int upv=findUParent(v);
        if(upu==upv) {
            return;
        }
        if(rank[upu]<rank[upv]) {
            parent[upu]=upv;
        }
        else if(rank[upv]<rank[upu]) {
            parent[upv]=upu;
        }
        else {
            parent[upv]=upu;
            rank[upu]+=1;
        }
    }
    void unionBySize(int u, int v) {
        int upu=findUParent(u);
        int upv=findUParent(v);
        if(upu==upv) {
            return;
        }
        if(size[upu]<size[upv]) {
            parent[upu]=upv;
            size[upv]+=size[upu];
        }
        else {
            parent[upv]=upu;
            size[upu]+=size[upv];
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int maxRow=0;
        int maxCol=0;
        for(int i=0; i<n; i++) {
            maxRow=Math.max(maxRow, stones[i][0]);
            maxCol=Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds=new DisjointSet(maxRow+maxCol+2);
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<n; i++) {
            int nodeRow=stones[i][0];
            int nodeCol=maxRow+stones[i][1]+1;
            ds.unionBySize(nodeRow, nodeCol);
            map.put(nodeRow, 1);
            map.put(nodeCol, 1);
        }
        int cnt=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(ds.findUParent(entry.getKey())==entry.getKey()) {
                cnt++;
            }
        }
        return n-cnt;
    }
}
