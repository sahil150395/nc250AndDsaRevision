package General.Stack;

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
        q2.offer(x);
        while(!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
