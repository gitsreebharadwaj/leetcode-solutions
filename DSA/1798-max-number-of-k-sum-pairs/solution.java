class Solution {
    public int maxOperations(int[] nums, int k) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        int count=0;
        for(int i=0; i<n; i++) {
            int current = nums[i];
            int need = k-current;
            if(map.containsKey(need) && map.get(need)>0) {
                count++;
                map.put(need, map.get(need)-1);
            }
            else {
                if(map.containsKey(current)) {
                    map.put(current, map.get(current)+1);
                }
                else {
                    map.put(current, 1);
                }
            }
        }
        return count;
    }
}
