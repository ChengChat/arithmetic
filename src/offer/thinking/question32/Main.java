package offer.thinking.question32;

/**
 * 从上到下打印二叉树
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

        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);

        Question1.print(rootNode);
        System.out.println();
        Question2.print(rootNode);
        System.out.println();
        Question3.print(rootNode);
    }
}
