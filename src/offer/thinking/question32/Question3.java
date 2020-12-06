package offer.thinking.question32;

import java.util.Stack;

/**
 * 面试题32（三）：之字形打印二叉树
 * 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
 */
public class Question3 {
    public static void print(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        Stack<BinaryTreeNode>[] stack = new Stack[2];
        stack[0] = new Stack<>();
        stack[1] = new Stack<>();
        int current = 0;
        int next = 1;
        stack[current].push(rootNode);
        while (!stack[0].empty() || !stack[1].empty()) {
            BinaryTreeNode node = stack[current].pop();
            System.out.print(node.getValue() + " ");
            if (current == 0) {
                if (node.getLeft() != null) {
                    stack[next].push(node.getLeft());
                }
                if (node.getRight() != null) {
                    stack[next].push(node.getRight());
                }
            } else {
                if (node.getRight() != null) {
                    stack[next].push(node.getRight());
                }
                if (node.getLeft() != null) {
                    stack[next].push(node.getLeft());
                }
            }
            if (stack[current].empty()) {
                System.out.println();
                current = 1 - current;
                next = 1 - next;
            }
        }

    }
}
