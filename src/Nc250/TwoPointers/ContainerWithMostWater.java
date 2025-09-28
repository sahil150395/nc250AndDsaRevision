package Nc250.TwoPointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxAreaUsingPointers(new int[]{1, 7, 2, 5, 4, 7, 3, 6}));
        System.out.println(maxAreaUsingPointers(new int[]{2, 2, 2}));
    }

    public static int maxAreaBruteForceApproach(int[] heights) {
        /*
         * 1. find the area of all the avialable pairs by looping over all the heights
         * 2. the area formula = (jth Index-ith index) * min height between the two heights
         * */
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int area = (j - i) * Math.min(heights[i], heights[j]);
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }

    public static int maxAreaUsingPointers(int[] heights) {
        /*
         * 1. use a left and right pointer, left starting at 0 and right at heights.length-1
         * 2. calculate the area using the formula = (right index-left index) * min height between the two heights
         * 3. compare it against the current maxArea and select the bigger value
         * 4. move either of lower index from the left or right index, the reason for doing it is
         * the greater the height, greater the amount of water it can store
         * */

        int maxArea = 0;
        int left = 0, right = heights.length - 1;

        while(left < right) {
            int area = (right - left) * Math.min(heights[left], heights[right]);
            maxArea = Math.max(area, maxArea);

            if(heights[left] <= heights[right]) {
                left++;
            } else {
                right--;
            }

        }

        return maxArea;
    }

}
