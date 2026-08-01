class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0 || i==n-1 || j==0 || j==m-1) {
                    if(!vis[i][j] && grid[i][j]==1) {
                        q.offer(new Pair(i, j));
                        vis[i][j]=true;
                    }
                }
            }
        }
        int[] delrow={-1, 0, 1, 0};
        int[] delcol={0, 1, 0, -1};
        while(!q.isEmpty()) {
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            for(int del=0; del<4; del++) {
                int nrow=r+delrow[del];
                int ncol=c+delcol[del];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && grid[nrow][ncol]==1) {
                    q.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol]=true;
                }
            }
        }
        int cnt=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!vis[i][j] && grid[i][j]==1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
