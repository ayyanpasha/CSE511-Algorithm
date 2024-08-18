//GFG problem link: https://www.geeksforgeeks.org/problems/detect-loop-in-linked-list/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card


class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        // Add code here
        if(head == null || head.next == null) return false;
        Node slow = head;
        Node fast = head;
        do{
            slow = slow.next;
            fast = fast.next.next;
        }while(fast != null && fast.next != null && slow != fast);
        return slow == fast;
    }
}