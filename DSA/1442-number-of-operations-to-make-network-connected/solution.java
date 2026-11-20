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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int edgesExtra=0;
        for(int i=0; i<connections.length; i++) {
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.findUParent(u)==ds.findUParent(v)) {
                edgesExtra++;
            }
            else {
                ds.unionBySize(u, v);
            }
        }
        int nc=0;
        for(int i=0; i<n; i++) {
            if(ds.findUParent(i)==i) {
                nc++;
            }
        }
        int ans=nc-1;
        if(edgesExtra>=nc-1) {
            return ans;
        }
        return -1;
    }
}
