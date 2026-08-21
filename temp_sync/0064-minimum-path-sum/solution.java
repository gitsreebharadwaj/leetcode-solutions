class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] prev=new int[m];
        for(int i=0; i<n; i++) {
            int[] temp=new int[m];
            for(int j=0; j<m; j++) {
                if(i==0 && j==0) {
                    temp[j]=grid[i][j];
                }
                else {
                    int up=(i>0) ? prev[j] : Integer.MAX_VALUE;
                    int left=(j>0) ? temp[j-1] : Integer.MAX_VALUE;
                    if(up!=Integer.MAX_VALUE) {
                        up=grid[i][j]+up;
                    }
                    if(left!=Integer.MAX_VALUE) {
                        left=grid[i][j]+left;
                    }
                    temp[j]=Math.min(up, left);
                }
            }
            prev=temp;
        }
        return prev[m-1];
    }
}
