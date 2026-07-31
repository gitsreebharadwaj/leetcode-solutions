class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        int[][] ans=image;
        int[] delrow={-1, 0, 1, 0};
        int[] delcol={0, 1, 0, -1};
        dfs(ans, image, sr, sc, initialColor, color, delrow, delcol);
        return ans;
    }
    public void dfs(int[][] ans, int[][] image, int r, int c, int initialColor, int color, int[] delrow, int[] delcol) {
        ans[r][c]=color;
        int n=image.length;
        int m=image[0].length;
        for(int del=0;  del<4; del++) {
            int nrow=r+delrow[del];
            int ncol=c+delcol[del];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && ans[nrow][ncol]!=color && image[nrow][ncol]==initialColor) {
                dfs(ans, image, nrow, ncol, initialColor, color, delrow, delcol);
            }
        }
    }
}
