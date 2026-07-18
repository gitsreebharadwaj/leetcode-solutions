class Solution {
    public int myAtoi(String s) {
        if(s==null) {
            return 0;
        }
        s=s.trim();
        if(s.isEmpty()) {
            return 0;
        }
        int sign=1;
        int i=0;
        if(s.charAt(i)=='-') {
            sign=-1;
            i=1;
        }
        else if(s.charAt(i)=='+') {
            sign=1;
            i=1;
        }
        return solve(s, i, sign, 0);
    }
    public int solve(String s, int i, int sign, long currNum) {
        if(i>=s.length() || !Character.isDigit(s.charAt(i))) {
            return (int)(currNum*sign);
        }
        int digit=s.charAt(i)-'0';
        long nextNum=currNum*10+digit;
        if(sign==1 && nextNum>=Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(sign==-1 && -nextNum<=Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return solve(s, i+1, sign, nextNum);
    }
}
