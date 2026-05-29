class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len=nums.length;
        int[] res=new int[len];
        int i=0;
        int j=len-n;
        int x=0;
        while(x<len) {
            if(x%2==0) {
                res[x]=nums[i];
                i++;
            }
            else {
                res[x]=nums[j];
                j++;
            }
            x++;
        }
        return res;
    }
}
