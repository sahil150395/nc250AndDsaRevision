package Nc250.SlidingWindow;

import java.util.Map;
import java.util.HashMap;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("OUZODYXAZV", "XYZ"));
    }

    public static String minWindowBruteForce(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> tCharFreq = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tCharFreq.put(t.charAt(i), tCharFreq.getOrDefault(t.charAt(i), 0) + 1);
        }

        int[] res = {-1, -1};
        int resultLen = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> sCharFreq = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                sCharFreq.put(s.charAt(j), sCharFreq.getOrDefault(s.charAt(j), 0) + 1);

                boolean flag = true;

                for (char c : tCharFreq.keySet()) {
                    if (sCharFreq.getOrDefault(c, 0) < tCharFreq.get(c)) {
                        flag = false;
                        break;
                    }
                }

                if (flag && (j - i + 1 < resultLen)) {
                    resultLen = j - i + 1;
                    res[0] = i;
                    res[1] = j;
                }

            }
        }

        return resultLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

    public static String minWindow(String s, String t) {
        if (t.isEmpty()) return "";
        Map<Character, Integer> tCharFreq = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tCharFreq.put(t.charAt(i), tCharFreq.getOrDefault(t.charAt(i), 0) + 1);
        }

        int have = 0, need = tCharFreq.size();
        int[] res = {-1, -1};
        int resultLen = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            window.put(currentChar, window.getOrDefault(currentChar, 0) + 1);

            if (tCharFreq.containsKey(currentChar) && window.get(currentChar).equals(tCharFreq.get(currentChar))) {
                have++;
            }

            while (have == need) {
                if ((right - left + 1) < resultLen) {
                    resultLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (tCharFreq.containsKey(leftChar) && window.get(leftChar) < tCharFreq.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        return resultLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
