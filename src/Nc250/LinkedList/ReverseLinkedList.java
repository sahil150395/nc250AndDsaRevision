package Nc250.LinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(reverseList(node1).getVal());

    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next; // store the next node of the current so that we dont loose track of it
            current.next = previous; // the next node of the current node should point to the previous node
            previous = current; // once we update the next node of the current node to previous it becomes the new previous
            current = temp; // and the next node of the old current is the new current
        }

        return previous;
    }

}