class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum=0;
        for(int num : nums) {
            totalSum+=num;
        }
        int target=totalSum-x;
        if(target<0) return -1;
        if(target==0) return nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);
        int preSum=0;
        int maxLen=-1;
        for(int i=0; i<nums.length; i++) {
            preSum+=nums[i];
            int req=preSum-target;
            if(map.containsKey(req)) {
                int len=i-map.get(req);
                maxLen=Math.max(maxLen, len);
            }
            if(!map.containsKey(preSum)){
                map.put(preSum, i);
            }
        }
        if(maxLen==-1) {
            return -1;
        }
        return nums.length-maxLen;
    }
}
