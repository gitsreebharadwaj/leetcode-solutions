class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<2) {
            return true;
        }
        long r=num;
        while(r>num/r) {
            r=(r+num/r)/2;
        }
        return r*r==num;
    }
}
