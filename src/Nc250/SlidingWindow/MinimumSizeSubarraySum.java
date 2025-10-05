package Nc250.SlidingWindow;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(10, new int[]{2, 1, 5, 1, 5, 3}));
        System.out.println(minSubArrayLen(5, new int[]{1, 2, 1}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length + 1;
        int left = 0, total = 0;

        for (int right = 0; right < nums.length; right++) {

            total += nums[right];

            while (total >= target) {
                length = Math.min(length, right - left + 1);
                total -= nums[left];
                left++;
            }

        }


        return length == nums.length + 1 ? 0 : length;
    }
}
