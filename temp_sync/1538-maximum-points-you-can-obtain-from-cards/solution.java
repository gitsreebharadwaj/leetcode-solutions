class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum=0;
        int rsum=0;
        int maxSum=0;
        for(int l=0; l<k; l++) {
            lsum+=cardPoints[l];
        }
        maxSum=lsum;
        int r=cardPoints.length-1;
        for(int i=k-1; i>=0; i--) {
            lsum=lsum-cardPoints[i];
            rsum+=cardPoints[r];
            r--;
            maxSum=Math.max(maxSum, lsum+rsum);
        }
        return maxSum;
    }
}
