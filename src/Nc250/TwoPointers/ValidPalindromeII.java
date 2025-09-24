package Nc250.TwoPointers;

public class ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(validPalindromeII("aca"));
        System.out.println(validPalindromeII("abbadc"));
        System.out.println(validPalindromeII("abbda"));
        System.out.println(validPalindromeII("abc")); // it is expected to return false
    }

    public static boolean validPalindrome(String s) {

        if (isPalindrome(s)) return true;

        for (int i = 0; i < s.length(); i++) {
            String partOne = s.substring(0, i);
            String partTwo = s.substring(i + 1);
            String newS = partOne.concat(partTwo);
            if (isPalindrome(newS)) {
                return true;
            }
        }


        return false;
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean validPalindromeII(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindromeII(s, left + 1, right) || isPalindromeII(s, left, right - 1);
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindromeII(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
