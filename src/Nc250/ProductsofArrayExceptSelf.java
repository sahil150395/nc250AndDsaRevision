package Nc250;

public class ProductsofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

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


    public int[] productExceptSelfUsingDivide(int[] nums) {
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
}
