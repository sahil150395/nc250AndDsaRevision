package AlgoRevision;

import java.util.Arrays;

public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] numsArray = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sortColors(numsArray);
        System.out.println(Arrays.toString(numsArray));
    }

    public static void sortColors(int[] nums) {

        /*
         * Algortithm to sort an array with 3 unique values in increasing order typically 0,1,2
         * It is done by using three pointers approach
         * left & mid-pointer start at 0
         * right pointer start at nums.length -1
         * if the value at mid is 0, swap mid with the left pointer and increment both mid and left pointer
         * If the value at mid is 1, only increment the mid-pointer
         * If the value at mid is 2, swap mid with right pointer value and decrement right pointer
         * */

        int left = 0, mid = 0, right = nums.length - 1;

        while (mid <= right) {
            switch (nums[mid]) {
                case 0:
                    // swap mid with left pointer
                    swap(nums, left, mid);
                    mid++;
                    left++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    // swap mid with right pointer
                    swap(nums, mid, right);
                    right--;
                    break;
            }
        }

    }

    private static void swap(int[] nums, int pointer1, int pointer2) {
        int temp = nums[pointer1];
        nums[pointer1] = nums[pointer2];
        nums[pointer2] = temp;
    }

}
