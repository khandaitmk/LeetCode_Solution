class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        nQueen(board ,0 , res);
        return res;
    }
    public static boolean isSafe(char[][] board , int col , int row){
        //check upward
        int tempc = col;
        for(int i = row;i>=0;i--){
            if(board[i][tempc] == 'Q'){
                return false;
            }
        }
        //check left diagonal
        int tempRow = row;
        int tempCol = col;
        while(tempRow>=0 && tempCol >=0){
            if(board[tempRow][tempCol] =='Q'){
                return false;
            }
            tempRow--;
            tempCol--;
        }

        //check right diagonal
         tempRow = row;
         tempCol = col;
        while(tempRow>=0 && tempCol < board.length){
            if(board[tempRow][tempCol] =='Q'){
                return false;
            }
            tempRow--;
            tempCol++;
        }
        return true;
    }

    public static void nQueen(char[][] board , int row, List<List<String>> res){
        if(row == board.length){
            List<String> temp = new ArrayList<>();
            addResult(board,temp);
            res.add(temp);
            return;
        }
        for(int j = 0;j<board.length;j++){
            if(isSafe(board , j , row)){
                board[row][j] = 'Q';
                nQueen(board , row+1 , res);
                board[row][j] = '.';
            }
        }
    }
    public static void addResult(char[][] board , List<String> res){
        int n = board.length;
        for(int i=0;i<n;i++){
            StringBuilder str = new StringBuilder();
            for(int j=0;j<n;j++){
               str.append(board[i][j]);
            }
            res.add(str.toString());
        }
    }

}