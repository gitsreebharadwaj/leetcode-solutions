class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) {
            return nums[0];
        }
        int[] temp1=new int[n-1];
        int[] temp2=new int[n-1];
        for(int i=1; i<n; i++) {
            temp1[i-1]=nums[i];
        }
        for(int i=0; i<n-1; i++) {
            temp2[i]=nums[i];
        }
        return Math.max(solve(temp1), solve(temp2));
    }
    public int solve(int[] nums) {
        int n=nums.length;
        int prev=nums[0];
        int prev2=0;
        for(int i=1; i<n; i++) {
            int take=nums[i]+prev2;
            int notTake=prev;
            int curr=Math.max(take, notTake);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}
