package Nc250.SlidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindowBruteForce(new int[]{1, 2, 1, 0, 4, 2, 6}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 2, 1, 0, 4, 2, 6}, 3)));
    }

    public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        int[] resultArr = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            resultArr[i] = max;
        }
        return resultArr;
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] resultArr = new int[n - k + 1];

        /*
         * We are using a Monotonic decreasing queue that holds the index value
         * of the values in nums array when sorted in decreasing order
         * */
        Deque<Integer> indexQueue = new LinkedList<>();
        int left = 0, right = 0;


        while (right < n) {

            /*
             * We compare the current element at the right index against the corresponding
             * value at the index stored at the last of the queue, so that we store
             * the indices based on the decreasing value
             * */
            while (!indexQueue.isEmpty() && nums[indexQueue.getLast()] < nums[right]) {
                indexQueue.removeLast();
            }
            indexQueue.addLast(right);

            /*
             * If the current left index is greater than the index stored at the left most
             * position in the queue and that value is outside the sliding window, we should
             * remove it from the queue
             * */
            if (left > indexQueue.getFirst()) {
                indexQueue.removeFirst();
            }

            // once window reaches the desired size
            /*
             * We are getting the value corresponding to the index value at the first of the
             * queue, because it will hold the index of the largest value
             * */
            if ((right - left + 1) >= k) {
                resultArr[left] = nums[indexQueue.getFirst()];
                left++;
            }

            right++;
        }


        return resultArr;
    }
}
