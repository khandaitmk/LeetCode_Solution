class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<n;i++){
            String word =words[i];
            char[] arr = word.toCharArray();
            int temp = 0;
            for(int j = 0 ;j<arr.length;j++){
                int idx = arr[j] - 'a';
                temp += weights[idx];
            }
            int mod = temp % 26; 
           res.append((char)('z' - mod));
        }
        return res.toString();
    }
}