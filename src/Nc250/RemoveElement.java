package Nc250;

public class RemoveElement {

    public static int removeInPlace(int[] nums, int element) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != element) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
