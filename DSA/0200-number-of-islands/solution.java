class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int cnt=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]=='1' && !vis[i][j]) {
                    cnt++;
                    bfs(grid, vis, i, j);
                }
            }
        }
        return cnt;
    }
    public void bfs(char[][] grid, boolean[][] vis, int i, int j) {
        vis[i][j]=true;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(i, j));
        int n=grid.length;
        int m=grid[0].length;
        int[] delrow={-1, 0, 1, 0};
        int[] delcol={0, 1, 0, -1};
        while(!q.isEmpty()) {
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            for(int del=0; del<4; del++) {
                int nrow=r+delrow[del];
                int ncol=c+delcol[del];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && !vis[nrow][ncol]) {
                    q.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol]=true;
                }
            }
        }
    }
}
