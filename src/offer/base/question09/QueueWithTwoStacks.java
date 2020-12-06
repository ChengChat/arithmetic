package offer.base.question09;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class QueueWithTwoStacks {
    private Stack<Character> stack1 = new Stack<>();
    private Stack<Character> stack2 = new Stack<>();

    public void appendTail(Character element) {
        stack1.push(element);
    }

    public void deleteHead() throws Exception {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.empty()){
            throw new Exception("queue is empty");
        }
        stack2.pop();
    }

    public Stack<Character> getStack1() {
        return stack1;
    }

    public Stack<Character> getStack2() {
        return stack2;
    }


}
