class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            boolean[] seen=new boolean[10];
            for(int j=0; j<9; j++) {
                if(!isValid(board[i][j], seen)) {
                    return false;
                }
            }
        }
        for(int i=0; i<9; i++) {
            boolean[] seen=new boolean[10];
            for(int j=0; j<9; j++) {
                if(!isValid(board[j][i], seen)) {
                    return false;
                }
            }
        }
        for(int i=0; i<9; i++) {
            boolean[] seen=new boolean[10];
            int rowVal=(i/3)*3;
            int colVal=(i%3)*3;
            for(int row=0; row<3; row++) {
                for(int col=0; col<3; col++) {
                    if(!isValid(board[rowVal+row][colVal+col], seen)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isValid(char val, boolean[] seen) {
        if(val=='.') {
            return true;
        }
        int num=val-'0';
        if(seen[num]) {
            return false;
        }
        seen[num]=true;
        return true;
    }
}
