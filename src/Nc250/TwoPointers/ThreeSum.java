package Nc250.TwoPointers;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSumUsingPointers(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSumUsingPointers(new int[]{0, 1, 1}));
        System.out.println(threeSumUsingPointers(new int[]{0, 0, 0}));
        System.out.println(threeSumUsingPointers(new int[]{-2, 0, 1, 1, 2}));
    }

    public static List<List<Integer>> threeSumBruteForceSolution(int[] nums) {

        //Brute force
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(tmp);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static List<List<Integer>> threeSumUsingPointers(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
