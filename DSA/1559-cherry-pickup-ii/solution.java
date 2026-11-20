class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] front=new int[m][m];
        for(int j1=0; j1<m; j1++) {
            for(int j2=0; j2<m; j2++) {
                if(j1==j2) front[j1][j2]=grid[n-1][j1];
                else front[j1][j2]=grid[n-1][j1]+grid[n-1][j2];
            }
        }
        for(int i=n-2; i>=0; i--) {
            int[][] curr=new int[m][m];
            for(int j1=0; j1<m; j1++) {
                for(int j2=0; j2<m; j2++) {
                    int maxM=Integer.MIN_VALUE;
                    int[] dj={-1, 0, 1};
                    for(int d1=0; d1<3; d1++) {
                        for(int d2=0; d2<3; d2++) {
                            int nextJ1=j1+dj[d1];
                            int nextJ2=j2+dj[d2];
                            if(nextJ1>=0 && nextJ1<m && nextJ2>=0 && nextJ2<m) {
                                if(j1==j2) {
                                    maxM=Math.max(maxM, grid[i][j1]+front[nextJ1][nextJ2]);
                                }
                                else {
                                    maxM=Math.max(maxM, grid[i][j1]+grid[i][j2]+front[nextJ1][nextJ2]);
                                }
                            }
                        }
                    }
                    curr[j1][j2]=maxM;
                }
            }
            front=curr;
        }
        return front[0][m-1];
    }
}
