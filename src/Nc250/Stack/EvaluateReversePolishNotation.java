package Nc250.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {


    public static void main(String[] args) {
        System.out.println(evalRPNBruteForce(new String[]{"1", "2", "+", "3", "*", "4", "-"}));
        System.out.println(evalRPNBruteForce(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPNBruteForce(new String[]{"2", "1", "+", "3", "*"}));
    }


    public static int evalRPNBruteForce(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        for (String token : tokens) {

            switch (token) {
                case "+":
                    operands.push(operands.pop() + operands.pop());
                    break;

                case "-":
                    int operand1 = operands.pop();
                    int operand2 = operands.pop();
                    operands.push(operand2 - operand1);
                    break;

                case "/":
                    int op1 = operands.pop();
                    int op2 = operands.pop();
                    operands.push(op2 / op1);
                    break;

                case "*":
                    operands.push(operands.pop() * operands.pop());
                    break;

                default:
                    operands.push(Integer.parseInt(token));
                    break;
            }

        }
        return operands.pop();
    }
}