class Triplet {
    int row;
    int col;
    int time;
    Triplet(int row, int col, int time) {
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        Queue<Triplet> q=new LinkedList<>();
        int cntFresh=0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j]==2) {
                    q.offer(new Triplet(i, j, 0));
                    vis[i][j]=2;
                }
                else if(grid[i][j]==1) {
                    cntFresh++;
                }
            }
        }
        int timer=0;
        int[] delrow={1, 0, -1, 0};
        int[] delcol={0, 1, 0, -1};
        int cntRotten=0;
        while(!q.isEmpty()) {
            Triplet curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int t=curr.time;
            timer=Math.max(timer, t);
            for(int del=0; del<4; del++) {
                int nrow=r+delrow[del];
                int ncol=c+delcol[del];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1) {
                    q.offer(new Triplet(nrow, ncol, t+1));
                    vis[nrow][ncol]=2;
                    cntRotten++;
                }
            }
        }
        if(cntRotten!=cntFresh) {
            return -1;
        }
        return timer;
    }
}
