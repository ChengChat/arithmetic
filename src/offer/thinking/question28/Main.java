package offer.thinking.question28;

/**
 *  面试题28：对称的二叉树
 *  题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和
 *  它的镜像一样，那么它是对称的。
 */
public class Main {
    public static void main(String[] args) {
        BinaryTreeNode rootNode = new BinaryTreeNode('a');
        BinaryTreeNode node1 = new BinaryTreeNode('b');
        BinaryTreeNode node2 = new BinaryTreeNode('b');
        BinaryTreeNode node3 = new BinaryTreeNode('c');
        BinaryTreeNode node4 = new BinaryTreeNode('d');
        BinaryTreeNode node5 = new BinaryTreeNode('d');
        BinaryTreeNode node6 = new BinaryTreeNode('c');
        rootNode.setLeft(node1);
        rootNode.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        boolean flag = isSymmetrical(rootNode);
        System.out.println(flag);
    }

    private static boolean isSymmetrical(BinaryTreeNode rootNode) {
        if(rootNode == null){
            return true;
        }

        return isSymmetrical(rootNode,rootNode);
    }

    private static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null){
            return false;
        }

        if(!root1.getValue().equals(root2.getValue())){
            return false;
        }

        return isSymmetrical(root1.getLeft(),root2.getRight())
                && isSymmetrical(root1.getRight(),root2.getLeft());
    }
}
