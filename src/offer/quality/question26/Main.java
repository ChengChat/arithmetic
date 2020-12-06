package offer.quality.question26;

/**
 * 面试题26：树的子结构
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 */
public class Main {

    public static void main(String[] args) {
        BinaryTreeNode rootNode1 = new BinaryTreeNode('8');
        BinaryTreeNode node1 = new BinaryTreeNode('8');
        BinaryTreeNode node2 = new BinaryTreeNode('7');
        BinaryTreeNode node3 = new BinaryTreeNode('9');
        BinaryTreeNode node4 = new BinaryTreeNode('2');
        BinaryTreeNode node5 = new BinaryTreeNode('4');
        BinaryTreeNode node6 = new BinaryTreeNode('7');
        rootNode1.setLeft(node1);
        rootNode1.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node4.setRight(node5);
        node4.setRight(node6);

        BinaryTreeNode rootNode2 = new BinaryTreeNode('8');
        BinaryTreeNode node7 = new BinaryTreeNode('9');
        BinaryTreeNode node8 = new BinaryTreeNode('2');
        rootNode2.setLeft(node7);
        rootNode2.setRight(node8);

        boolean result = hasSubTree(rootNode1, rootNode2);
        System.out.println(result);
    }

    private static boolean hasSubTree(BinaryTreeNode rootNode1, BinaryTreeNode rootNode2) {
        boolean result = false;
        if (rootNode1 != null && rootNode2 != null) {
            if (rootNode1.getValue() == rootNode2.getValue()) {
                result = doesTree1HaveTree2(rootNode1, rootNode2);
            }
            if (!result) {
                result = hasSubTree(rootNode1.getLeft(), rootNode2);
            }
            if (!result) {
                result = hasSubTree(rootNode1.getRight(), rootNode2);
            }
        }
        return result;
    }

    private static boolean doesTree1HaveTree2(BinaryTreeNode rootNode1, BinaryTreeNode rootNode2) {
        if (rootNode2 == null) {
            return true;
        }
        if (rootNode1 == null) {
            return false;
        }
        if (rootNode1.getValue() != rootNode2.getValue()) {
            return false;
        }
        return doesTree1HaveTree2(rootNode1.getLeft(), rootNode2.getLeft())
                && doesTree1HaveTree2(rootNode1.getRight(), rootNode2.getRight());
    }
}
