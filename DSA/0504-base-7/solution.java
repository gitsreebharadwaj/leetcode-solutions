class Solution {
    public String convertToBase7(int num) {
        if(num==0) {
            return "0";
        }
        boolean neg=num<0;
        long ans=0;
        long base=1;
        long n=Math.abs((long)num);
        while(n!=0) {
            long rem=n%7;
            ans=ans+(rem*base);
            base*=10;
            n/=7;
        }
        if(neg) {
            return "-"+String.valueOf(ans);
        }
        return String.valueOf(ans);
    }
}
