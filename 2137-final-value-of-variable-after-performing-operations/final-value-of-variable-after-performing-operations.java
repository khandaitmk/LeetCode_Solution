class Solution {
    public int finalValueAfterOperations(String[] operations) {
        String inc1 = "X++";
        String dec1 = "--X";
        String inc2 = "++X";
        String dec2 = "X-";

        int temp = 0;
        for(String str : operations){
            if(str.equals(inc1) || str.equals(inc2)){
                temp++;
            }else{
                temp--;
            }
        }
        return temp;
    }
}