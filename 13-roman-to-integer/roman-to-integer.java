class Solution {
    public int romanToInt(String s) {
        HashMap<Character , Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

        int sum = 0;
        int i=0;
        while(i<s.length()){
            if(i<s.length()-1){
                if(hm.get(s.charAt(i))<hm.get(s.charAt(i+1))){
                    int t1 = hm.get(s.charAt(i));
                    int t2 = hm.get(s.charAt(i+1));
                    sum += t2-t1;
                    i += 2;
                }else{
                    sum += hm.get(s.charAt(i));
                    i += 1;
                }
            }else{
                    sum += hm.get(s.charAt(i));
                    i += 1;
            }     
        }
        return sum;
        
    }
}