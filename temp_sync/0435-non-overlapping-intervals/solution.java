class Group {
    int start;
    int finish;
    Group(int start, int finish) {
        this.start=start;
        this.finish=finish;
    }
}
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Group[] g=new Group[n];
        for(int i=0; i<n; i++) {
            g[i]=new Group(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(g, (a, b)->Integer.compare(a.finish, b.finish));
        int cnt=1;
        int overlap=g[0].finish;
        for(int i=1; i<n; i++) {
            if(g[i].start>=overlap) {
                cnt++;
                overlap=g[i].finish;
            }
        }
        return n-cnt;
    }
}
