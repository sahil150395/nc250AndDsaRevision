package DS.Stack;

import java.util.Queue;
import java.util.LinkedList;

//Implement Stack Using Two Queues
public class MyStackUsingTwoQueues {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStackUsingTwoQueues() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.offer(x); // in a queue offer add the element to the last of the queue
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll(); // in a queue poll removes the head of the queue
    }

    public int top() {
        return q1.peek(); // in a queue peek returns the value head of the queue
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
