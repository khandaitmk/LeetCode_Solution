class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans=new StringBuilder();
        int n=s.length();
        if(n==0){
            return s;
        }
        int i=1;
        char ch=s.charAt(0);
        ans.append(ch);
        int count=1;
        while(i<n){
            if(ch==s.charAt(i)){
                count++;
                if(count<3){
        ans.append(ch);
                    i++;
                }
                else{
                    i++;
                }
            }
            else{
                ch=s.charAt(i);
        ans.append(ch);
                i++;
                count=1;
            }
        }
        return ans.toString();
    }
}