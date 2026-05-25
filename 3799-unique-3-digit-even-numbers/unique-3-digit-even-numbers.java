class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> res = new HashSet<>();
        helper(digits , new boolean[digits.length] , 0,0,res);
        return res.size();
    }
    public static void helper(int[] digits , boolean[] isTaken, int k , int temp , HashSet<Integer> hs){
        if(k==3){
            hs.add(temp);
            return;
        }
        for(int i=0;i< digits.length;i++){
            if(isTaken[i]){
                continue;
            }
            if(k == 0 && digits[i] == 0){
                continue;
            }
            if(k == 2 && digits[i] % 2 != 0){
                continue;
            }
            isTaken[i] = true;
            helper(digits , isTaken , k+1 , temp * 10 + digits[i] , hs );
            isTaken[i] = false;
        }
    }
}