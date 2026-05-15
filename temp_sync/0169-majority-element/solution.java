class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int item : nums) {
            if(!map.containsKey(item)) {
                map.put(item, 1);
            }
            else {
                map.put(item, map.get(item)+1);
            }
        }
        int n=nums.length;
        for(int item : map.keySet()) {
            if(map.get(item) > n/2) {
                return item;
            }
        }
        return -1;
    }
}
