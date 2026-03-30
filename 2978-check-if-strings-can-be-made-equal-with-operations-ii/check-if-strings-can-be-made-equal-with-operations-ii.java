class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        StringBuilder even1 = new StringBuilder();
        StringBuilder even2 = new StringBuilder();

        StringBuilder odd1 = new StringBuilder();
        StringBuilder odd2 = new StringBuilder();

        for(int i=0;i<n;i++){
            if(i % 2 == 0){
                even1.append(s1.charAt(i));
                even2.append(s2.charAt(i));
            }else{
                odd1.append(s1.charAt(i));
                odd2.append(s2.charAt(i));
            }
        }
        char[] e1 = even1.toString().toCharArray();
        Arrays.sort(e1);
        char[] e2 = even2.toString().toCharArray();
        Arrays.sort(e2);
        char[] o1 = odd1.toString().toCharArray();
        Arrays.sort(o1);
        char[] o2 = odd2.toString().toCharArray();
        Arrays.sort(o2);
        if(Arrays.equals(e1,e2) && Arrays.equals(o1,o2)){
            return true;
        }
        return false;

    }
}