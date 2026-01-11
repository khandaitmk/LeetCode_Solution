class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreater = new int[nums2.length];
        Stack<Integer> sc = new Stack<>();
        int[] res = new int[nums1.length];
        for(int i=nums2.length-1;i>=0;i--){
            while(!sc.isEmpty() && nums2[sc.peek()]<=nums2[i]){
                sc.pop();
            }
            if(sc.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = nums2[sc.peek()]; 
            }
            sc.push(i);
        }
        for(int i=0;i<nums1.length;i++){
            int temp = indexOf(nums2,nums1[i]);
            res[i] = nextGreater[temp];
        }
        return res;
    }
    static int indexOf(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) return i;
    }
    return -1;
}

}