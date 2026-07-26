class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int n=nums.length;
        int product=1;
        int product2=1;

        int b=0;
        if(n<3){
            for(int i=0;i<n;i++){
                product*=nums[i];
            }
        }else{
            product= nums[n-1] * nums[n-2] * nums[n-3];
            if(nums[0]<0 && nums[1]<0 && nums[n-1]>0){
                product2=nums[0] * nums[1] * nums[n-1];
                return Math.max(product,product2);
            }
        }
        return product;
    }}