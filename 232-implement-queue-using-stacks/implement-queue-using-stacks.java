class MyQueue {
    private Stack<Integer> first ;
    private Stack<Integer> second ;
    public MyQueue(){
         first = new Stack<>();
         second = new Stack<>();
     }
    public void push(int x) {
        if(first.isEmpty()){
                first.push(x);
                return;
            }
            while(!first.isEmpty()){
                second.push(first.pop());
            }
            first.push(x);
            while(!second.isEmpty()){
                first.push(second.pop());
            }
    }

    public int pop()  {
        // if(first.isEmpty()){
        //         throw new Exception("Queue is empty");
        // }
            return first.pop();
    }

    public int peek() {
    //    if(first.isEmpty()){
    //             throw new Exception("Queue is empty");
    //         }
            return first.peek();
    }

    public boolean empty() {
        return first.isEmpty() && second.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */