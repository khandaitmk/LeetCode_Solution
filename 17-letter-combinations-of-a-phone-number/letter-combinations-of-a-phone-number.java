class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        List<String> res = new ArrayList<>();
        char[] digit = digits.toCharArray();
        helper(hm,res,digits,new StringBuilder());
        return res;
    }
    public static void helper(HashMap<Character,String> hm , List<String> res, String digits ,StringBuilder temp){
        if(digits.length() == 0){
            res.add(temp.toString());
            return;
        }
        char ch = digits.charAt(0);
        String str = hm.get(ch);
        for(int i=0;i<str.length();i++){
            temp.append(str.charAt(i));
            helper(hm,res,digits.substring(1),temp);
            temp.deleteCharAt(temp.length()-1);
        }

    }
}