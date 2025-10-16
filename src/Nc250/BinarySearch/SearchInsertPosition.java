package Nc250.BinarySearch;

public class SearchInsertPosition {

    public static void main(String[] args) {
//        System.out.println(searchInsert(new int[]{-1, 0, 2, 4, 6, 8}, 5));
//        System.out.println(searchInsert(new int[]{-1, 0, 2, 4, 6, 8}, 1));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    /*
    * Time complexity: O(n)
    * Space complexity: 1
    * */
    public static int searchInsert(int[] nums, int target) {
        /*
        * We use the regular binary search algorithm to find the target in the nums array which are in increasing order.
        * If the target exists in the array, we will find it at the middle index after multiple iterations.
        * If we never find the index, we return the left because we have the base condition of left <= right
        * and in both the cases where if the target is less than the current mid or greater than the current mid
        * its always the left index that crosses the right.
        * */
        int left = 0, right = nums.length - 1, mid=0;

        while (left <= right) {
            mid = left + ((right - left) / 2);

            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
