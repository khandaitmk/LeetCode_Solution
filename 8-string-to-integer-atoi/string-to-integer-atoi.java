class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        char[] ch = s.toCharArray();
        StringBuilder str = new StringBuilder();
        int i = 0;
        int sign = 1;
        if (ch[i] == '+' || ch[i] == '-') {
            if (ch[i] == '-') sign = -1;
            i++;
        }

        while(i < ch.length){
            if(Character.isDigit(ch[i])){
                str.append(ch[i]);
                i++;
            }else{
                break;
            }
        }
        if(str.isEmpty()){
            return 0;
        }
        char[] r = str.toString().toCharArray();
        long result = 0;
        for(char cc : r){
            int temp = cc - '0';
            result = result*10+temp;
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && result > (long)Integer.MAX_VALUE + 1) {
                return Integer.MIN_VALUE;
            }
        }

        return (int)result * sign;
    }
}