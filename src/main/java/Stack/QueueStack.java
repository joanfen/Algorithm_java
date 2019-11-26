package Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #225
 * implement a stack using queue
 */
public class QueueStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private Integer top;
    public QueueStack() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int x) {
        top = x;
        this.queue1.add(x);
    }

    public int pop() {
        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        int pop = queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return pop;
    }

    public int top() {
        return top;
     }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
