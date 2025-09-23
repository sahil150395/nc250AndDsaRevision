package Nc250.ArraysAndHashing;

import java.util.Arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositiveUsingSorting(new int[]{1, 2, 4}));
    }

    public static int firstMissingPositiveUsingSorting(int[] nums) {
        Arrays.sort(nums);
        int missing = 1;

        for (int num : nums) {
            if (missing == num) {
                missing++;
            }
        }

        return missing;
    }

    public static int firstMissingPositiveUsingBooleanArray(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n];

        for (int num : nums) {
            if (num > 0 && num <= n) {
                seen[num - 1] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
