package DS.Stack;

public class App {

    public static void main(String[] args) {
        /*Stack theStack = new Stack(3);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while (!theStack.isEmpty()) {
            System.out.println(theStack.pop());
        }*/
        System.out.println(reverseString("hello"));

        MyStackUsingOneQueue testStack = new MyStackUsingOneQueue();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);
        testStack.push(5);


        MinimumStack minStack = new MinimumStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(1);
        minStack.push(1);
        minStack.push(4);
        minStack.push(1);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();

    }

    public static String reverseString(String str) {
        Stack strStack = new Stack(str.length());

        for (char c : str.toCharArray()) {
            strStack.push(c);
        }

        StringBuilder reverseString = new StringBuilder();

        while (!strStack.isEmpty()) {
            reverseString.append(strStack.pop());
        }

        return reverseString.toString();
    }
}
