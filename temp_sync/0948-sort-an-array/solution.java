class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        if(n==0) {
            return new int[0];
        }
        int minVal=Integer.MAX_VALUE;
        int maxVal=Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            minVal=Math.min(minVal, nums[i]);
        }
        for(int i=0; i<n; i++) {
            nums[i]-=minVal;
            maxVal=Math.max(maxVal, nums[i]);
        }
        for(int exp=1; maxVal/exp>0; exp*=10) {
            countSort(nums, exp);
        }
        for(int i=0; i<n; i++) {
            nums[i]+=minVal;
        }
        return nums;
    }
    public void countSort(int[] arr, int exp) {
        int n=arr.length;
        int[] ans=new int[n];
        int[] cntArr=new int[10];
        for(int i=0; i<n; i++) {
            int digit=(arr[i]/exp)%10;
            cntArr[digit]++;
        }
        for(int i=1; i<10; i++) {
            cntArr[i]+=cntArr[i-1];
        }
        for(int i=n-1; i>=0; i--) {
            int digit=(arr[i]/exp)%10;
            ans[cntArr[digit]-1]=arr[i];
            cntArr[digit]--;
        }
        System.arraycopy(ans, 0, arr, 0, n);
    }
}
