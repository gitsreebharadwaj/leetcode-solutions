class Solution {
    public int findNumbers(int[] nums) {
        int evenCount=0;
        for(int num : nums) {
            if(evenDigits(num)) {
                evenCount++;
            }
        }
        return evenCount;
    }
    public boolean evenDigits(int num) {
        int count=0;
        if(num==0) {
            return false;
        }
        while(num>0) {
            num/=10;
            count++;
        }
        return count%2==0;
    }
}
