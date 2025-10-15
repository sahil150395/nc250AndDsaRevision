package Nc250.Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleAreaBruteForce(int[] heights) {
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            // we need to check till what point can we extend the current rectangle to the right find the max area
            int height = heights[i];
            int rightMost = i + 1;
            while (rightMost < n && heights[rightMost] >= height) {
                rightMost++;
            }

            // we need to check till what point can we extend the current rectangle to the left to find the max area
            int leftMost = i;
            while (leftMost >= 0 && heights[leftMost] >= height) {
                leftMost--;
            }

            // The while loop stops *after* crossing the first invalid bar,
            // so we adjust (leftMost++, rightMost--) to move back to the last valid index.
            rightMost--;
            leftMost++;
            maxArea = Math.max(maxArea, height * (rightMost - leftMost + 1));
        }

        return maxArea;
    }


    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); // pair: (index, height)

        /*
         * In this loop we iterate over the heights array, and check in the stack if the element at the top
         * is greater than the current height, we need to pop it, because that is the limit of
         * the top and it cant be extended beyond the current element we want to push of the stack to find
         * the max area.
         * */
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        /*
         * After the first loop we will still have heights that are in increasing order
         * we need to empty out the stack and calculate the area again to see if it is
         * greater than the current max.
         * */

        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
}
