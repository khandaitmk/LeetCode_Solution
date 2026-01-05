class Solution {
    public static String countAndSay(int n) {
        String base = "1";

        for(int i=1;i<n;i++){
            int count = 1;
            StringBuilder str = new StringBuilder();
            for(int j = 1 ; j<base.length();j++ ){
                if(base.charAt(j) == base.charAt(j-1)){
                    count++;
                } else{
                    str.append(count);
                    str.append(base.charAt(j-1));
                    count = 1;

                }
            }
            str.append(count);
            str.append(base.charAt(base.length()-1));
            base = str.toString();
        }
        return base;
    }
}