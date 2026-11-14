class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int minSum=Integer.MAX_VALUE;
        for(int i=l; i<=r; i++) {
            int left=0;
            int right=0;
            int sum=0;
            while(right<n) {
                sum+=nums.get(right);
                if(right-left+1==i) {
                    if(sum>0) {
                        minSum=Math.min(minSum, sum);
                    }
                    sum-=nums.get(left);
                    left++;
                }
                right++;
            }
        }
        if(minSum==Integer.MAX_VALUE) {
            return -1;
        }
        return minSum;
    }
}
