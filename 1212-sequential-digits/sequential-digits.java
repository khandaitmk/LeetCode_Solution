class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=1;i<10;i++){
            helper(low , high , res , i);
        }
        Collections.sort(res);
        return res;
    }
    public static void helper(int low , int high , ArrayList<Integer> res , int temp){
        if(temp >= low && temp <= high){
            res.add(temp);
        }
        if(temp > high){
            return;
        }
        int prev = (temp % 10 );
        int next = prev + 1;
        if(next >= 10){
            return;
        }
        temp = temp * 10 + next;
        helper(low , high , res , temp);
    }
}