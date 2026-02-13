class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        int n = operations.length;
        for(int i=0 ;i < n ;i++){
            if(operations[i].equals("C")){
                s.pop();
            } else if (operations[i].equals("D")) {
                int t1 = s.peek();
                s.push(t1*2);

            } else if (operations[i].equals("+")) {
                int t1 = s.pop();
                int t2 = s.pop();
                s.push(t2);
                s.push(t1);
                s.push(t1 + t2);
            }else {
                s.push(Integer.parseInt(operations[i]));
            }
        }
        int sum = 0;
        while(!s.isEmpty()){
            sum += s.pop();
        }
        return sum;
    }
}