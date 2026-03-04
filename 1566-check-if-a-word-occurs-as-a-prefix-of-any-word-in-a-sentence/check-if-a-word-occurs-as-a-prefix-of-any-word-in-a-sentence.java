class Solution {
    static class Node{
        Node[] children = new Node[26];
        boolean endOfWord ;
        int index = -1;
        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }
    static class Trie{
        Node root = new Node();
        public void insert(String word,int index){
            Node curr = root;
            for(int i=0;i<word.length();i++){
                int idx = word.charAt(i)-'a';
                if(curr.children[idx] == null){
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
            if(curr.index == -1){
                curr.index = index;
            }
            curr.endOfWord = true;
        }
        public boolean search(String word){
            Node curr = root;
            for(int i=0;i<word.length();i++){
                int idx = word.charAt(i)-'a';
                if(curr.children[idx] == null){
                    return false;
                }
                curr = curr.children[idx];
            }

            return curr.endOfWord == true;
        }
        public int searchCustomized(String word){
            Node curr = root;
            for(int i=0;i<word.length();i++){
                int idx = word.charAt(i)-'a';
                if(curr.children[idx] == null){
                    return -1;
                }
                curr = curr.children[idx];
            }
            int index = findIndex(curr);
            return index;
        }
        public static int findIndex(Node curr){
            if(curr == null){
                return -1;
            } else if (curr.endOfWord == true) {
                return curr.index;
            }
            int res = Integer.MAX_VALUE;
            for(int i = 0; i < 26; i++){
                if(curr.children[i] != null){
                    res = Math.min(res, findIndex(curr.children[i]));
                }
            }
            return res == Integer.MAX_VALUE ?-1:res;
        }

    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        // String[] arr = sentence.split(" ");
        // for(int i=0;i< arr.length;i++){
        //     if(arr[i].startsWith(searchWord)){
        //         return i+1;
        //     }
        // }
        // return -1;
        Trie t = new Trie();
        String[] arr = sentence.split(" ");
        for(int i=0;i< arr.length;i++){
            t.insert(arr[i],i+1);
        }
        int temp = t.searchCustomized(searchWord);
        return temp;
    }
}