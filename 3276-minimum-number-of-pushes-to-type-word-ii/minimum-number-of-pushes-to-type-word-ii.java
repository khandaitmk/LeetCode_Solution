class Solution {
    static class Info implements Comparable<Info>{
        char ch;
        int freq = 0;
        public Info(char c , int freq){
            this.ch = c;
            this.freq = freq;
        }
        public int compareTo(Info i){
            return i.freq - this.freq;
        }
    }
    public int minimumPushes(String word) {
        int n = word.length();
        HashMap<Character , Integer> hm = new HashMap<>();
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            hm.put(word.charAt(i) , hm.getOrDefault(word.charAt(i) , 0)+1);
        }
        for(char ch : hm.keySet()){
            pq.add(new Info(ch , hm.get(ch)));
        }
        int threshold = 8;
        int res = 0;
        int tempCount = 0;
        int w = 1;
        while(!pq.isEmpty()){
            if(tempCount == threshold){
                threshold += 8;
                w++;
            }
            Info temp = pq.remove();
            res += temp.freq * w;
            tempCount++;
        }
        return res;
    }
}