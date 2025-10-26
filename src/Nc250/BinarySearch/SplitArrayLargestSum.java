package Nc250.BinarySearch;

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{2, 4, 10, 1, 5}, 2));
        System.out.println(splitArray(new int[]{1, 0, 2, 3, 5}, 4));
    }

    // Similar to the CapacitytoShipPackagesWithinDDays problem
    //Time complexity: O(nlogS) - n is the number of elements in the weights array, S is the sum of all elements
    //Space complexity: O(1)
    public static int splitArray(int[] nums, int k) {
        // The smallest possible largest subarray sum is the largest single element (since we can't split an element)
        // The largest possible largest subarray sum is the sum of all elements (when we take the whole array as one part)
        int minSubArraySum = 0, maxSubArraySum = 0;

        for (int num : nums) {
            minSubArraySum = Math.max(minSubArraySum, num);
            maxSubArraySum += num;
        }

        int result = maxSubArraySum;

        // Binary search to find the minimal largest subarray sum
        while (minSubArraySum <= maxSubArraySum) {
            int subArrayMidSum = minSubArraySum + (maxSubArraySum - minSubArraySum) / 2;

            // Check if it's possible to split the array into <= k subarrays
            // such that no subarray sum exceeds subArrayMidSum
            if (isFeasible(nums, subArrayMidSum, k)) {
                // If feasible, try to minimize the largest subarray sum further
                maxSubArraySum = maxSubArraySum - 1;
                result = Math.min(result, subArrayMidSum);
            } else {
                // If not feasible, we need a larger allowed subarray sum
                minSubArraySum = minSubArraySum + 1;
            }

        }

        return result;
    }

    private static boolean isFeasible(int[] nums, int arraySum, int k) {

        // Greedily form subarrays without exceeding 'arraySum'
        int currentSum = 0, subArrayCount = 1;
        for (int num : nums) {
            // If adding this element exceeds the allowed max, start a new subarray
            if (currentSum + num <= arraySum) {
                currentSum += num;
            } else {
                currentSum = num;
                subArrayCount++;
            }
        }

        // Return true if we can form k or fewer subarrays under this limit
        return subArrayCount <= k;
    }
}
