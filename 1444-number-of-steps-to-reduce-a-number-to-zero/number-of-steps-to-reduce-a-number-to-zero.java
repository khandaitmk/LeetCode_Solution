class Solution {
    public int numberOfSteps(int num) {
        return helper(num,0);
    }
    static int helper(int num,int step){
        if(num == 0){
            return step;
        }
        if(num % 2 == 0){
            num /=2;
            step++;
            return helper(num,step);
        }else{
            num -=1;
            step++;
            return helper(num,step);
        }
    }
}