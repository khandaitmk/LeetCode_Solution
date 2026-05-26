class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character , Integer> hm = new HashMap<>();
        char[] ch = word.toCharArray();
        for(char c : ch){
            hm.put(c, hm.getOrDefault(c , 0)+1);
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(hm.containsKey((char)('a'+i)) && hm.containsKey((char)('A'+i))){
                count++;
            }
        }
        return count ;
    }
}