package Nc250.BinarySearch;

import java.util.Arrays;

public class KokoEatingBananas {

    public static void main(String[] args) {
        System.out.println(minEatingSpeedBruteForce(new int[]{1, 4, 3, 2}, 9));
        System.out.println(minEatingSpeed(new int[]{1, 4, 3, 2}, 9));
    }

    // Time complexity: O(m∗n)
    // Space complexity: O(1)
    // Where n is the length of the input array piles and m is the maximum number of bananas in a pile.
    public static int minEatingSpeedBruteForce(int[] piles, int h) {
        int speed = 1; // min speed that is possible is 1

        // check every speed until a speed is found which is less than the time limit
        while (true) {
            long totalTime = 0;
            for (int pile : piles) {
                totalTime += (int) Math.ceil((double) pile / speed);
            }
            if (totalTime <= h) {
                return speed;
            }
            speed++;
        }
    }


    // Time complexity: O(n∗logm)
    // Space complexity: O(1)
    // Where n is the length of the input array piles and m is the maximum number of bananas in a pile.
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt(); // gets the pile maximum count
        int result = right; // because we would atmost need the speed equal to the maxcount if no minimum exists

        /*
         * We are executing binary search over the sorted range of left to right i.e. from 1 to
         * the max bananas in a pile because the least eating speed is 1
         * */

        while (left <= right) {
            int k = left + (right - left) / 2; // k is bananas-per-hour eating rate
            long totalTime = 0;
            for (int pile : piles) {
                totalTime += Math.ceil((double)pile / k);
            }

            if (totalTime <= h) {
                /*
                * if the total time is less than total hrs we have to eat bananas at the current speed,
                * we update the result to the current rate k and move our right pointer
                * to the rate by decreasing one, so that we can try to find even a lower rate within
                * our threshold of hr hrs. If it is greater than our alloted time, we move or left pointer to k+1
                * */
                result = k;
                right = k - 1;
            } else {
                left = k + 1;
            }

        }

        return result;
    }
}
