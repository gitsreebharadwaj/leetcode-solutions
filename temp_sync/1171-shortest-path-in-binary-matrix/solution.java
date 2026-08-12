class Triplet {
    int distance;
    int row;
    int col;
    Triplet(int distance, int row, int col) {
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1) {
            return -1;
        }
        if(n==1 && m==1) {
            return 1;
        }
        int[] delrow={-1, -1, 0, 1, 1, 1, 0, -1};
        int[] delcol={0, 1, 1, 1, 0, -1, -1, -1};
        int[][] dist=new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=1;
        Queue<Triplet> q=new LinkedList<>();
        q.offer(new Triplet(1, 0, 0));
        while(!q.isEmpty()) {
            Triplet curr=q.poll();
            int dis=curr.distance;
            int r=curr.row;
            int c=curr.col;
            for(int del=0; del<8; del++) {
                int nrow=r+delrow[del];
                int ncol=c+delcol[del];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0 && dis+1<dist[nrow][ncol]) {
                    dist[nrow][ncol]=dis+1;
                    if(nrow==n-1 && ncol==m-1) {
                        return dist[nrow][ncol];
                    }
                    q.offer(new Triplet(dist[nrow][ncol], nrow, ncol));
                }
            }
        }
        return -1;
    }
}
