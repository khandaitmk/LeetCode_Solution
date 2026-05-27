class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character , Integer> hm = new HashMap<>();
        HashMap<Character , Integer> hm1 = new HashMap<>();

        char[] ch = word.toCharArray();
        int count = 0;
        int n = word.length();
        for(int i = 0;i < n ;i++){
            char c = ch[i];
            if(c+0 >= 97 && c+0 < 123) {
                hm.put(c, i );
            }
        }
        for(int i = 0;i < n ;i++){
            char c = ch[i];

            if((c+0 >= 65 && c+0 < 91) ){
                if(hm.containsKey((char)(c+32))){
                    int pos = hm.get((char)(c+32));
                    if(pos > i){
                        hm.remove((char)(c+32));
                    }
                    if(pos < i && !hm1.containsKey(c)){
                        hm1.put(c,i);
                        count++;
                    }
                }
            }
        }
        return count ;
    
    }
}