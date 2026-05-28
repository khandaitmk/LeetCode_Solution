class Solution {
        static class Node{
        Node[] children = new Node[26];
        Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
        int  index =-1;
        int maxLength = Integer.MAX_VALUE;
    }
    static class Trie{
        Node root = new Node();
        void insert(String str , int index){
            // as we are implementing for suffix we reverse string before  insertion
            Node curr = root;
            if(str.length() < root.maxLength || (str.length() == root.maxLength && index < root.index)){
                root.maxLength = str.length();
                root.index = index;
            }
            char[] ch = str.toCharArray();
            int start = 0;
            int end = ch.length-1;
            while(start < end){
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
            for(int i=0;i<ch.length;i++){
                int idx =ch[i] - 'a';
                if(curr.children[idx] == null){
                    curr.children[idx] = new Node();
                }

                curr = curr.children[idx];
                if(str.length() < curr.maxLength || (str.length() == curr.maxLength && index < curr.index)){
                    curr.maxLength = str.length();
                    curr.index = index;
                }
            }

        }
        int search(String str){
            Node curr = root;
            int count = 0;
            char[] ch = str.toCharArray();
            int start = 0;
            int end = ch.length-1;
            while(start < end){
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
            for(int i=0;i<ch.length;i++){
                int idx = ch[i] - 'a';
                if(curr.children[idx] == null){
                    break;
                }
                curr = curr.children[idx];
            }
            return curr.index;
        }
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsQuery.length;
        int[] res = new int[n];
        Trie t = new Trie();
        for(int i=0;i<wordsContainer.length;i++){
            t.insert(wordsContainer[i] , i);
        }
        for(int i = 0;i<wordsQuery.length;i++){
            res[i] = t.search(wordsQuery[i]);
        }

        return res;
    }
}