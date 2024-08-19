//gfg link: https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

class Solution {
    public static void removeLoop(Node head) {
        // code here
        if(head == null || head.next == null) return;
        Node slow = head;
        Node fast = head;
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(fast != null && fast.next != null && slow != fast);
        if(slow != fast) return;
        slow = head;
        if(slow != fast){
            while(slow.next != fast.next){
                slow = slow.next;
                fast = fast.next;
            }
        }else{
            while(fast.next != slow) fast = fast.next;
        }
        fast.next = null;
    }
}