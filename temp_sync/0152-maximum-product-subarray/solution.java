class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int cfp=1;
        for(int i=0; i<nums.length; i++) {
            cfp*=nums[i];
            if(cfp>max) {
                max=cfp;
            }
            if(cfp==0) {
                cfp=1;
            }
        }
        cfp=1;
        for(int i=nums.length-1; i>=0; i--) { 
            cfp*=nums[i]; 
            if(cfp>max) { 
                max=cfp; 
            } 
            if(cfp==0) { 
                cfp=1; 
            } 
        }
        return max;
    }
}
