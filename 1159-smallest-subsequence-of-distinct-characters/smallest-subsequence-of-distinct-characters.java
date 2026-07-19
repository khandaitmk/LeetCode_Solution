class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++){
            int idx = s.charAt(i) - 'a';
            freq[idx]++;
        }
        boolean[] visited = new boolean[26];
        Stack<Character> ss = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if(visited[ch - 'a']){
                continue;
            }
            while(!ss.isEmpty() && (ch-'a') < (ss.peek() - 'a') && freq[ss.peek() - 'a']>0){
                visited[ss.peek() - 'a'] = false;
                ss.pop();
            }
            
            ss.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        while(!ss.isEmpty()){
            res.insert(0 , ss.pop());
        }
        return res.toString();
    }
}