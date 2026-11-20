class Pair {
    int one;
    int two;
    Pair(int one, int two) {
        this.one=one;
        this.two=two;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int i=0;
        List<Pair> res=new ArrayList<>();
        while(i<n && intervals[i][1]<newInterval[0]) {
            res.add(new Pair(intervals[i][0], intervals[i][1]));
            i++;
        }
        int min=newInterval[0];
        int max=newInterval[1];
        while(i<n && intervals[i][0]<=newInterval[1]) {
            min=Math.min(min, intervals[i][0]);
            max=Math.max(max, intervals[i][1]);
            i++;
        }
        res.add(new Pair(min, max));
        while(i<n) {
            res.add(new Pair(intervals[i][0], intervals[i][1]));
            i++;
        }
        int size=res.size();
        int[][] ans=new int[size][2];
        for(int x=0; x<size; x++) {
            Pair curr=res.get(x);
            ans[x][0]=curr.one;
            ans[x][1]=curr.two;
        }
        return ans;
    }
}
