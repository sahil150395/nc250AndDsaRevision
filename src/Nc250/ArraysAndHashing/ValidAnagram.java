package Nc250.ArraysAndHashing;

import java.util.HashMap;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagramUsingArray("racecar", "carrace"));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> sFrequency = new HashMap<>();
        HashMap<Character, Integer> tFrequency = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sFrequency.put(s.charAt(i), sFrequency.getOrDefault(s.charAt(i), 0) + 1);
            tFrequency.put(t.charAt(i), tFrequency.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sFrequency.equals(tFrequency);
    }

    private static boolean isAnagramUsingArray(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] frequencyArray = new int[26]; // since these are alphabets there will be  maximum of 26 characters

        // we will loop over the characters of the strings and add the ascii value of 'a' for string s
        // and subtract ascii value of 'a' if we see the same character in string t
        //the loop over the resultant frequencyArray to see if all values are 0 or not

        for (int i = 0; i < s.length(); i++) {
            frequencyArray[s.charAt(i) - 'a']++;
            frequencyArray[t.charAt(i) - 'a']--;
        }

        for (int val : frequencyArray) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
