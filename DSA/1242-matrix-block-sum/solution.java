class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] prefix=new int[n][m];
        prefix[0][0]=mat[0][0];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int top=(i>0) ? prefix[i-1][j] : 0;
                int left=(j>0) ? prefix[i][j-1] : 0;
                int topLeft=(i>0 && j>0) ? prefix[i-1][j-1] : 0;
                prefix[i][j]=mat[i][j]+top+left-topLeft;
            }
        }
        int[][] ans=new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int r1=Math.max(i-k, 0);
                int c1=Math.max(j-k, 0);
                int r2=Math.min(i+k, n-1);
                int c2=Math.min(j+k, m-1);
                int subTop=(r1>0) ? prefix[r1-1][c2] : 0;
                int subLeft=(c1>0) ? prefix[r2][c1-1] : 0;
                int subTopLeft=(r1>0 && c1>0) ? prefix[r1-1][c1-1] : 0;
                ans[i][j]=prefix[r2][c2]-subTop-subLeft+subTopLeft;
            }
        }
        return ans;
    }
}
