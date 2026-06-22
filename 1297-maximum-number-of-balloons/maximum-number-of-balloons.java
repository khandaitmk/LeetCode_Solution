class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character , Integer> hm = new HashMap<>();
        String base = "balloon";
        for(int i=0;i<base.length();i++){
            hm.put(base.charAt(i) , 0);
        }
        for(int i = 0;i<text.length();i++){
            if(hm.containsKey(text.charAt(i))){
                hm.put(text.charAt(i) , hm.get(text.charAt(i))+1);
            }
        }
        int min = Integer.MAX_VALUE;
        for(char ch : hm.keySet()){
            if(ch == 'l' ||  ch == 'o'){
                int temp = hm.get(ch);
                min = Math.min(min , temp/2);
            }else{
                int temp = hm.get(ch);
                min = Math.min(min , temp);
            }
        }
        return min;
    }
}