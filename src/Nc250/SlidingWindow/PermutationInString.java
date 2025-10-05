package Nc250.SlidingWindow;

import java.util.Arrays;

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "lecabee"));
        System.out.println(checkInclusion("abc", "lecaabee"));
    }

    public static boolean checkInclusionBruteForce(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int k = s1.length();
        int left = 0;
        int right = left + k;

        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);
        String permuatationString = new String(s1Array);

        while (right <= s2.length()) {
            char[] currentWindowArray = s2.substring(left, right).toCharArray();
            Arrays.sort(currentWindowArray);
            String currentWindowStr = new String(currentWindowArray);

            if (currentWindowStr.equals(permuatationString)) {
                return true;
            }

            left++;
            right++;
        }

        return false;
    }


    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int left = 0;

        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26) return true;

            int index = s2.charAt(right) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            index = s2.charAt(left) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }

            left++;
        }

        return matches == 26;
    }
}
