class Solution {
        static class Node{
        Node[] children = new Node[26];
        boolean endOfWord ;
        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }
    static class Trie{
        Node root = new Node();

        public void insert(String str){
            Node curr = root;
            for(int i=0;i<str.length();i++){
                int idx = str.charAt(i)-'a';
                if(curr.children[idx] == null){
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
            curr.endOfWord = true;
        }

        public boolean search(String str){
            Node curr = root;
            for(int i = 0;i<str.length();i++){
                int idx = str.charAt(i) - 'a';
                if(curr.children[idx] == null){
                    return false;
                }
                curr = curr.children[idx];
            }
            return true;
        }
        public String ans = "";
        public void longestWord(Node node , StringBuilder temp){
            if(node == null) return;
            for(int i=0;i<26;i++){
                if(node.children[i] != null && node.children[i].endOfWord == true){
                    char ch = (char)( i+'a');
                    temp.append(ch);
                    if(temp.length() > ans.length()){
                        ans = temp.toString();
                    }
                    longestWord(node.children[i] , temp);
                    temp.deleteCharAt(temp.length()-1);
                }
            }
        }
    }
    public String longestWord(String[] words) {
        Trie t = new Trie();
        for(int i=0;i<words.length;i++){
            t.insert(words[i]);
        }
        t.longestWord(t.root ,new StringBuilder());
        return (t.ans);
    }
}