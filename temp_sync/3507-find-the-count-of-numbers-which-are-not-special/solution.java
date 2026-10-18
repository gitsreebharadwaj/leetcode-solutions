class Solution {
    public int nonSpecialCount(int l, int r) {
        boolean[] isComposite=primes((int)Math.sqrt(1e10));
        int cnt=0;
        int start=(int)Math.ceil(Math.sqrt(l));
        int end=(int)Math.sqrt(r);
        for(int i=start; i<=end; i++) {
            if(!isComposite[i]) {
                cnt++;
            }
        }
        return (r-l+1)-cnt;
    }
    private boolean[] primes(int n) {
        boolean[] isComposite=new boolean[n+1];
        if(n>=0) {
            isComposite[0]=true;
        }
        if(n>=1) {
            isComposite[1]=true;
        }
        for(int i=2; i*i<=n; i++) {
            if(!isComposite[i]) {
                for(int j=i*i; j<=n; j+=i) {
                    isComposite[j]=true;
                }
            }
        }
        return isComposite;
    }
}
