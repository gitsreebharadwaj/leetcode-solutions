class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += (nums[i] == 0) ? -1 : 1;
            if (map.containsKey(prefixSum)) {
                int length = i - map.get(prefixSum);
                maxLen = Math.max(maxLen, length);
            } else {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}
