class Triplet {
    int row;
    int col;
    int dis;
    Triplet(int row, int col, int dis) {
        this.row=row;
        this.col=col;
        this.dis=dis;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int[][] dist=new int[n][m];
        Queue<Triplet> q=new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==0) { 
                    q.offer(new Triplet(i, j, 0));
                    vis[i][j]=1;
                }
            }
        }
        int[] delrow={1, 0, -1, 0};
        int[] delcol={0, 1, 0, -1};
        while(!q.isEmpty()) {
            Triplet curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int dis=curr.dis;
            dist[r][c]=dis;
            for(int del=0; del<4; del++) {
                int nrow=r+delrow[del];
                int ncol=c+delcol[del];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=1) {
                    q.offer(new Triplet(nrow, ncol, dis+1));
                    vis[nrow][ncol]=1;
                }
            }
        }
        return dist;
    }
}
