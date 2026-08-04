class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            hs.add(num);
            min = Math.min(min , num);
            max = Math.max(max , num);
        }
        for(int i=min;i<=max ;i++){
            if(!hs.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}