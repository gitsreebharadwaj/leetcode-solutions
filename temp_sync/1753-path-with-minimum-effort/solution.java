class Triplet {
    int difference;
    int row;
    int col;
    Triplet(int difference, int row, int col) {
        this.difference=difference;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[] delrow={-1, 0, 1, 0};
        int[] delcol={0, 1, 0, -1};
        int[][] dist=new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0; 
        PriorityQueue<Triplet> pq=new PriorityQueue<>((a, b)->a.difference-b.difference);
        pq.offer(new Triplet(0, 0, 0));
        while(!pq.isEmpty()) {
            Triplet curr=pq.poll();
            int diff=curr.difference;
            int r=curr.row;
            int c=curr.col;
            if(r==n-1 && c==m-1) {
                return diff;
            }
            if(diff>dist[r][c]) {
                continue;
            }
            for(int del=0; del<4; del++) {
                int nrow=r+delrow[del];
                int ncol=c+delcol[del];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m) {
                    int newEffort=Math.max(Math.abs(heights[r][c]-heights[nrow][ncol]), diff);
                    if(newEffort<dist[nrow][ncol]) {
                        dist[nrow][ncol]=newEffort;
                        pq.offer(new Triplet(dist[nrow][ncol], nrow, ncol));
                    }
                }
            }
        }
        return 0;
    }
}
