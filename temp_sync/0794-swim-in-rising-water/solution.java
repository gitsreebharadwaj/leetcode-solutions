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
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        List<int[]> cells=new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                cells.add(new int[]{grid[i][j], i, j});
            }
        }
        Collections.sort(cells, (a, b)->Integer.compare(a[0], b[0]));
        boolean[][] visited=new boolean[n][n];
        int[] dr={-1, 0, 1, 0};
        int[] dc={0, 1, 0, -1};
        for(int[] cell : cells) {
            int time=cell[0];
            int row=cell[1];
            int col=cell[2];
            visited[row][col]=true;
            for(int del=0; del<4; del++) {
                int nrow=row+dr[del];
                int ncol=col+dc[del];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && visited[nrow][ncol]) {
                    int nodeNo=row*n+col;
                    int adjNodeNo=nrow*n+ncol;
                    ds.unionBySize(nodeNo, adjNodeNo);
                }
            }
            if(ds.findUParent(0)==ds.findUParent(n*n-1)) {
                return time;
            }
        }
        return 0;
    }
}
