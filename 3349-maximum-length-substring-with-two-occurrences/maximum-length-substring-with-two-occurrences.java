class Solution {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int res = 0;
        HashMap<Character , Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch , hm.getOrDefault(ch , 0) + 1);
            while(hm.get(ch) > 2 ){
                char c = s.charAt(left);
                hm.put(c , hm.get(c) - 1);
                if(hm.get(c) == 0){
                    hm.remove(c);
                }
                left++;
            }
        res = Math.max(res , i-left+1);

        }
        return res;
    }
}