package Nc250.LinkedList;

public class ReverseLinkedListII {

    public static void main(String[] args) {

    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        /*ListNode prevLeft = null, nextRight = null, rightCurr = head, leftCurr = head;
        int index = 1;

        while (index < left) {
            prevLeft = leftCurr;
            leftCurr = leftCurr.next;

            index++;
        }

        rightCurr = leftCurr;

        while (index < right) {
            rightCurr = rightCurr.next;
            index++;
        }

        nextRight = rightCurr.next;

        if (prevLeft != null) {
            prevLeft.next = null;
        }
        rightCurr.next = null;

        ListNode reversedListHead = reverseLinkedList(leftCurr);
        ListNode reversedListTail = leftCurr;

        if (prevLeft != null) {
            prevLeft.next = reversedListHead;
        }
        reversedListTail.next = nextRight;

        return left == 1 ? reversedListHead : head;*/

        // Edge case: if the list has only one node or no reversal is needed
        if (head == null || left == right) return head;

        // Dummy node helps handle edge cases where left == 1
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // Step 1: Move `prevLeft` to the node just before the reversal section
        ListNode prevLeft = dummy;
        for (int i = 1; i < left; i++) {
            prevLeft = prevLeft.next;
        }

        // Step 2: `leftCurr` is the first node of the section to reverse
        ListNode leftCurr = prevLeft.next;
        ListNode rightCurr = leftCurr;

        // Step 3: Move `rightCurr` to the end of the section to reverse
        for (int i = left; i < right; i++) {
            rightCurr = rightCurr.next;
        }

        // Step 4: Keep reference to the node after the reversed section
        ListNode nextRight = rightCurr.next;

        // Step 5: Temporarily detach the right portion
        rightCurr.next = null;

        // Step 6: Reverse the sublist [left, right]
        ListNode reversedListHead = reverseLinkedList(leftCurr);

        // Step 7: Reconnect the reversed portion
        prevLeft.next = reversedListHead;
        leftCurr.next = nextRight; // leftCurr is now the tail after reversal

        /*
         * Note: We do NOT detach the left portion (prevLeft.next = null)
         * because the dummy node already ensures safe reconnection.
         * The dummy acts as a stable anchor before 'left',
         * so we can reverse the middle segment without breaking the rest
         * of the list or losing reference to the head.
         */

        // Step 8: Return the new head (dummy.next accounts for left == 1 case)
        return dummy.next;
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;
    }
}
