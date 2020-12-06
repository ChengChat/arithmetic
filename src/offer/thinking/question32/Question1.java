package offer.thinking.question32;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题32（一）：不分行从上往下打印二叉树
 * 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 */
public class Question1 {
    public static void print(BinaryTreeNode rootNode){
        if(rootNode == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(rootNode);
        while (!queue.isEmpty()){
            BinaryTreeNode node = queue.remove();
            System.out.print(node.getValue() + " ");
            if(node.getLeft() != null){
                queue.add(node.getLeft());
            }
            if(node.getRight() != null){
                queue.add(node.getRight());
            }
        }
    }
}
