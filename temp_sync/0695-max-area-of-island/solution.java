class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int[] delrow={-1, 0, 1, 0};
        int[] delcol={0, 1, 0, -1};
        int maxArea=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1 && !vis[i][j]) {
                    int area=dfs(i, j, vis, grid, delrow, delcol, n, m);
                    maxArea=Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int row, int col, boolean[][] vis, int[][] grid,
    int[] delrow, int[] delcol, int n, int m) {
        vis[row][col]=true;
        int area=1;
        for(int del=0; del<4; del++) {
            int nrow=row+delrow[del];
            int ncol=col+delcol[del];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
            !vis[nrow][ncol] && grid[nrow][ncol]==1) {
                area+=dfs(nrow, ncol, vis, grid, delrow, delcol, n, m);
            }
        }
        return area;
    }
}
