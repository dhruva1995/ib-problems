package ib.stacks.queus;

import java.util.Stack;

public class MinStackWithoutExtraSpace {
    
    Stack<Integer> stack;
    
    int min;
    
    public MinStackWithoutExtraSpace() {
        stack = new Stack<>();
        min = -1;
    }
    
    public void push(int x) {
    	if(stack.isEmpty()) {
    		this.min = x;
    		stack.push(x);
    	} else if(x <= min) {
    		stack.push(min);
    		stack.push(x);
    		min = x;
    	} else {
    		stack.push(min - x);
    	}
    }

    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        
        if(stack.peek() < min) {
        	stack.pop();
        } else {
        	stack.pop();
        	if(!stack.isEmpty()) {
        		min = stack.pop();
        	} else {
        		min = -1;
        	}
        }
    }

    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        
        if(stack.peek() < min) {
        	return min - stack.peek();
        } else {
        	return min;
        }
        
    }

    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        }
        return min;
    }
    
    public static void main(String[] args) {
		MinStackWithoutExtraSpace m = new MinStackWithoutExtraSpace();
		m.push(1);
		System.out.println(m.getMin());
		m.push(2);
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		m.push(0);
		System.out.println(m.getMin());
		m.push(-1);
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		m.push(5);
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
		m.pop();
		System.out.println(m.getMin());
	}
}
