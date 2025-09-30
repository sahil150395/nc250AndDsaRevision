package AlgoRevision;

public class SlidingWindowVariableSize {

    public static void main(String[] args) {
        longestSubarrayWithSameValue(new int[]{4, 2, 2, 3, 3, 3});
    }

    public static int longestSubarrayWithSameValue(int[] nums) {
        int length = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left = right;
            }
            length = Math.max(length, right - left + 1);
        }

        return length;
    }

    public static int shortestSubarrayForATarget(int[] nums, int target) {
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
