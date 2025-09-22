package Nc250.TwoPointers;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(".,"));
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {

            while (!isAlphanumeric(s.charAt(left)) && left < right) left++;

            while (!isAlphanumeric(s.charAt(right)) && right > left) right--;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;

            left++;
            right--;

        }

        return true;
    }

    private static boolean isAlphanumeric(char c) {
        return (c >= 48 && c <= 57) || (c >= 97 && c <= 122) || (c >= 65 && c <= 90);
    }
}
