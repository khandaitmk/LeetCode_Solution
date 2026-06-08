class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        int n = nums.length;
        for(int num : nums){
            if(num > pivot){
                l2.add(num);
            }else if(num < pivot){
                l1.add(num);
            }else{
                l3.add(num);
            }
        }
        int i = 0;
        while(!l1.isEmpty()){
            nums[i++] = l1.removeFirst();
        }
        while(!l3.isEmpty()){
            nums[i++] = l3.removeFirst();
        }
        while (!l2.isEmpty()){
            nums[i++] = l2.removeFirst();
        }
        return nums;
    }
}