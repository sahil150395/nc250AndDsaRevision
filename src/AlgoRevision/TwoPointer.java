package AlgoRevision;

public class TwoPointer {

    public static boolean isAnagram(String str) {
        int L = 0, R = str.length() - 1;

        while (L < R) {
            if (str.charAt(L) != str.charAt(R)) {
                return false;
            }
            L++;
            R--;
        }

        return true;
    }

    public static int[] targetSum(int[] nums, int target) {
        int L = 0, R = nums.length - 1;

        while (L < R) {
            if (nums[L] + nums[R] > target) {
                R--;
            } else if (nums[L] + nums[R] < target) {
                L++;
            } else {
                return new int[]{L, R};
            }
        }

        return null;
    }
}
