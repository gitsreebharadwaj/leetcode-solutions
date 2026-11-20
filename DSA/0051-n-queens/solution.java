class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(char[] row : board) {
            Arrays.fill(row, '.');
        }
        int[] left=new int[n];
        int[] upperdiagonal=new int[2*n-1];
        int[] lowerdiagonal=new int[2*n-1];
        solve(0, board, n, left, upperdiagonal, lowerdiagonal, ans);
        return ans;
    }
    public void solve(int col, char[][] board, int n, int[] left, int[] upperdiagonal, int[] lowerdiagonal, List<List<String>> ans) {
        if(col==n) {
            List<String> temp=new ArrayList<>();
            for(int i=0; i<n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int row=0; row<n; row++) {
            if(left[row]==0 && upperdiagonal[row+col]==0 && lowerdiagonal[n-1+col-row]==0) {
                board[row][col]='Q';
                left[row]=1;
                upperdiagonal[row+col]=1;
                lowerdiagonal[n-1+col-row]=1;
                solve(col+1, board, n, left, upperdiagonal, lowerdiagonal, ans);
                board[row][col]='.';
                left[row]=0;
                upperdiagonal[row+col]=0;
                lowerdiagonal[n-1+col-row]=0;
            }
        }
    }
}
