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
    public ListNode mergeKLists(ListNode[] lists) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // int n = lists.length;
        // for(int i=0;i<n;i++){
        //     ListNode temp = lists[i];
        //     while (temp != null){
        //         pq.add(temp.val);
        //         temp = temp.next;
        //     }
        // }
        // if(pq.isEmpty()) return null;
        // ListNode res = new ListNode(pq.remove());
        // ListNode result = res;

        // while(!pq.isEmpty()){
        //     res.next = new ListNode(pq.remove());
        //     res = res.next;
        // }
        // return result;

        // optimized // O(k log k)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int n = lists.length;
        // Add only the HEAD of each list
        for (ListNode node : lists) {
            if (node != null) pq.add(node);  
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode smallest = pq.remove();   
            curr.next = smallest;              
            curr = curr.next;

            if (smallest.next != null) {
                pq.add(smallest.next);         
            }
        }

        return dummy.next;
    }
}