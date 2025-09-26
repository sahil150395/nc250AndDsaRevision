package Nc250.TwoPointers;

import java.util.Arrays;

public class TwoIntegerSumII {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4}, 3)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;

        while (left < right) {

            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return new int[0];
    }
}
