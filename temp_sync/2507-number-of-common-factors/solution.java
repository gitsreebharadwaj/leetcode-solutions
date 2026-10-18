class Solution {
    public int commonFactors(int a, int b) {
        int hcf=gcd(a, b);
        int cnt=0;
        for(int i=1; i<=hcf; i++) {
            if(a%i==0 && b%i==0) {
                cnt++;
            }
        }
        return cnt;
    }
    private int gcd(int a, int b) {
        return b==0 ? a : gcd(b, a%b);
    }
}
