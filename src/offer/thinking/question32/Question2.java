package offer.thinking.question32;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  面试题32（二）：分行从上到下打印二叉树
 *  题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
 */
public class Question2 {
    public static void print(BinaryTreeNode rootNode){
        if(rootNode == null){
            return;
        }
        int toBePrinted = 1;
        int nextLevel = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(rootNode);
        while (!queue.isEmpty()){
            BinaryTreeNode node = queue.remove();
            System.out.print(node.getValue() + " ");
            if(node.getLeft() != null){
                queue.add(node.getLeft());
                nextLevel++;
            }
            if(node.getRight() != null){
                queue.add(node.getRight());
                nextLevel++;
            }
            toBePrinted--;
            if(toBePrinted <= 0){
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }
}
