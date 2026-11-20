class Solution {
    public int missingNumber(int[] nums) {
        int XOR=0;
        for(int i=0; i<=nums.length; i++) {
            XOR^=i;
        }
        for(int num : nums) {
            XOR^=num;
        }
        return XOR;
    }
}
