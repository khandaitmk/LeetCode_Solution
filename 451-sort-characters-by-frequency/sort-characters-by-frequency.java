class Solution {
    static class Info implements Comparable<Info>{
        char c;
        int count;
        Info(char c , int count ){
            this.c = c;
            this.count = count;
        }
        public int compareTo(Info i){
            return i.count - this.count;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character , Integer> hm = new HashMap<>();
        PriorityQueue<Info> pq = new PriorityQueue<>();
        StringBuilder str = new StringBuilder();
        char [] ch = s.toCharArray();
        for( char c : ch){
            hm.put(c , hm.getOrDefault(c,0)+1);
        }
        for(char c : hm.keySet()){
            pq.add(new Info(c , hm.get(c)));
        }
        while(!pq.isEmpty()){
            Info i = pq.poll();
            int count = i.count;
            char c = i.c;
            while(count != 0){
                str.append(c);
                count--;
            }
        }

        return str.toString();
    }
}