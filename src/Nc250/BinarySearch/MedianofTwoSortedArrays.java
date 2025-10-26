package Nc250.BinarySearch;

public class MedianofTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArraysBruteForce(new int[]{1, 2}, new int[]{3}));
        System.out.println(findMedianSortedArraysBruteForce(new int[]{1, 3}, new int[]{2, 4}));
    }

    /*
     * Time complexity: O(n)
     * Space complexity: O(n)
     * */
    public static double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {
        int finalSize = nums1.length + nums2.length;
        int[] finalSet = new int[finalSize];
        int i = 0, j = 0, idx = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                finalSet[idx] = nums1[i];
                i++;
            } else {
                finalSet[idx] = nums2[j];
                j++;
            }
            idx++;
        }

        while (i < nums1.length) {
            finalSet[idx] = nums1[i];
            idx++;
            i++;
        }

        while (j < nums2.length) {
            finalSet[idx] = nums2[j];
            idx++;
            j++;
        }

        int first = 0, last = finalSet.length - 1;
        int mid = first + (last - first) / 2;

        double median = finalSet.length % 2 == 0 ? (double) (finalSet[mid] + finalSet[mid + 1]) / 2 : (double) finalSet[mid];

        return median;
    }


    /*
     * Time complexity: O(log(min(n1,n2))), n1 = A.length, n2 = B.length
     * Space complexity: O(n)
     * */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Step 1: Assign A as nums1 and B as nums2 for convenience
        int[] A = nums1;
        int[] B = nums2;

        // Total number of elements across both arrays
        int totalLength = A.length + B.length;

        // Half represents how many elements should be in the left partition
        // (We add +1 so it works for both odd and even total lengths)
        int half = (totalLength + 1) / 2;

        // Step 2: Ensure A is the smaller array (binary search on smaller side for efficiency)
        if (A.length > B.length) {
            int[] temp = B;
            B = A;
            A = temp;
        }

        // Step 3: Initialize binary search boundaries on A
        // We can make the cut anywhere between 0 and A.length (inclusive)
        int l = 0;
        int r = A.length;

        // Step 4: Binary search for the correct partition
        while (l <= r) {
            // i = cut position in A
            int i = (l + r) / 2;

            // j = how many elements need to come from B so that total left side = half
            int j = half - i;

            // Edge values around the partition
            // Use MIN_VALUE / MAX_VALUE when partition is at array boundaries
            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int Bright = j < B.length ? A[j] : Integer.MAX_VALUE;

            // Step 5: Check if we found the perfect partition
            // Condition: every element in left partition <= every element in right partition
            if (Aleft <= Bright && Bleft <= Aright) {
                // If total number of elements is odd, median is the max of left partition
                if (totalLength % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }
                // If even, median is average of middle two elements
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else if (Aleft > Bright) { // Step 6: If partition is too far right in A (Aleft too big)
                r = i - 1; // move search space left
            } else { // Step 7: If partition is too far left in A (Bleft too big)
                l = i + 1; // move search space right
            }
        }

        // Should never reach here if input is valid
        return -1;
    }
}
