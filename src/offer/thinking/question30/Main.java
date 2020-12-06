package offer.thinking.question30;

/**
 * 面试题30：包含min函数的栈
 *  题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 *  在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 */
public class Main {
    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        stack.push(1);
        stack.push(0);
        stack.pop();
        stack.pop();
        Integer min = stack.min();
        System.out.println(min);
    }
}
