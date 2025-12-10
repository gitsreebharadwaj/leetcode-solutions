class Solution {
    public int singleNumber(int[] A) {
int ans = A[0];
// complete the function
for(int i=1; i<A.length; i++)
 {
ans=ans^A[i];
 }
return ans;
 }
}
