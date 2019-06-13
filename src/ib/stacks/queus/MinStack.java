package ib.stacks.queus;

import java.util.Stack;

public class MinStack {
    
    private Stack<Integer> stack, minStack;
    
    
    
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        
        return stack.peek();
        
    }

    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
