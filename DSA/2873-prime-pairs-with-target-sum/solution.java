class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] isComposite=primes(n);
        for(int i=2; i<=n/2; i++) {
            if(!isComposite[i]) {
                int another=n-i;
                if(!isComposite[another]) {
                    ans.add(Arrays.asList(i, another));
                }
            }
        }
        return ans;
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
