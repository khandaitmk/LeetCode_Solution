class Solution {
    public boolean check(int[] nums) {
    int n=nums.length;
    int [] original=Arrays.copyOf(nums,n);
       Arrays.sort(nums);
        for(int x=0;x<n;x++){
            boolean match =true;
            for (int i=0;i<n;i++){
                if(nums[(i+x)%n]!=original[i]){
                    match= false;
                    break;
                }
            }
        if(match) return true;
        }
        return false;
    }
}