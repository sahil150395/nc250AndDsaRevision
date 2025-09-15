package Nc250;

public class RemoveElement {

    private static int removeInPlace(int[] nums, int element) {
        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != element) {
                nums[pointer++] = nums[i];
            }
        }
        return pointer;
    }
}
