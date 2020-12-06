package offer.thinking.question30;

import java.util.Comparator;
import java.util.Stack;

public class StackWithMin{
    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public Integer push(Integer item) {
        dataStack.push(item);
        if(minStack.empty() || minStack.peek() > item) {
            minStack.push(item);
        }else {
            minStack.push(minStack.peek());
        }
        return item;
    }

    public synchronized Integer pop() {
        minStack.pop();
        return dataStack.pop();
    }

    public synchronized Integer peek() {
        return dataStack.peek();
    }

    public synchronized Integer min(){
        return minStack.peek();
    }
}
