package Nc250;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        System.out.println(subarraySumBruteForceUsingPrefix(new int[] {2,-1,1,2}, 2));
    }

    public static int subarraySumBruteForce(int[] nums, int k) {
        int subArrayCount = 0;
        for (int i = 0; i < nums.length; i++) {

            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];

                if (k == currentSum)
                    subArrayCount++;
            }
        }
        return subArrayCount;
    }

    public static int subarraySumBruteForceUsingPrefix(int[] nums, int k) {
        int res = 0, currSum = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        // the key in the map is the prefixSum
        // we initialize a prefixSum of 0 with an occurrence of 1
        prefixMap.put(0, 1);

        for (int num : nums) {
            currSum += num;
            int diff = currSum - k;
            res += prefixMap.getOrDefault(diff, 0);
            prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);
        }


        return res;
    }
}
