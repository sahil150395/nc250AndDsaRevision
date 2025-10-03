package Nc250.SlidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        lengthOfLongestSubstring("zxyzxyz");
        lengthOfLongestSubstring("xxxx");
        lengthOfLongestSubstring("abcabcbb");
    }

    public static int lengthOfLongestSubstringBruteForce(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> charSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (charSet.contains(s.charAt(j))) {
                    break;
                }
                charSet.add(s.charAt(j));
                maxLength = Math.max(maxLength, charSet.size());
            }
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        HashSet<Character> seenCharSet = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (seenCharSet.contains(s.charAt(right))) {
                seenCharSet.remove(s.charAt(left));
                left++;
            }
            seenCharSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
