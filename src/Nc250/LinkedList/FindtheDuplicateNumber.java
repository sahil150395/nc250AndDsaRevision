package Nc250.LinkedList;

public class FindtheDuplicateNumber {

    public static void main(String[] args) {

        System.out.println(findDuplicate(new int[]{1, 2, 3, 2, 2}));
    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int findDuplicate(int[] nums) {
        // Initialize both pointers at the start of the array
        // Each element value can be treated as a "next index" — similar to a linked list
        int slowPointer = nums[0], fastPointer = nums[0];

        // Phase 1: Detect the cycle using Floyd’s Tortoise and Hare algorithm
        // Slow moves 1 step at a time, Fast moves 2 steps at a time
        while (true) {
            slowPointer = nums[slowPointer];           // Move by 1 step
            fastPointer = nums[nums[fastPointer]];     // Move by 2 steps

            // Optional debug logs (good for understanding traversal)
            System.out.println("Slow pointer is at index: " + slowPointer + ", Value: " + nums[slowPointer]);
            System.out.println("Fast pointer is at index: " + fastPointer + ", Value: " + nums[fastPointer]);

            // When both pointers meet, a cycle is detected
            if (slowPointer == fastPointer) {
                break;
            }
        }

        // Phase 2: Find the entrance of the cycle (the duplicate number)
        // Move slow pointer to the start of the array
        slowPointer = nums[0];

        // Move both pointers one step at a time
        // The index where they meet again is the duplicate number
        while (slowPointer != fastPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        }

        // Both pointers are now pointing to the duplicate element
        return slowPointer;
    }

}
