class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int left = 0;
        int right = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        while(right != n){
            if(s.charAt(right) == 'a'){
                a++;
            } else if (s.charAt(right) == 'b') {
                b++;
            }else {
                c++;
            }
            while(a>0 && b>0 && c>0){
                count += (n-(right));
                if(s.charAt(left) == 'a'){
                    a--;
                } else if (s.charAt(left) == 'b') {
                    b--;
                }else {
                    c--;
                }
                left++;
            }
            right++;

        }
        return count;
    }
}