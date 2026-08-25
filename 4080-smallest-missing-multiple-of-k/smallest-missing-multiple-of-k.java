class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums){
            hs.add(num);
        }
        int i=1;
        while(hs.contains(k*i)){
            i++;
        }
        if(!hs.contains(k*i)){
                return k*i;
        }
        return -1;
    }
}