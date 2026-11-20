class Solution {
    public int findDuplicate(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int duplicate=-1;
        while(low<=high) {
            int mid=(low+high)/2;
            int cnt=0;
            for(int num : nums) {
                if(num<=mid) {
                    cnt++;
                }
            }
            if(cnt>mid) {
                duplicate=mid;
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return duplicate;
    }
}
