class Solution {
    public int[] singleNumber(int[] nums) {
        int XORxy=0;
        for(int num : nums) {
            XORxy^=num;
        }
        int rightmostBit=XORxy&(-XORxy);
        int x=0;
        int y=0;
        for(int num : nums) {
            if((num&rightmostBit)==0) {
                x^=num;
            }
            else {
                y^=num;
            }
        }
        return new int[]{x, y};
    }
}
