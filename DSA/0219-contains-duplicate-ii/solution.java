class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            else {
                List<Integer> l=map.get(nums[i]);
                if(i-l.get(l.size()-1)<=k) {
                    return true;
                }
            }
                map.get(nums[i]).add(i);
        }
        return false;
    }
}
