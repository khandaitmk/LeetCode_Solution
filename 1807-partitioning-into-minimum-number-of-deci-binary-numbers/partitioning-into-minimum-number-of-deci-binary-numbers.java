class Solution {
    public int minPartitions(String n) {
        PriorityQueue<Character> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<n.length();i++){
            pq.add(n.charAt(i));
        }
        return  pq.remove() - '0';
    }
}