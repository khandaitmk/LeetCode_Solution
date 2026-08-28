class Solution {
    public static String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int half = n / 2;
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            int idx = ch - 'a';
            freq[idx]++;
        }
        int oddCount = 0;
    for (int f : freq) {
        if (f % 2 != 0) oddCount++;
    }
    if (oddCount > 1) {
        return "";
    }
//        freq available for the left half
        int[] halfFreq = new int[26];
        for(int i = 0;i<26;i++){
            halfFreq[i] = freq[i]/2;
        }
//        now we have to find the middle character for the odd length
        char midChar = 0;
        if(n % 2 == 1){
            for(int i=0;i<26;i++){
                if(freq[i] % 2 == 1){
                    midChar = (char)('a' + i);
                    break;
                }
            }
        }
        char[] left  = new char[half];
//        now we will try to build the left half
        return helper(left , 0 , halfFreq , target , half , midChar , freq , n);
    }
    public static String helper(char[] left , int pos , int[] halfFreq , String target , int half  ,char midChar, int[] freq ,int n ){
        if(pos == half){
                String palindrome = buildPalindrome(left, midChar, n);
                if(palindrome.compareTo(target) > 0){
                return palindrome;
            }
        return "";

        }
        char targetChar = target.charAt(pos);

//        try each char from a to z for this position
        for(char c = 'a' ; c <= 'z' ; c++){
            if(halfFreq[c - 'a'] > 0){

                if(c < targetChar) continue; // as this will generate the lexicographycally smaller this is not our moto so skip it
                halfFreq[c - 'a']--;
                left[pos] = c;

                if(c > targetChar){
                    fillSmallest(left, pos + 1, halfFreq, half);

                    // build palindrome
                    String palindrome = buildPalindrome(left, midChar, n);

                    // restore freq for backtracking
                    for(int i = pos; i < half; i++){
                        halfFreq[left[i] - 'a']++;
                    }

                    return palindrome;

                }else{
//                    now c == target
                    String res = helper(left , pos +1 , halfFreq , target , half , midChar , freq , n);
                    halfFreq[c-'a']++;
                    if(!res.isEmpty()) return res;

                }
            }
        }
        return "";
    }
    public static void fillSmallest(char[] left , int start , int[] halfFreq , int half){
        int idx = start;
        for(int c = 0; c < 26 && idx < half; c++){
            while(halfFreq[c] > 0 && idx < half){
                left[idx++] = (char)('a' + c);
                halfFreq[c]--;
            }
        }
    }

    public static String buildPalindrome(char[] left , char midChar , int n){
        StringBuilder sb = new StringBuilder();
        for(char ch : left){
            sb.append(ch);
        }
        if(midChar != 0){
            sb.append(midChar);
        }
        for(int i = left.length - 1; i >= 0; i--) sb.append(left[i]);
        return sb.toString();
    }
}