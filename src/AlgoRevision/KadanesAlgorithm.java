package AlgoRevision;

/*
 * Given an integer array arr[],
 * find the subarray (containing at least one element)
 * which has the maximum possible sum, and return that sum.
 */

public class KadanesAlgorithm {

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));
    }

    private static int maxSubarraySum(int[] arr) {
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {

            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];

                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}