package offer.thinking.question37;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试题37：序列化二叉树
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树。
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
        serialize(treeNode);
        BinaryTreeNode treeNode1 = deserialize();

    }

    private static BinaryTreeNode deserialize() {

        FileReader fileReader = null;
        BufferedReader br = null;
        BinaryTreeNode treeNode = null;
        try {
            fileReader = new FileReader("src/offer/thinking/question37/serialize.txt");
            br = new BufferedReader(fileReader);
            String s = br.readLine();
            String[] split = s.split(",");
            List<String> list = Arrays.asList(split);
            treeNode = deserialize(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return treeNode;
    }

    private static BinaryTreeNode deserialize(List<String> list) {
        if(!list.isEmpty()) {
            String node = list.remove(0);
            if (!"$".equals(node)) {
                BinaryTreeNode treeNode = new BinaryTreeNode(Integer.parseInt(node));
                treeNode.setLeft(deserialize(list));
                treeNode.setRight(deserialize(list));
                return treeNode;
            }
        }
        return null;
    }

    private static void serialize(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        try {
            fileWriter = new FileWriter("src/offer/thinking/question37/serialize.txt");
            bw = new BufferedWriter(fileWriter);
            serialize(treeNode, bw);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static void serialize(BinaryTreeNode treeNode, BufferedWriter bw) throws IOException {
        if (treeNode == null) {
            bw.write("$,");
            return;
        }
        bw.write(treeNode.getValue() + ",");

        serialize(treeNode.getLeft(), bw);
        serialize(treeNode.getRight(), bw);
    }
}

