class Solution {
    public boolean isValid(String s) {
        // String str = "()()()({{}})";
        Stack<Character> sc = new Stack<>();
//        char[] opening = {'(','[','{'};
        ArrayList<Character> opening = new ArrayList<>();
        opening.add('(');
        opening.add('{');
        opening.add('[');
        for(int i=0;i<s.length();i++){
            if(opening.contains(s.charAt(i))){
                sc.push(s.charAt(i));
            } else{
                if(sc.isEmpty()){
                    return false;
                }
                char top = sc.peek();
                if((top == '(' && s.charAt(i) == ')') ||
                        (top == '{' && s.charAt(i) == '}') ||
                        (top == '[' && s.charAt(i) == ']')){
                    sc.pop();
                }else{
                    return false;
                }
            }
        }
        if(sc.isEmpty()){
            return true;
        }
        return false;
    }
}