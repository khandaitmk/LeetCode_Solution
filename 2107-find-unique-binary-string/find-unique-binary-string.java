class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        HashSet<String> hs = new HashSet<>();
        StringBuilder str = new StringBuilder("");
        getAllCombination(n,hs,str);
        for(String s :nums){
            hs.remove(s);
        }
        if(hs.isEmpty()) return "";
        return hs.iterator().next();
    }
    public static void getAllCombination(int n , HashSet<String> hs,StringBuilder str){
        if(n == 0){
            hs.add(str.toString());
            return;
        }
        str.append("0");
        getAllCombination(n-1,hs,str);
        str.deleteCharAt(str.length()-1);

        str.append("1");
        getAllCombination(n-1,hs,str);
        str.deleteCharAt(str.length()-1);
    }
}