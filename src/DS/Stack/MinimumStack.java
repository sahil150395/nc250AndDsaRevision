package DS.Stack;

import java.util.Stack;

public class MinimumStack {

    private Stack<Integer> regStack;
    private Stack<Integer> minStack; // this stack will maintain the stack of minimums

    public MinimumStack() {
        this.regStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        regStack.push(val);

        /*
         * If the minStack is empty, then add the value to tha stack
         * It the minStack is not empty and if the value being inserted on top of the stack is less than or
         * equal to the value at the top of the minStack push it on the minStack
         * */
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }

    }

    public void pop() {
        if (regStack.isEmpty()) return;
        int top = regStack.pop();

        /*
         * If the top being popped from the regular stack is equal to the top at the minStack pop that too
         * */
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return regStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
