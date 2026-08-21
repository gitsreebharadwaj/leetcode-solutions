class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int m=triangle.get(n-1).size();
        int[] prev=new int[m];
        for(int j=0; j<m; j++) {
            prev[j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2; i>=0; i--) {
            int[] temp=new int[m];
            for(int j=i; j>=0; j--) {
                int curr=triangle.get(i).get(j);
                int down=prev[j];
                int dr=prev[j+1];
                temp[j]=curr+Math.min(down, dr);
            }
            prev=temp;
        }
        return prev[0];
    }
}
