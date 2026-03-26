class Solution {
     static class TrieNode{
        TrieNode [] children = new TrieNode[10];
        boolean eow = false;
        TrieNode(){
            Arrays.fill(children,null);
        }
    }
    static class Trie{
        TrieNode root = new TrieNode();

        void insert(int num){
            TrieNode curr = root;
            String s = String.valueOf(num);
            for(char ch : s.toCharArray()){
                int idx = ch -'0';
                if(curr.children[idx] == null){
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.eow = true;
        }
        List<Integer> retrive(TrieNode curr){
            List<Integer> res = new ArrayList<>();
            dfs(curr, 0, res);
            return res;
        }
        void dfs(TrieNode node, int num, List<Integer> res){
            if(node.eow){
                res.add(num);
            }

            for(int i = 0; i < 10; i++){
                if(node.children[i] != null){
                    dfs(node.children[i], num * 10 + i, res);
                }
            }
        }

    }
    public List<Integer> lexicalOrder(int n) {
        Trie t = new Trie();
        for(int i=1;i<=n;i++){
            t.insert(i);
        }
        return t.retrive(t.root);
    }
}