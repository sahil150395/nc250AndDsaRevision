package Nc250.BinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 2, 4, 6, 8}, 4));
        System.out.println(search(new int[]{-1, 0, 2, 4, 6, 8}, 3));
    }

    /*
     * Time complexity: O(logn) for recursive
     * Space complexity: O(logn) for recursive
     * For binary serach to be used the data has to be in sorted order.
     * We begin our search with start=0, and end=nums.length - 1.
     * Middle is calculated as (start + end)/2.
     * We check the value at the middle, if the key we are trying to find is greater than the value at the mid.
     * We reset our start to mid+1, because we will never find the value before the current mid, if it is less than
     * the value at the middle index.
     * If the value at the middle is greater than our search key, we reset our end to mid-1, because we will
     * never find the value after the current mid.
     * This way we are able to eliminate half of the array from consideration, if the mid is greater or less than our
     * search key.
     * */
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        /*
         * Time complexity: O(logn)
         * Space complexity: O(1)
         */
        while (left <= right) {
            /*
             * alternative way to fnd the mid
             * int mid = left + ((right-left) /2)
             * Using left + (right - left) / 2 prevents integer overflow,
             * which can happen with (left + right) / 2 when left and right are large.
             * */
            //int mid = (left + right) / 2;
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
        //return recuriveBinarySearch(nums, 0, nums.length - 1, target);
    }

    public static int recuriveBinarySearch(int[] nums, int start, int end, int key) {
        if (start > end) return -1;
        else {
            int mid = (start + end) / 2;

            if (key > nums[mid]) {
                return recuriveBinarySearch(nums, mid + 1, end, key);
            } else if (key < nums[mid]) {
                return recuriveBinarySearch(nums, start, mid - 1, key);
            } else {
                return mid;
            }
        }
    }
}
