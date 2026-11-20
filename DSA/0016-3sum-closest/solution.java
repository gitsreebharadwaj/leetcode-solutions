class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
        int abs=Math.abs(ans-target);
        for(int i=0; i<n; i++) {
            int j=i+1;
            int k=n-1;
            while(j<k) {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target) {
                    return sum;
                }
                int currAbs=Math.abs(sum-target);
                if(currAbs<abs) {
                    abs=currAbs;
                    ans=sum;
                }
                else if(sum<target) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return ans;
    }
}
