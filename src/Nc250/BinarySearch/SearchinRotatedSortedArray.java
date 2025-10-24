package Nc250.BinarySearch;

public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 5, 6, 0, 1, 2}, 4));
        System.out.println(search(new int[]{3, 5, 6, 0, 1, 2}, 1));
    }

    // Step 1: Find the pivot (index of smallest element) using binary search.
    // Step 2: Decide which sorted half [0..pivot-1] or [pivot..n-1] contains the target.
    // Step 3: Perform binary search only on that half.
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // Binary search to find the pivot (smallest element).
        // If nums[mid] > nums[right], the minimum lies to the right of mid,
        // otherwise it lies at mid or to its left.
        // Loop ends when left == right, which points to the index of the smallest element.
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int pivot = left;

        if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, target, pivot, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, pivot - 1);
        }
    }


    private static int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }

        }
        return -1;
    }
}
