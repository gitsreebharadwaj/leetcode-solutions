class Solution {
    public int minEatingSpeed(int[] chocolates, int hours) {
        int ans = 0;
        int left=1;
        int right=0;
        for(int c:chocolates) {
            right=Math.max(right, c);
        }
        ans=right;
        while(left<=right) {
            int mid=left+(right-left)/2;
            long time=0;
            for(int c:chocolates) {
                time+=(c+mid-1)/mid;
            }
            if(time<=hours) {
                ans=mid;
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return ans;
    }
}
