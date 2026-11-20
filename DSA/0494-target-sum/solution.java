class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums, target);        
    }
    public int countPartitions(int[] arr, int diff) {
        int n=arr.length;
        int totalSum=0;
        for(int i=0; i<n; i++) {
            totalSum+=arr[i];
        }
        if(totalSum-diff<0 || (totalSum-diff)%2!=0) {
            return 0;
        }
        return countSum(arr, (totalSum-diff)/2);
    }
    static int countSum(int[] arr, int target) {
        // code here
        int n=arr.length;
        int[] prev=new int[target+1];
        if(arr[0]==0) {
            prev[arr[0]]=2;
        }
        else {
            prev[0]=1;
            if(arr[0]<=target) {
                prev[arr[0]]=1;
            }
        }
        for(int i=1; i<n; i++) {
            int[] curr=new int[target+1];
            for(int j=0; j<=target; j++) {
                int notTake=prev[j];
                int take=0;
                if(arr[i]<=j) {
                    take=prev[j-arr[i]];
                }
                curr[j]=notTake+take;
            }
            prev=curr;
        }
        return prev[target];
    }
}
