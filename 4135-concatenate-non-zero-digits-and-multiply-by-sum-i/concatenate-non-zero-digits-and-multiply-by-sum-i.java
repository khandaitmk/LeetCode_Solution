class Solution {
    public long sumAndMultiply(int n) {
        int temp = n;
        int sum = 0;
        Stack<Integer> s = new Stack<>();
        while(temp != 0){
            int rem = temp % 10;
            sum += rem;
            if(rem != 0){
                s.push(rem);
            }
            temp /= 10;
        }
        int num = 0;
        while(!s.isEmpty()){
            int t = s.pop();
            num = num * 10 + t;
        }
        return (long)num * sum;
    }
}