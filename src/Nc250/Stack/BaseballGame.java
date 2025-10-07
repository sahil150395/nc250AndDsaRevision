package Nc250.Stack;

import java.util.Stack;

public class BaseballGame {

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"1", "2", "+", "C", "5", "D"}));
        System.out.println(calPoints(new String[]{"5", "D", "+", "C"}));
    }

    public static int calPoints(String[] operations) {
        int totalPoints = 0;
        Stack<Integer> record = new Stack<>();

        for (String operation : operations) {
            switch (operation) {
                case "+":
                    record.push(record.get(record.size() - 1) + record.get(record.size() - 2));
                    break;

                case "C":
                    record.pop();
                    break;

                case "D":
                    record.push(2 * record.peek());
                    break;

                default:
                    record.push(Integer.parseInt(operation));
                    break;
            }
        }

        while (!record.isEmpty()) {
            totalPoints += record.pop();
        }

        return totalPoints;
    }
}
