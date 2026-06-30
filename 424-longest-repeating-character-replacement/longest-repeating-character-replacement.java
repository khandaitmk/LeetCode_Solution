class Solution {
    public int characterReplacement(String s, int k) {
     int n = s.length();
        HashMap<Character , Integer> hm = new HashMap<>();
        int start = 0;
        int end = 0;
        int res = 0;
        while(end < n){
            hm.put(s.charAt(end) , hm.getOrDefault(s.charAt(end) , 0)+1);
            int maxFreq = helper(hm);
            if((end-start+1) - maxFreq <= k){
                res = Math.max(res , (end-start+1));
                end++;
            }else{
                hm.put(s.charAt(start) , hm.get(s.charAt(start))-1);
                if(hm.get(s.charAt(start)) == 0){
                    hm.remove(s.charAt(start));
                }
                start++;
                end++;
            }
        }
        return res;
    }
    public static int helper(HashMap<Character , Integer> hm){
        int min = Integer.MIN_VALUE;
        for(char ch : hm.keySet()){
            min = Math.max(min , hm.get(ch));
        }
        return min;
    }
}