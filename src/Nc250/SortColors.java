package Nc250;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] colors = new int[]{1, 0, 1, 2};
        sortColors(colors);
        Arrays.toString(colors);
    }

    public static void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (count[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }
}
