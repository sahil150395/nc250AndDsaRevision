package Nc250.TwoPointers;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trapWaterUsingTwoPointerApproach(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }


    public static int trapWaterBruteForce(int[] height) {
        /*
         * We need to find the maximum height on the left and right toknow what is the amount of water
         * that can be store at the current index
         * */

        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int leftMax = height[i];
            int rightMax = height[i];

            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }


            result += Math.min(leftMax, rightMax) - height[i];

        }


        return result;
    }

    public static int trapWaterUsingPrefixSuffix(int[] height) {
        /*
         * We need to find the maximum height on the left and right toknow what is the amount of water
         * that can be store at the current index
         * We can maintain two arrays one with prefix having max height on the left of current index,
         * and one with the max height on the right of the current index to remove the
         * redundant work of finding the max height to the left and right again and again
         * */

        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int result = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }


        return result;
    }


    public static int trapWaterUsingTwoPointerApproach(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int result = 0;
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        /*
        * We will compare the leftMax and rightMax and increment the
        * pointer with the lower value, because when we calculate the water
        * we can store at a index we need to find the lower value of the two
        * max bars on the left and right and subtract the height of the current.
        * And we initite the left and right max to the start and end of an array
        * because we cant store any water there as it wont have any boundaries.
        * */

        while (left < right) {

            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                result+= leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                result+= rightMax - height[right];
            }

        }

        return result;
    }
}
