import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
    int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        Set<Integer> keySet = hm.keySet();
        for(int key : keySet){
            if(hm.get(key) > n/2){
                return key;
            }
        }
        return -1;
    }
}
