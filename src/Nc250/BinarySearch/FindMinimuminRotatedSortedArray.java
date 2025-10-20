package Nc250.BinarySearch;

public class FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMinBruteForce(new int[]{3, 4, 5, 6, 1, 2}));
        System.out.println(findMin(new int[]{3, 4, 5, 6, 1, 2}));
        System.out.println(findMinBruteForce(new int[]{4, 5, 0, 1, 2, 3}));
        System.out.println(findMin(new int[]{4, 5, 0, 1, 2, 3}));
        System.out.println(findMinBruteForce(new int[]{4, 5, 6, 7}));
        System.out.println(findMin(new int[]{4, 5, 6, 7}));
    }

    /*
     * Brute-force O(n) logic:
     * Scan the array and find the first index i where nums[i] > nums[i + 1].
     * The next element (nums[i + 1]) is the minimum (rotation point).
     * If no such point exists, the array wasn't rotated; return nums[0].
     * */
    public static int findMinBruteForce(int[] nums) {
        int index = 0;
        while (index < nums.length - 1) {
            if (nums[index] > nums[index + 1]) {
                break;
            }
            index++;
        }

        return index == nums.length - 1 ? nums[0] : nums[index + 1];
    }

    public static int findMin(int[] nums) {

        // Binary search to find the minimum in a rotated sorted array:
        // Compare nums[mid] with nums[right] to decide which side the minimum lies on.
        // If nums[mid] > nums[right], the minimum is in the right half → move left = mid + 1.
        // Else, the minimum is at mid or in the left half → move right = mid.
        // When the loop ends (left == right), both point to the smallest element.

        int left = 0, right = nums.length - 1, mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
