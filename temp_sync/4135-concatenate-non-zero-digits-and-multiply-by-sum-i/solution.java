class Solution {
    public long sumAndMultiply(int n) {
        String num=Integer.toString(n);
        long x=0;
        long sum=0;
        for(int i=0; i<num.length(); i++) {
            int digit=num.charAt(i)-'0';
            if(digit==0) {
                continue;
            }
            x=x*10+digit;
            sum+=digit;
        }
        return (long)(x*sum);
    }
}
