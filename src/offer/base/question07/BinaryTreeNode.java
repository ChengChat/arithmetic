package offer.base.question07;

/**
 * 二叉树
 */
public class BinaryTreeNode {

    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private int value;

    public static void print(BinaryTreeNode rootNode) {
        if (rootNode != null) {
            print(rootNode.left);
            System.out.print(rootNode.value + " ");
            print(rootNode.right);
        }

    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
