package Nc250;

public class ConcatenationOfArray {

    private static int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];
        int idx = 0;

        // with this approach you can repeat the process n number
        // of times as here we are only concatenating the same array twice
        for (int i = 0; i < 2; i++) {
            for (int num : nums) {
                ans[idx] = num;
                idx++;
            }
        }

        return ans;
    }
}
