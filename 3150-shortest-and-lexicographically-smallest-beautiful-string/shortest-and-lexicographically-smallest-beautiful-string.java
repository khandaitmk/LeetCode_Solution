class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String res = "";
        int n = s.length();
        int left = 0;
        int count = 0;

        for(int right = 0; right < n ; right++){
            if(s.charAt(right) == '1'){
                count++;
            }

            while(count > k || (left <= right && s.charAt(left) == '0')){
                if(s.charAt(left) == '1'){
                    count--;
                }
                left++;
            }

            if(count == k ){
                String curr = s.substring(left , right + 1);
                if(res.isEmpty() ||
                        curr.length() < res.length() ||
                        (curr.length() == res.length() && curr.compareTo(res) < 0)){
                    res = curr;
                }
            }
        }
        return res;
    }
}