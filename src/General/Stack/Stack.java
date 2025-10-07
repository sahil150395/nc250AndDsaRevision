package General.Stack;

public class Stack {

    private int maxSize;
    private char[] stackArray;
    private int top; // index position of the last item placed on the stack

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char val) {
        if (!isFull()) {
            top++;
            stackArray[top] = val;
        } else {
            System.out.println("This stack is already full");
        }
    }

    public char pop() {
        if (!isEmpty()) {
            int oldTop = top;
            top--;
            return stackArray[oldTop];
        } else {
            System.out.println("This stack is already empty");
            return '0';
        }
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return (maxSize - 1 == top);
    }
}
