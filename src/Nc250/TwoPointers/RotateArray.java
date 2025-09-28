package Nc250.TwoPointers;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        rotate(nums, 7);
        System.out.println(Arrays.toString(nums));
    }


    public static void rotateBruteForce(int[] nums, int k) {
        int arrLength = nums.length;
        int[] result = new int[arrLength];

        int idx = 0;
        for (int i = arrLength - k; i < arrLength; i++) {
            result[idx++] = nums[i];
        }

        for (int i = 0; i < arrLength - k; i++) {
            result[idx++] = nums[i];
        }

        for (int i = 0; i < arrLength; i++) {
            nums[i] = result[i];
        }

    }

    public static void rotate(int[] nums, int k) {
        int arrLength = nums.length;
        k %= arrLength;

        reverse(nums, 0, arrLength - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, arrLength - 1);
        /*
         * 1. Using two pointers reverse the whole nums array
         * 2. once that is done, reverse the array staring from 0th index to k-1 index
         * 3. then reverse the array from k to nums.length-1 index
         * */
    }

    private static void reverse(int[] nums, int left, int right) {

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

    }
}
