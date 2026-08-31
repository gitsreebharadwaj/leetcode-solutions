class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<n; i++) {
            int num1=nums[i];
            int num2=target-num1;
            if(map.containsKey(num2)) {
                return new int[] {i, map.get(num2)};
            }
            map.put(num1, i);
        }
        return new int[]{};
    }
}
