package Nc250.TwoPointers;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        char[] testArray = new char[]{'n', 'e', 'e', 't'};
        reverseString(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    public static void reverseString(char[] s) {
        int Left = 0, Right = s.length - 1;

        while (Left < Right) {
            char temp = s[Left];
            s[Left] = s[Right];
            s[Right] = temp;
            Right--;
            Left++;
        }
    }
}
