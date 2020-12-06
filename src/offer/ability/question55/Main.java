package offer.ability.question55;

/**
 * 面试题55（一）：二叉树的深度
 * 题目：输入一棵二叉树的根结点，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Main {
    public static void main(String[] args) {
        BinaryTreeNode rootNode = new BinaryTreeNode('a');
        BinaryTreeNode node1 = new BinaryTreeNode('b');
        BinaryTreeNode node2 = new BinaryTreeNode('c');
        BinaryTreeNode node3 = new BinaryTreeNode('d');
        BinaryTreeNode node4 = new BinaryTreeNode('e');
        BinaryTreeNode node5 = new BinaryTreeNode('f');
        BinaryTreeNode node6 = new BinaryTreeNode('g');
        BinaryTreeNode node7 = new BinaryTreeNode('h');
        BinaryTreeNode node8 = new BinaryTreeNode('i');
        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        node4.setLeft(node7);
        node4.setRight(node8);
        BinaryTreeNode.print(rootNode);
        int depth = getTreeDepth(rootNode);
        System.out.println("\n" + depth);

    }

    private static int getTreeDepth(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int left = 1 + getTreeDepth(rootNode.getLeft());
        int right = 1 + getTreeDepth(rootNode.getRight());
        return Math.max(left, right);
    }
}
