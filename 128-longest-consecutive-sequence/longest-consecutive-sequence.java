class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            ts.add(nums[i]);
        }
        Integer[] arr = ts.toArray(new Integer[0]);
        int res = 1;
        int count = 1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i] == 1){
                count++;
                res = Math.max(res,count);
            }else{
                count = 1;
            }
        }
        return res;
    }
}