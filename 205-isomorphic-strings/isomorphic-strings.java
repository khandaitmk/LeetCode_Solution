class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character , Character> hm = new HashMap<>();
        HashMap<Character , Character> hm2 = new HashMap<>();
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        for(int i = 0;i<s.length();i++){
            if(!hm.containsKey(c1[i]) && !hm2.containsKey(c2[i])){
                hm.put(c1[i] , c2[i]);
                hm2.put(c2[i] , c1[i]);
            }else{
                if((hm.containsKey(c1[i]))){
                    if(hm.get(c1[i]) != c2[i] ){
                    return false;
                }
                }
                
                if(hm2.containsKey(c2[i])){
                    if(hm2.get(c2[i]) != c1[i] ){
                    return false;
                }
                }
            }
        }
        return true;
    }
}