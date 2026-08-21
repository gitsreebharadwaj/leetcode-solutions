class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[] prev=new int[m];
        for(int i=0; i<n; i++) {
            int[] temp=new int[m];
            for(int j=0; j<m; j++) {
                if(obstacleGrid[i][j]==1) {
                    temp[j]=0;
                }
                else if(i==0 && j==0) {
                    temp[j]=1;
                }
                else {
                    int up=(i>0) ? prev[j] : 0;
                    int left=(j>0) ? temp[j-1] : 0;
                    temp[j]=up+left;
                }
            }
            prev=temp;
        }
        return prev[m-1];
    }
}
