class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates , n ,target, new ArrayList<>() , res , 0,0);
        return res;
    }
    public static void helper(int[] candidates , int n ,int target , List<Integer> temp , List<List<Integer>> res , int tempSum , int start){
        if(tempSum == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(start == n){
            return;
        }
        if(candidates[start] <= target - tempSum){
            tempSum += candidates[start];
            temp.add(candidates[start]);
            helper(candidates , n , target , temp , res,tempSum , start);
            tempSum -= candidates[start];
            temp.removeLast();
        }
            helper(candidates , n , target , temp , res,tempSum , start+1);
    }
}