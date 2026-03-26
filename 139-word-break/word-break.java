class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        // INSERT
        void insert(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                int idx = c - 'a';
                if(curr.children[idx] == null){
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.isEnd = true;
        }

        // SEARCH complete word
        boolean search(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                int idx = c - 'a';
                if(curr.children[idx] == null) return false;
                curr = curr.children[idx];
            }
            return curr.isEnd;
        }

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie t = new Trie();
        for(String str : wordDict){
            t.insert(str);
        }
        Boolean[] dp = new Boolean[s.length()];
        return helper(s,0,t,dp);
    }
    public static boolean helper(String str,int start,Trie t,Boolean[] dp){
        if(start == str.length()) return true;
        if(dp[start] != null) return dp[start];
        for(int i=start+1;i<=str.length();i++){
            boolean t1 = t.search(str.substring(start,i));
            boolean t2 = helper(str,i,t,dp);
            if(t1 && t2){
                dp[start] = true;
                return dp[start];
            } 

        }
        dp[start] = false;
        return dp[start];
    }
}