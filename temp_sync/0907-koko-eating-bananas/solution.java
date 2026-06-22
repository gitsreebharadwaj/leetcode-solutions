class Solution {
    public int maxValue(int piles[]) {
        int max=Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++) {
            max=Math.max(max, piles[i]);
        }
        return max;
    }
    public int hoursCount(int[] piles, int hourly) {
        int totalhrs=0;
        for(int i=0; i<piles.length; i++) {
            totalhrs+=Math.ceil((double)piles[i]/hourly);
        }
        return totalhrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=1;
        int high=maxValue(piles);
        int ans=Integer.MAX_VALUE;
        while(low<=high) {
            int mid=(low+high)/2;
            int totalhrs=hoursCount(piles, mid);
            if(totalhrs<=h) {
                ans=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return ans;
    }
}
