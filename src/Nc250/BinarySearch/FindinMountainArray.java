package Nc250.BinarySearch;

public class FindinMountainArray {

    public static void main(String[] args) {
        MountainArray mountainArray = new MountainArray(new int[]{1, 2, 3, 4, 2, 1});
        findInMountainArray(2, mountainArray);
    }

    /*
     * Time complexity: O(logn)
     * Space complexity: O(1)
     */
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        // Step 1️⃣: Find the peak (maximum element) using binary search
        int left = 0, right = mountainArr.length() - 1;

        // Binary search to locate the peak element — where array switches from increasing to decreasing
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid < mid+1, we are on the increasing slope → move right
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            }// Otherwise, we are on the decreasing slope or at the peak → move left
            else {
                right = mid;
            }
        }

        // When the loop ends, 'left' (or 'right') points to the peak index
        int peak = left;

        // Step 2️⃣: Binary search in the left (ascending) half
        left = 0;
        right = peak;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Standard binary search since it's ascending order
            if (target < mountainArr.get(mid)) {
                right = mid - 1;
            } else if (target > mountainArr.get(mid)) {
                left = mid + 1;
            } else {
                return mid; // Found target in left half
            }
        }

        // Step 3️⃣: Binary search in the right (descending) half
        left = peak;
        right = mountainArr.length() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Now the order is descending, so comparison directions are reversed
            if (target < mountainArr.get(mid)) {
                left = mid + 1; // move right because values get smaller
            } else if (target > mountainArr.get(mid)) {
                right = mid - 1; // move left because values get larger
            } else {
                return mid; // Found target in right half
            }
        }

        // Step 4️⃣: If target not found in either half
        return -1;
    }

}

//it is predefined in the problem
class MountainArray {

    private int[] mountainArray;

    public MountainArray(int[] mountainArr) {
        this.mountainArray = mountainArr;
    }

    public int get(int index) {
        return mountainArray[index];
    }

    public int length() {
        return mountainArray.length;
    }

}
