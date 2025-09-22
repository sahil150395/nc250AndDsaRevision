package Nc250.ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {

    public final static char DELIMITER = '#';

    public static void main(String[] args) {
        String encodedString = encode(Arrays.asList("we", "say", ":", "yes"));
        System.out.println(encodedString);
        decode(encodedString);
    }

    public static String encode(List<String> strs) {
        if (strs.isEmpty())
            return "";

        StringBuilder result = new StringBuilder();

        for (String str : strs) {
            result.append(str.length()).append(DELIMITER).append(str);
        }
        return result.toString();
    }

    public static List<String> decode(String str) {
        if (str.length() == 0)
            return List.of();

        List<String> result = new ArrayList<>();

        int i = 0; // staring point of the string ieration
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != DELIMITER) {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            result.add(str.substring(i, j));
            i = j;
        }

        return result;
    }
}
