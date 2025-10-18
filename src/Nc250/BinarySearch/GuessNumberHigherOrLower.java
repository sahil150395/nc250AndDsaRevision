package Nc250.BinarySearch;

public class GuessNumberHigherOrLower {

    public static void main(String[] args) {
        System.out.println(guessNumber(5));
    }

    /*
     * Time complexity: O(logn)
     * Space complexity: O(1)
     * */
    public static int guessNumber(int n) {
        // n is the number range higher limit
        int low = 1, high = n;

        while (low <= high) {

            int mid = low + (high - low) / 2; // mid is the guess we make
            int result = guess(mid);
            if (result < 0) {
                high = mid - 1;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private static int guess(int pick) {

        /*
         * In the question this is a pre defined API
         * You call a pre-defined API int guess(int num), which returns three possible results:
         * 0: your guess is equal to the number I picked (i.e. num == pick).
         * -1: Your guess is higher than the number I picked (i.e. num > pick).
         * 1: Your guess is lower than the number I picked (i.e. num < pick).
         * */
        return -1;
    }
}
