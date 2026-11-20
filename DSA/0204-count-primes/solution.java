class Solution {
    public int countPrimes(int n) {
        if(n<=2) {
            return 0;
        }
        boolean[] isComposite=new boolean[n];
        for(int i=2; i<Math.sqrt(n); i++) {
            if(!isComposite[i]) {
                for(int j=i*i; j<n; j+=i) {
                    isComposite[j]=true;
                }
            }
        }
        int cnt=0;
        for(int i=2; i<n; i++) {
            if(!isComposite[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
