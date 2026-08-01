class Solution {
    public boolean predictTheWinner(int[] nums) {
        return helper(nums , 0 , nums.length-1 , 0 , 0 , true);
    }
    public static boolean helper(int[] nums , int start , int end , int p1 , int p2 , boolean p11 ){
        if(start > end ){
            if(p1 >= p2){
                return true;
            }else{
                return false;
            }
        }
        boolean s = false;
        boolean e = false;
        if(p11){
             s = helper(nums , start+1 , end , p1+nums[start] , p2 , false );
             e = helper(nums , start , end-1 , p1+nums[end] , p2 , false );
            return s || e;
        }else{
            s = helper(nums , start+1 , end , p1 , p2+nums[start] , true );
            e = helper(nums , start , end-1 , p1 , p2 + nums[end] , true );
            return s && e;
        }
    }
}