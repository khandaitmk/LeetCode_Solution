class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start1=0;
        int start2=0;
        int end1 = nums1.length;
        int end2 = nums2.length;
        ArrayList<Integer> l = new ArrayList<>();

        while(start1<end1 && start2 < end2){
            if(nums1[start1]<nums2[start2]){
                l.add(nums1[start1]);
                start1++;
            }else{
                l.add(nums2[start2]);
                start2++;
            }
        }
        if(start1 != end1){
            while(start1<end1){
                l.add(nums1[start1]);
                start1++;
            }
        }
        if(start2 != end2){
            while(start2<end2){
                l.add(nums2[start2]);
                start2++;
            }
        }
        int n = l.size();
        int mid = (n-1)/2;
        if(n%2 ==0){

            int res = l.get(mid)+l.get(mid+1);
            return (double)res/2;
        }
        return l.get(mid);
    }
}