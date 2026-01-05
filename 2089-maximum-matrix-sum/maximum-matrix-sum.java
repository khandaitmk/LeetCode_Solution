class Solution {
    public static long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        long small = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){

                if(matrix[i][j] < 1){
                    list.add(matrix[i][j]);
                }else{
                    if(matrix[i][j]<small){
                        small = matrix[i][j];
                    }
                    sum +=matrix[i][j];
                }
            }
        }
        Collections.sort(list);
        int n = list.size();
        long temp = 0;
        long list_small = Integer.MIN_VALUE;

        for(int i=0;i<list.size();i++){
            if(list_small<list.get(i)){
                list_small = list.get(i);
            }
            temp +=list.get(i);
        }
        if(n%2==0){
            return  sum + ((-1)*temp);
        }
            list_small = list_small*(-1);
            long abc = Math.min(list_small,small);
            return  sum + ((-1)*temp) - 2*abc;
        


//        return (long)sum;
    }
}