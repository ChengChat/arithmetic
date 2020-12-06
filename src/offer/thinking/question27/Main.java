package offer.thinking.question27;

import jdk.internal.org.objectweb.asm.Handle;
import search.ordered.Binary;

/**
 *  面试题27：二叉树的镜像
 *  题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
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
        mirrorRecursively(rootNode);
        System.out.println();
        BinaryTreeNode.print(rootNode);
    }

    private static void mirrorRecursively(BinaryTreeNode rootNode) {
        if(rootNode == null){
            return;
        }

        if(rootNode.getLeft() == null && rootNode.getRight() == null){
            return;
        }

        BinaryTreeNode tempNode = rootNode.getLeft();
        rootNode.setLeft(rootNode.getRight());
        rootNode.setRight(tempNode);

        mirrorRecursively(rootNode.getLeft());
        mirrorRecursively(rootNode.getRight());
    }
}
