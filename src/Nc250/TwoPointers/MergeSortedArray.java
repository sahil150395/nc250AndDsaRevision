package Nc250.TwoPointers;

import java.util.Arrays;

public class MergeSortedArray {


    public static void main(String[] args) {
        int[] nums1 = new int[]{10, 20, 20, 40, 0, 0};
        int[] nums2 = new int[]{1, 2};
        merge(nums1, 4, nums2, 2);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        /*
         * since nums1 has 0's at the end, it makes sense to start inserting from the last and replacing
         * the 0's with the largest element from bot the ararys
         * */

        /*
         * will keep inserting at the last till we have elements in both arrays
         * m is the number of valid elements in num1 rest all are zeros
         * n is the number of elements in nums2
         * */

        while (m > 0 && n > 0) {
            if(nums1[m-1] < nums2[n-1]) {
                nums1[last] = nums2[n-1];
                n--;
            } else {
                nums1[last] = nums1[m-1];
                m--;
            }
            last--;
        }

        // now the edge case is there is a possibility the last few element in nums2 are less than few element in nums1
        // and are not populated  in nums1
        // so that has to be inserted in the array too

        while(n > 0) {
            nums1[last] = nums2[n-1];
            n--;
            last--;
        }

    }
}
