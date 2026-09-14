class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        for(int t=0; t<=amount; t++) {
            if(t%coins[0]==0) {
                prev[t]=1;
            }
            else {
                prev[t]=0;
            }
        }
        for(int idx=1; idx<n; idx++) {
            for(int target=0; target<=amount; target++) {
                int notTake=prev[target];
                int take=0;
                if(coins[idx]<=target) {
                    take=prev[target-coins[idx]];
                }
                prev[target]=notTake+take;
            }
        }
        return prev[amount];
    }
}
