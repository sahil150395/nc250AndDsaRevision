package Nc250.BinarySearch;

public class SearchinRotatedSortedArrayII {

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 4, 4, 5, 6, 1, 2, 2}, 1));
        System.out.println(search(new int[]{3, 5, 6, 0, 0, 1, 2}, 4));
    }


    // Modified binary search to handle rotated sorted arrays (with possible duplicates).
    // Identify which half is sorted in each iteration and decide where to move.
    // If nums[l] == nums[m], increment l to skip duplicates safely.
    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return true;
            }

            // Compare with nums[left] and nums[right] instead of just nums[mid]
            // because the array is rotated — we must identify which half is sorted
            // before deciding where the target could lie.
            if (nums[left] < nums[mid]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else if (nums[left] > nums[mid]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            } else {
                left++;
            }


        }

        return false;
    }
}
