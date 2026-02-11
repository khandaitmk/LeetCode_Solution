class Solution {
    public String addBinary(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        int i = l1-1;
        int j = l2-1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0 || carry != 0){
            int b1 = (i>=0) ?a.charAt(i) - '0':0;
            int b2 = (j>=0) ?b.charAt(j) - '0':0;
            int sum = b1 ^ b2 ^ carry;
            carry = (b1 & b2) | (b1 & carry) | (carry & b2);
            res.append(sum);
            i--;
            j--;

        }
        return res.reverse().toString();
    }
}