package offer.thinking.question34;

import offer.SortUtlis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

/**
 *  面试题34：二叉树中和为某一值的路径
 *  题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *  从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Main {
    public static void main(String[] args) {
        BinaryTreeNode treeNode = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(12);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(7);
        treeNode.setLeft(node1);
        treeNode.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        findPath(treeNode,22);

    }

    private static void findPath(BinaryTreeNode treeNode, int key) {
        if(treeNode == null){
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        findPath(treeNode,list,0,key);
    }

    private static void findPath(BinaryTreeNode treeNode, ArrayList<Integer> list, int currentSum, int key) {
        currentSum += treeNode.getValue();
        list.add(treeNode.getValue());
        if(treeNode.getLeft() == null && treeNode.getRight() == null && currentSum == key){
            list.forEach(value -> System.out.print(value + " "));
            System.out.println();
        }
        if(treeNode.getLeft() != null){
            findPath(treeNode.getLeft(),list,currentSum,key);
        }
        if(treeNode.getRight() != null){
            findPath(treeNode.getRight(),list,currentSum,key);
        }
        list.remove(list.size() - 1);
    }
}
