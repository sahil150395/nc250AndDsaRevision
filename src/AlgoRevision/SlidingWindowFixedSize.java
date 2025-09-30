package AlgoRevision;

import java.util.HashSet;

public class SlidingWindowFixedSize {

    public static void main(String[] args) {
        closeDuplicatesUsingSlidingWindow(new int[]{1, 2, 3, 2, 3, 3}, 3);
    }

    public static boolean closeDuplicatesBruteForce(int[] nums, int k) {

        for (int L = 0; L < nums.length; L++) {
            for (int R = L + 1; R < Math.min(nums.length, L + k); R++) {
                if (nums[L] == nums[R]) return true;
            }
        }

        return false;
    }

    public static boolean closeDuplicatesUsingSlidingWindow(int[] nums, int k) {

        HashSet<Integer> windowElements = new HashSet<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {

            if (right - left + 1 > k) {
                windowElements.remove(nums[left]);
                left++;
            }
            if (windowElements.contains(nums[right])) {
                return true;
            }
            windowElements.add(nums[right]);
        }

        return false;
    }
}
