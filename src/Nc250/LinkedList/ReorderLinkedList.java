package Nc250.LinkedList;

public class ReorderLinkedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        reorderList(l1);
    }

    /* Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public static void reorderList(ListNode head) {

        // Step 1: Use slow and fast pointers to find the middle of the list
        ListNode slowPointer = head, fastPointer = head;

        // Move fast by 2 and slow by 1 until fast reaches the end
        // This will position slowPointer at the midpoint of the list
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // Step 2: Reverse the second half of the list
        // Disconnect the first half from the second half
        ListNode splittingNode = slowPointer.next;
        slowPointer.next = null;

        // Standard linked list reversal logic
        ListNode previous = null;
        ListNode current = splittingNode;
        while (current != null) {
            ListNode temp = current.next;  // store next node
            current.next = previous;       // reverse current node's pointer
            previous = current;            // move previous one step forward
            current = temp;                // move current one step forward
        }

        // At this point:
        // - 'head' points to start of the first half
        // - 'previous' points to start of the reversed second half

        // Step 3: Merge both halves alternately
        ListNode first = head, second = previous;
        while (second != null) {
            // Save next nodes before re-linking
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // Link one node from the first half, then one from the second
            first.next = second;
            second.next = temp1;

            // Move both pointers forward
            first = temp1;
            second = temp2;
        }

        // The list is now reordered in-place with O(1) extra space
    }

}
