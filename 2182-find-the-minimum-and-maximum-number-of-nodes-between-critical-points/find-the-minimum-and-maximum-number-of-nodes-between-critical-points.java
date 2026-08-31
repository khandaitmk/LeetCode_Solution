/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head;
        int prev = -1;
        int pos = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while(temp != null && temp.next != null){
            if(prev == -1){
                prev = temp.val;
                pos++;
                temp = temp.next;
                continue;
            }else{
                if( prev < temp.val && temp.val > temp.next.val){
                    list.add(pos);
                }else if(prev > temp.val && temp.val < temp.next.val){
                    list.add(pos);
                }
            }
            prev = temp.val;
            temp = temp.next;
            pos++;
        }
        if(list.size() < 2){
            return new int[]{-1,-1};
        }
        int max = list.get(list.size()-1) - list.get(0);

    // min → always between consecutive critical points
    int min = Integer.MAX_VALUE;
    for(int i = 1; i < list.size(); i++){
        min = Math.min(min, list.get(i) - list.get(i-1));
    }

        return new int[]{min , max};
    }
}