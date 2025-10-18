package Nc250.BinarySearch;

public class Sqrtx {

    public static void main(String[] args) {
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(13));
        System.out.println(mySqrt(17));
        System.out.println(mySqrt(2147395600));
        System.out.println(mySqrt(1));
    }

    /*
     * Time complexity: O(logn)
     * Space complexity: O(1)
     * */
    public static int mySqrt(int x) {

        int low = 0, high = x, result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((long) mid * mid > x) {
                high = mid - 1;
            } else if ((long) mid * mid < x) {
                low = mid + 1;
                result = mid; // we are setting the result to the lowest mid
            } else {
                return mid;
            }

        }
        return result;
    }
}
