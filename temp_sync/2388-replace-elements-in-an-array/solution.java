class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int n=nums.length;
        int q=operations.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(nums[i], i);
        }
        for(int i=0; i<q; i++) {
            int num1=operations[i][0];
            int num2=operations[i][1];
            int idx=map.get(num1);
            map.remove(num1);
            nums[idx]=num2;
            map.put(num2, idx);
        }
        return nums;
    }
}
