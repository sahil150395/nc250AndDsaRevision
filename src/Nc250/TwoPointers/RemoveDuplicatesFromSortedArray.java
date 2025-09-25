package Nc250.TwoPointers;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        int left = 0, right = 0;

        while (right < nums.length) {
            nums[left] = nums[right];
            while ((right < nums.length) && (nums[right] == nums[left])) {
                right++;
            }
            left++;
        }


        return left;
    }
}
