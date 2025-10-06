package Nc250.SlidingWindow;

import java.util.List;
import java.util.ArrayList;

public class FindKClosestElements {

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{2, 4, 5, 8}, 2, 6));
        System.out.println(findClosestElements(new int[]{2, 3, 4}, 3, 1));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;

        while (right - left >= k) {
            if (Math.abs(x - arr[left]) <= Math.abs(x - arr[right])) {
                right--;
            } else {
                left++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
