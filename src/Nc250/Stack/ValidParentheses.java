package Nc250.Stack;

import java.util.Stack;
import java.util.HashMap;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("[]"));
        System.out.println(isValid("([{}])"));
        System.out.println(isValid("[(])"));
        System.out.println(isValidApproachII("[]"));
        System.out.println(isValidApproachII("([{}])"));
        System.out.println(isValidApproachII("[(])"));
    }

    public static boolean isValid(String s) {

        if (s == null || s.isEmpty() || (s.length() == 1)) return false;

        Stack<Character> parenthesesStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentBracket = s.charAt(i);

            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                parenthesesStack.push(currentBracket);
            } else if (currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {
                if (!parenthesesStack.isEmpty() && ((currentBracket == ')' && parenthesesStack.peek() == '(') ||
                        (currentBracket == '}' && parenthesesStack.peek() == '{') ||
                        (currentBracket == ']' && parenthesesStack.peek() == '['))) {
                    parenthesesStack.pop();
                } else {
                    return false;
                }
            }


        }


        return parenthesesStack.isEmpty();
    }


    public static boolean isValidApproachII(String s) {
        Stack<Character> parenthesesStack = new Stack<>();
        HashMap<Character, Character> closeToOpenMapping = new HashMap<>();
        closeToOpenMapping.put(')', '(');
        closeToOpenMapping.put('}', '{');
        closeToOpenMapping.put(']', '[');

        for (char c : s.toCharArray()) {

            if (closeToOpenMapping.containsKey(c)) {
                if (!parenthesesStack.isEmpty() && parenthesesStack.peek() == closeToOpenMapping.get(c)) {
                    parenthesesStack.pop();
                } else {
                    return false;
                }
            } else {
                parenthesesStack.push(c);
            }
        }

        return parenthesesStack.isEmpty();
    }
}
