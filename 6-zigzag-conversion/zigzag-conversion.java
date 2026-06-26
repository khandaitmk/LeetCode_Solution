class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = s.length();
        Character[][] arr = new Character[numRows][n];

        int row = 0;
        int col = 0;
        boolean forward = true;
        for(char ch : s.toCharArray()){
            arr[row][col] = ch;
            if(row == numRows-1){
                forward = false;
            }else if(row == 0){
                forward = true;
            }

            if(forward){
                row++;
            }else {
                row--;
                col++;
            }
        }
        StringBuilder res  = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j] != null){
                    res.append(arr[i][j]);
                }
            }
        }
        return res.toString();
    }
}