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
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                if(grid[row][col]==0) {
                    continue;
                }
                int[] dr={-1, 0, 1, 0};
                int[] dc={0, 1, 0, -1};
                for(int del=0; del<4; del++) {
                    int nrow=row+dr[del];
                    int ncol=col+dc[del];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1) {
                        int nodeNo=row*n+col;
                        int adjNodeNo=nrow*n+ncol;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        int maxSize=0;
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                if(grid[row][col]==1) {
                    continue;
                }
                int[] dr={-1, 0, 1, 0};
                int[] dc={0, 1, 0, -1};
                Set<Integer> set=new HashSet<>();
                for(int del=0; del<4; del++) {
                    int nrow=row+dr[del];
                    int ncol=col+dc[del];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n) {
                        if(grid[nrow][ncol]==1) {
                            int nodeNo=nrow*n+ncol;
                            set.add(ds.findUParent(nodeNo));
                        }
                    }
                }
                int sizeTotal=1;
                for(int it : set) {
                    sizeTotal+=ds.size[it];
                }
                maxSize=Math.max(maxSize, sizeTotal);
            }
        }
        for(int i=0; i<n*n; i++) {
            maxSize=Math.max(maxSize, ds.size[ds.findUParent(i)]);
        }
        return maxSize;
    }
}
