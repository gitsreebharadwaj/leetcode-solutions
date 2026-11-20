class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int j=-1;
        for(int i=n-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                j=i;
                break;
            }
        }
        if(j==-1) {
            reverse(nums, 0, n-1);
            return;
        }
        for(int i=n-1; i>=j; i--) {
            if(nums[i]>nums[j]) {
                swap(nums, i, j);
                break;
            }
        }
        reverse(nums, j+1, n-1);
    }
    void swap(int[] nums, int a, int b) {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    void reverse(int[] nums, int i, int j) {
        while(i<j) {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}
