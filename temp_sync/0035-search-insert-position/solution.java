class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int temp=0;
        if(len==1)
        {
            if(nums[0]<target)
            {
                temp=1;
            }
            else
            {
                temp=0;
            }
        }
        else
        {
            for(int i=0; i<len-1; i++)
            {
                if(nums[i]==target)
                {
                    temp=i;
                }
                if(nums[i]<target)
                {
                    temp=i+1;
                }
                if(target>nums[len-1])
                {
                    temp=len;
                }
            }   
        }
        return temp;
    }
}
