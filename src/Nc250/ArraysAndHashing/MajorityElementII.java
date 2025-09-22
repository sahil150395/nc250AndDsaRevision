package Nc250.ArraysAndHashing;

import java.util.*;

public class MajorityElementII {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{5, 2, 3, 2, 2, 2, 2, 5, 5, 5}));
        System.out.println(majorityElement(new int[]{4, 4, 4, 4, 4}));
        System.out.println(majorityElement(new int[]{1, 2, 3}));
    }

    public static List<Integer> majorityElement(int[] nums) {

        int maxOccurrenceLimit = nums.length / 3;

        List<Integer> majorityElements = new ArrayList<>();
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);

            if (!majorityElements.contains(num) && frequency.get(num) > maxOccurrenceLimit) {
                majorityElements.add(num);
            }

        }
        return majorityElements;
    }

}
