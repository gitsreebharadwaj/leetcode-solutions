class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ansList=new ArrayList<>();
        for(int i=1; i<=numRows; i++) {
            ansList.add(generateRow(i));
        }
        return ansList;
    }
    private List<Integer> generateRow(int row) {
        List<Integer> rowList=new ArrayList<>();
        int ans=1;
        rowList.add(ans);
        for(int i=1; i<row; i++) {
            ans=ans*(row-i);
            ans=ans/i;
            rowList.add(ans);
        }
        return rowList;
    }
}
