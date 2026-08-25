class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int i=0; i<nums.length; i++) {
            totalSum+=nums[i];
        }
        if(totalSum%2!=0) {
            return false;
        }
        return isSubsetSum(nums, totalSum/2);
    }
    public boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        int m=sum+1;
        boolean[] prev=new boolean[m];
        prev[0]=true;
        if(arr[0]<=sum) {
            prev[arr[0]]=true;
        }
        for(int i=1; i<n; i++) {
            boolean[] curr=new boolean[m];
            curr[0]=true;
            for(int j=1; j<=sum; j++) {
                boolean notTake=prev[j];
                boolean take=false;
                if(arr[i]<=j) {
                    take=prev[j-arr[i]];
                }
                curr[j]=notTake||take;
            }
            prev=curr;
        }
        return prev[sum];
    }
}
