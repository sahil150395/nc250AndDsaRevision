package Nc250.SlidingWindow;

import java.util.Collections;
import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("AAABABB", 1));
    }

    public static int characterReplacementBruteForce(String s, int k) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            // most frequent character in the current window
            // to be used to replace the remaining characters in the substring
            int maxF = 0;

            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxF = Math.max(maxF, count.get(s.charAt(j)));

                if ((j - i + 1) - maxF <= k) {
                    result = Math.max(result, j - i + 1);
                }
            }


        }


        return result;
    }

    public static int characterReplacement(String s, int k) {
        int result = 0;

        HashMap<Character, Integer> count = new HashMap<>();
        int left = 0, maxF = 0;
        for (int right = 0; right < s.length(); right++) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            maxF = Math.max(maxF, count.get(s.charAt(right)));

            while((right - left + 1) - maxF > k) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }

            result = Math.max(right - left + 1, result);
        }


        return result;
    }
}
