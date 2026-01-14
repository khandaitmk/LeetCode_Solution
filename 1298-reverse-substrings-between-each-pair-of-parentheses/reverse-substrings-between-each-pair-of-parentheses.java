class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> ch = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                StringBuilder temp = new StringBuilder();
                while(ch.peekLast() != '('){
                   temp.append(ch.removeLast());
                }
                ch.removeLast();
                for(int k=0;k<temp.length();k++){
                    ch.addLast(temp.charAt(k));
                }
            }else{
                ch.add(s.charAt(i));
            }
        }
        StringBuilder str = new StringBuilder();
        while (!ch.isEmpty()){
            str.append(ch.removeFirst());
        }
        return str.toString();

    }
    
}