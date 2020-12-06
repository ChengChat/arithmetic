package offer.thinking.question31;

import java.util.Stack;

/**
 * 面试题31：栈的压入、弹出序列
 *  题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 *  假设压入栈的所有数字均不相等。
 *
 *  例如序列1、2、3、4、5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，
 *  但4、3、5、1、2就不可能是该压栈序列的弹出序列。
 */
public class Main {
    public static void main(String[] args) {
        int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrder = {3, 5, 4, 1, 2};
        boolean flag = isPopOrder(pushOrder, popOrder);
        System.out.println(flag);
    }

    private static boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        if (pushOrder == null || pushOrder.length == 0
                || popOrder == null || popOrder.length == 0 || pushOrder.length == popOrder.length) {
            return false;
        }

        int pPush = 0;
        int pPop = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(pushOrder[pPush]);
        while (pPop < popOrder.length) {
            if (stack.peek() != popOrder[pPop]) {
                if (pPush == pushOrder.length - 1) {
                    return false;
                }
                stack.push(pushOrder[++pPush]);
            } else {
                stack.pop();
                pPop++;
            }
        }
        return true;
    }
}
