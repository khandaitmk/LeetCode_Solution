class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(int i = 0 ;i<strs.length;i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            
            if(!hm.containsKey(sorted)){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hm.put(sorted , list);
            }else{
                List<String> l = hm.get(sorted);
                l.add(strs[i]);
                hm.put(sorted,l);
            }
        }
        for(String key : hm.keySet()){
            res.add(hm.get(key));
        }
        return res;
    }
}