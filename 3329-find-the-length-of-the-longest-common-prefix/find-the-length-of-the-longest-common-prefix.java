class Solution {
        static class Node{
        Node[] children = new Node[10];
        boolean endOfWord = false;
        Node(){
            for(int i=0;i<10;i++){
                children[i] = null;
            }
        }
    }
    static class Trie{
        Node root = new Node();
        public void insert(int num){
            Node curr = root;
            Stack<Integer> ss = new Stack<>();
            while(num > 0){
                int n = num % 10;
                ss.push(n);
                num /=10;
            }
            while(!ss.isEmpty()){
                int idx = ss.pop();
                if(curr.children[idx] == null){
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
            curr.endOfWord = true;
        }
        public int match(int num){
            Node curr = root;
            Stack<Integer> ss = new Stack<>();
            while(num > 0){
                int n = num % 10;
                ss.push(n);
                num /=10;
            }
            int count = 0;
            while(!ss.isEmpty()){
                int idx = ss.pop();
                if(curr.children[idx] == null){
                    return count;
                }
                count++;
                curr = curr.children[idx];
            }
            return count ;
        }
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
                Trie t = new Trie();
        int res = 0;
        for(int i=0;i<arr1.length;i++){
            t.insert(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            res = Math.max(res , t.match(arr2[i]));
        }
        return res;
    }
}