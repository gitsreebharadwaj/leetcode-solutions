class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        int[] delrow={-1, 0, 1, 0};
        int[] delcol={0, 1, 0, -1};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==1) {
                    return dfs(i, j, vis, grid, delrow, delcol, n, m);
                }
            }
        }
        return 0;
    }
    private int dfs(int row, int col, boolean[][] vis, int[][] grid,
    int[] delrow, int[] delcol, int n, int m) {
        if(row<0 || row>=n || col<0 || col>=m || grid[row][col]==0) {
            return 1;
        }
        if(vis[row][col]) {
            return 0;
        }
        vis[row][col]=true;
        int perimeter=0;
        for(int del=0; del<4; del++) {
            int nrow=row+delrow[del];
            int ncol=col+delcol[del];
            perimeter+=dfs(nrow, ncol, vis, grid, delrow, delcol, n, m);
        }
        return perimeter;
    }
}
