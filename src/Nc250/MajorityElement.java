package Nc250;

import java.util.HashMap;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{5, 5, 1, 1, 1, 5, 5}));
    }

    private static int majorityElement(int[] nums) {
        int res = 0, maxCount = 0;

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);

            if (frequency.get(num) > maxCount) {
                res = num;
                maxCount = frequency.get(num);
            }
        }

        return res;
    }
}
