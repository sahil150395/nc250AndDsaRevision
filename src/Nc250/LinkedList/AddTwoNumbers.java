package Nc250.LinkedList;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode L1l1 = new ListNode(1);
        ListNode L1l2 = new ListNode(2);
        ListNode L1l3 = new ListNode(3);
        L1l1.next = L1l2;
        L1l2.next = L1l3;


        ListNode L2l1 = new ListNode(4);
        ListNode L2l2 = new ListNode(5);
        ListNode L2l3 = new ListNode(6);
        L2l1.next = L2l2;
        L2l2.next = L2l3;

        addTwoNumbers(L1l1, L2l1);
    }

    /*
     * Time complexity: O(m+n) - m and n are lengths of l1 and l2
     * Space complexity: O(1), O(max(m,n)) for the output list.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Edge cases: if one list is just [0], return the other list directly
        if (l1.val == 0 && l1.next == null) return l2;
        if (l2.val == 0 && l2.next == null) return l1;

        // Variable to keep track of carry from previous digit sum
        int carryOver = 0;

        // Dummy node simplifies handling of the result list's head
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists until both are fully processed
        while (l1 != null || l2 != null) {
            // Extract the digit value from each list; use 0 if one list is shorter
            int l1digit = (l1 == null) ? 0 : l1.val;
            int l2digit = (l2 == null) ? 0 : l2.val;

            // Add the two digits and the carry from the previous iteration
            int sum = l1digit + l2digit + carryOver;

            // Create a new node with the last digit of the sum
            current.next = new ListNode(sum % 10);

            // Update carryOver for the next iteration
            carryOver = sum / 10;

        /*
        The above two lines replace the longer version:
        if (sum >= 10) {
            int digit = sum % 10;
            carryOver = sum / 10;
            current.next = new ListNode(digit);
        } else {
            current.next = new ListNode(sum);
            carryOver = 0;
        }
        */

            // Move to the next nodes in the lists
            current = current.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        // If there's still a carry remaining after both lists end, add it as a new node
        if (carryOver > 0) {
            current.next = new ListNode(carryOver);
        }

        // Return the result starting from the next of dummy (skip placeholder node)
        return dummy.next;
    }

}
