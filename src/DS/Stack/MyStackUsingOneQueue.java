package DS.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackUsingOneQueue {

    private Queue<Integer> q;

    public MyStackUsingOneQueue() {
        this.q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);

        for (int i = q.size() - 1; i > 0; i--) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
