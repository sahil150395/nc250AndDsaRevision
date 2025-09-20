package Nc250;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public static int longestConsecutiveBruteForce(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        int longestSequenceLength = 0;
        for (int num : nums) {
            int streak = 0, current = num;
            while (numSet.contains(current)) {
                streak++;
                current++;
            }

            longestSequenceLength = Math.max(streak, longestSequenceLength);
        }

        return longestSequenceLength;
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestSequenceLength = 0;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int length = 1;

                while (numSet.contains(num + length)) {
                    length++;
                }

                longestSequenceLength = Math.max(length, longestSequenceLength);
            }
        }

        return longestSequenceLength;
    }
}
