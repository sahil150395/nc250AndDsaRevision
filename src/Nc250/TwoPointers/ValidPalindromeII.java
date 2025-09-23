package Nc250.TwoPointers;

public class ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(validPalindrome("aca"));
        System.out.println(validPalindrome("abbadc"));
        System.out.println(validPalindrome("abbda"));
        System.out.println(validPalindrome("abc")); // it is expected to return false
    }

    public static boolean validPalindrome(String s) {
        int unmatchedCharacterCount = 0, left = 0, right = s.length() - 1;

        while (left < right) {

            while (!isAlphaNumeric(s.charAt(left)) && left < right) left++;
            while (!isAlphaNumeric(s.charAt(right)) && left < right) right--;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                if (unmatchedCharacterCount == 1) {
                    return false;
                }
                unmatchedCharacterCount++;
            }


            left++;
            right--;
        }

        return true;
    }


    private static boolean isAlphaNumeric(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
