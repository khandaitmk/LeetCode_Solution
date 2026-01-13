class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        Queue<Integer> q = new LinkedList<>();
//        int index =str.charAt(2) - 'a';
//        System.out.println(index);
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            int index =current - 'a';
            freq[index] = freq[index]+1;
            if(freq[index]<2){
                q.add(i);
            }else {
                continue;
            }
        }
        while(!q.isEmpty()){
            int index = q.peek();
            int freqIndex = s.charAt(index) - 'a';
            if(freq[freqIndex]>1){
                q.remove();
                continue;
            }
            return q.peek();
        }
        return -1;
    }
}