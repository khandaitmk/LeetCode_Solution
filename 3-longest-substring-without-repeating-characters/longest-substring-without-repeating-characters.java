class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int start = 0;
        int tempRes = 0;
        int res = 0;
        HashMap<Character , Integer> hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i] , 0)+1);
            tempRes++;
            while(hm.get(arr[i]) > 1){
                char val = arr[start];
                hm.put(val,hm.get(val)-1);
                if(hm.get(val) == 0){
                    hm.remove(val);
                }
                start++;
                tempRes--;
            }
            res = Math.max(res,tempRes);
        }
        return res;
    }
}