class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        for(int t=0; t<=amount; t++) {
            if(t%coins[0]==0) {
                prev[t]=t/coins[0];
            }
            else {
                prev[t]=(int)1e9;
            }
        }
        for(int idx=1; idx<n; idx++) {
            int[] curr=new int[amount+1];
            for(int target=0; target<=amount; target++) {
                int notTake=prev[target];
                int take=(int)1e9;
                if(coins[idx]<=target) {
                    take=1+curr[target-coins[idx]];
                }
                curr[target]=Math.min(notTake, take);
            }
            prev=curr;
        }
        int ans=prev[amount];
        return ans>=(int)1e9 ? -1 : ans;
    }
}
