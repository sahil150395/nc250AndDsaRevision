package Nc250.ArraysAndHashing;

public class ProductsofArrayExceptSelf {

    public static void main(String[] args) {
        productExceptSelfUsingPrefixPostFix(new int[]{1,2,3,4});
    }

    public static int[] productExceptSelf(int[] nums) {

        /*
         * brute force solution will be to loop over the entire array and
         * find the product of the array and find the product excludng the bumber itself
         * */

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }

        return result;
    }


    public static int[] productExceptSelfUsingDivide(int[] nums) {
        /*
         * find the entire product and divide by the current element
         * */

        int[] result = new int[nums.length];
        int product = 1, zeroCount = 0;

        for (int num : nums) {
            if (num != 0) {
                product *= num;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount > 1) {
            return new int[nums.length];
        }

        for (int idx = 0; idx < nums.length; idx++) {
            if (zeroCount > 0) {
                result[idx] = (nums[idx] == 0) ? product : 0;
            } else {
                result[idx] = product / nums[idx];
            }
        }

        return result;
    }

    public static int[] productExceptSelfUsingPrefixPostFix(int[] nums) {
        /*
         * find the entire product and divide by the current element
         * */

        int arrlength = nums.length;
        int[] result = new int[arrlength];

        // first get the prefix products in the rsultant array
        result[0] = 1;
        for (int idx = 1; idx < arrlength; idx++) {
            result[idx] = result[idx - 1] * nums[idx - 1];
        }

        // now need the products of the postfix in the same result array
        int postFix = 1;
        for (int idx = arrlength - 1; idx >= 0; idx--) {
            result[idx] *= postFix;
            postFix *= nums[idx];
        }

        return result;
    }
}
