package offer.base.question08;

/**
 * 面试题8：二叉树的下一个结点
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
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
        node1.setParent(rootNode);
        rootNode.setRight(node2);
        node2.setParent(rootNode);
        node1.setLeft(node3);
        node3.setParent(node1);
        node1.setRight(node4);
        node4.setParent(node1);
        node2.setLeft(node5);
        node5.setParent(node2);
        node2.setRight(node6);
        node6.setParent(node2);
        node4.setLeft(node7);
        node7.setParent(node4);
        node4.setRight(node8);
        node8.setParent(node4);
        BinaryTreeNode nextNode = getNextNode(node7);
        System.out.println(nextNode.getValue());
    }

    private static BinaryTreeNode getNextNode(BinaryTreeNode node) {
        if(node == null){
            return null;
        }
        BinaryTreeNode nextNode = null;
        // 如果该节点有右子树，那么下一个节点就是右子树的最左节点
        if(node.getRight() != null){
            BinaryTreeNode right = node.getRight();
            while(right.getLeft() != null){
                right = right.getLeft();
            }
            nextNode = right;
        }else if(node.getParent() != null){
            BinaryTreeNode parent = node.getParent();
            while(parent != null && parent.getRight() == node){
                // 如果该节点没有右子树，且该节点是它父节点的右子节点时，
                // 那么我们可以沿着指向父节点的指针一直向上遍历，直到找到一个节点是父节点的左子节点的节点，
                // 那么这个节点的父节点就是我们要找的下一个节点
                node = parent;
                parent = parent.getParent();
            }
            // 如果该节点没有右子树，且该节点是它父节点的左子节点时，那么下一个节点就是它的父节点
            nextNode = parent;
        }

        return nextNode;
    }

}
