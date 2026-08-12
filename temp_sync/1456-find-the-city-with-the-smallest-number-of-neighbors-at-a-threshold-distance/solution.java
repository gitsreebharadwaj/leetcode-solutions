class Solution {
    public int findTheCity(int V, int[][] edges, int distanceThreshold) {
        int[][] adjMat=new int[V][V];
        for(int i=0; i<V; i++) {
            for(int j=0; j<V; j++) {
                if(i==j) {
                    adjMat[i][j]=0;
                }
                else {
                  adjMat[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for(int[] edge : edges) {
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adjMat[u][v]=w;
            adjMat[v][u]=w;
        }
        for(int k=0; k<V; k++) {
            for(int i=0; i<V; i++) {
                for(int j=0; j<V; j++) {
                    if(adjMat[i][k]!=Integer.MAX_VALUE && adjMat[k][j]!=Integer.MAX_VALUE) {
                        adjMat[i][j]=Math.min(adjMat[i][j], (adjMat[i][k]+adjMat[k][j]));
                    }
                }
            }
        }
        int totalCities=V;
        int cityNo=-1;
        for(int city=0; city<V; city++) {
            int cnt=0;
            for(int adjCity=0; adjCity<V; adjCity++) {
                if(city!=adjCity && adjMat[city][adjCity]<=distanceThreshold) {
                    cnt++;
                }
            }
            if(cnt<=totalCities) {
                totalCities=cnt;
                cityNo=city;
            }
        }
        return cityNo;
    }
}
