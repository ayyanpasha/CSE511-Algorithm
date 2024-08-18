import java.util.*;

public class P_12_Reverse_LinkedList_Iterative {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(0);
        Node temp = head;
        for(int i=1;i<=10;i++){
            temp.next = new Node(i);
            temp = temp.next;
        }
        System.out.println("Before reversing");
        print(head);
        head = reverseLinkedList(head);
        System.out.println("After reversing");
        print(head);
    }
    public static Node reverseLinkedList(Node head){
        Node prev = null;
        while(head != null){
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public static void print(Node head){
        while(head != null) {
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println("");
    }
}