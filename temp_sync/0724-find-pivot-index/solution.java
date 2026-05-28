class Solution {
    public int pivotIndex(int[] nums) {
        int len=nums.length;
        int[] prefix=new int[len];
        int[] suffix=new int[len];
        prefix[0]=nums[0];
        suffix[len-1]=nums[len-1];
        for(int i=1; i<len; i++) {
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int i=len-2; i>=0; i--) {
            suffix[i]=suffix[i+1]+nums[i];
        }
        for(int i=0; i<len; i++) {
            int leftsum=prefix[i]-nums[i];
            int rightsum=suffix[i]-nums[i];
            if(leftsum==rightsum) {
                return i;
            }
        }
        return -1;
    }
}
