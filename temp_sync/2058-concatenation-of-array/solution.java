class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[] ans=new int[2*n];
        int idx=0;
        int i=0;
        while(idx<2*n) {
            ans[idx]=nums[i];
            idx++;
            i++;
            if(i>=n) {
                i=0;
            }
        }
        return ans;
    }
}
