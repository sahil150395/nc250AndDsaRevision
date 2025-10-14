package Nc250.Stack;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("2[a3[b]]c"));
        System.out.println(decodeString("axb3[z]4[c]"));
        System.out.println(decodeString("ab2[c]3[d]1[x]"));
    }

    public static String decodeString(String s) {

        /*
         * We will use a stack to decode the string.
         * We will loop over the string charcater by character and push it on to the stack.
         * The moment we encounter a ']' we start popping from the stack because that will be our repeating string.
         * We pop till the opening braces is also popped from the stack '['.
         * To find the number of times we want to repeat the string we need to pop from the stack as long as the
         * top of the stack is a digit.
         * Then we need to push the repeated string onto the stack.
         * */
        Stack<String> decodedStringStack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c != ']') {
                decodedStringStack.push(String.valueOf(c));
            } else {
                StringBuilder repeatingString = new StringBuilder();
                while (!decodedStringStack.peek().equals("[")) {
                    /*
                     * The insert() method of the StringBuilder class in Java is
                     * used to insert a given element at a specified position within the character sequence.*/
                    repeatingString.insert(0, decodedStringStack.pop());
                }
                decodedStringStack.pop(); // this pop is done to remove the '[' for the ']'

                StringBuilder frequency = new StringBuilder();
                //now we need to pop the count we should have of the repeating string
                // decodedStringStack.peek().charAt(0) -> returns the string as digit
                while (!decodedStringStack.isEmpty() && Character.isDigit(decodedStringStack.peek().charAt(0))) {
                    frequency.insert(0, decodedStringStack.pop());
                }
                int count = Integer.parseInt(frequency.toString());

                /**
                 * repeat() method is a feature of the String class, introduced in Java 11.
                 * It provides a convenient way to concatenate a string with itself a specified number of times.
                 */
                decodedStringStack.push(repeatingString.toString().repeat(count));
            }

        }


        return String.join("", decodedStringStack);
    }
}
