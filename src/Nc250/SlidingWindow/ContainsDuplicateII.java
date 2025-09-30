package Nc250.SlidingWindow;

import java.util.HashSet;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        containsNearbyDuplicate(new int[]{2, 1, 2}, 1);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> windowElements = new HashSet<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (right - left > k) {
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
