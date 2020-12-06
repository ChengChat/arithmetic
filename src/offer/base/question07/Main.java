package offer.base.question07;

import javax.naming.directory.InvalidAttributesException;

/**
 * 面试题7：重建二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1, 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，
 * 则重建出图2.6所示的二叉树并输出它的头结点。
 */
public class Main {

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode rootNode = construct(preOrder, inOrder);
        BinaryTreeNode.print(rootNode);
    }

    private static BinaryTreeNode construct(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null ||
                preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        return constructCore(preOrder, inOrder,
                0, preOrder.length - 1,
                0, inOrder.length - 1);
    }

    private static BinaryTreeNode constructCore(int[] preOrder, int[] inOrder,
                                                int startPreOrder, int endPreOrder,
                                                int startInOrder, int endInOrder) {
        int root = preOrder[startPreOrder];
        BinaryTreeNode rootNode = new BinaryTreeNode(root);

        if (startPreOrder == endPreOrder) {
            if (startInOrder == endInOrder && preOrder[startPreOrder] == inOrder[startInOrder]) {
                return rootNode;
            } else {
                throw new IllegalArgumentException();
            }
        }

        int rootInOrder = startInOrder;
        while (rootInOrder <= endInOrder && inOrder[rootInOrder] != root) {
            rootInOrder++;
        }

        int leftLength = rootInOrder - startInOrder;
        int leftPreOrderEnd = startPreOrder + leftLength;
        if (leftLength > 0) {
            rootNode.setLeft(constructCore(preOrder, inOrder,
                    startPreOrder + 1, leftPreOrderEnd,
                    startInOrder, rootInOrder - 1));
        }

        if (leftLength < endPreOrder - startPreOrder) {
            rootNode.setRight(constructCore(preOrder, inOrder,
                    leftPreOrderEnd + 1, endPreOrder,
                    rootInOrder + 1, endInOrder));
        }
        return rootNode;
    }
}
