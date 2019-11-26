package Stack;

import java.util.Stack;

/**
 * min stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * #155
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        Integer pop = stack.pop();
        if (pop.equals(min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (min.isEmpty()) return Integer.MIN_VALUE;
        return min.peek();
    }
}
