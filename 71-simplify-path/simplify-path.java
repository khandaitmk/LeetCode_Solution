class Solution {
    public String simplifyPath(String path) {
        path = path.replaceAll("/+", "/");
        String[] temp = path.split("/");
        Stack<String> s = new Stack<>();
        for(String ss : temp){
            if(ss.equals("..")){
                if(s.isEmpty()) continue;
                s.pop();
                continue;
            }
            if(ss.equals(".")) continue;
            s.push(ss);
        }
        int sSize = s.size();
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<sSize;i++){

            String tempString = s.pop();
            if(tempString.isEmpty() || tempString.equals(".")) continue;
            if(tempString.equals("..")){
                if(s.isEmpty()) continue;
                s.pop();
                i++;
                continue;
            }
            res.insert(0, "/" + tempString);
        }
        if (res.isEmpty()) return "/";
        return (res.toString());
    }
}