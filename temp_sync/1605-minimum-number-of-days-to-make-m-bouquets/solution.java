class Solution {
    public boolean possible(int[] bloomDay, int day, int m, int k) {
        int cnt=0;
        int noOfB=0;
        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i]<=day) {
                cnt++;
            }
            else {
                noOfB+=cnt/k;
                cnt=0;
            }
        }
        noOfB+=cnt/k;
        if(noOfB>=m) {
            return true;
        }
        return false;
    }
    public int min(int[] bloomDay) {
        int min=Integer.MAX_VALUE;
        for(int i=0; i<bloomDay.length; i++) {
            min=Math.min(min, bloomDay[i]);
        }
        return min;
    }
    public int max(int[] bloomDay) {
        int max=Integer.MIN_VALUE;
        for(int i=0; i<bloomDay.length; i++) {
            max=Math.max(max, bloomDay[i]);
        }
        return max;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int low=min(bloomDay);
        int high=max(bloomDay);
        if(n<(long)m*k) {
            return -1;
        }
        while(low<=high) {
            int mid=(low+high)/2;
            if(possible(bloomDay, mid, m, k)) {
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }
}
