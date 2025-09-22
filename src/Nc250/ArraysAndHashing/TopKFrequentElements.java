package Nc250.ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> countOfElements = new HashMap<>();

        for (int num : nums) {
            countOfElements.put(num, countOfElements.getOrDefault(num, 0) + 1);
        }

        // create a list array with buckets representing the counts of numbers
        List<Integer>[] frequency = new List[nums.length + 1];

        for (int i = 0; i < frequency.length; i++) {
            frequency[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : countOfElements.entrySet()) {
            frequency[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = frequency.length - 1; i > 0 && index < k; i--) {
            for (int n : frequency[i]) {
                result[index] = n;
                index++;
                if (index == k) {
                    return result;
                }
            }
        }


        return result;
    }
}
